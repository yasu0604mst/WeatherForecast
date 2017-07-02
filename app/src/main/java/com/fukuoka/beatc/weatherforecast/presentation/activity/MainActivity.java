package com.fukuoka.beatc.weatherforecast.presentation.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;

import android.os.Handler;

import com.fukuoka.beatc.weatherforecast.R;
import com.fukuoka.beatc.weatherforecast.domain.models.ProductManager;
import com.fukuoka.beatc.weatherforecast.domain.models.MyAdapter;
import com.fukuoka.beatc.weatherforecast.domain.models.NavigationManager;
import com.fukuoka.beatc.weatherforecast.domain.models.WeatherApi;
import com.fukuoka.beatc.weatherforecast.domain.models.WeatherForecast;
import com.fukuoka.beatc.weatherforecast.domain.utils.Util;
import com.fukuoka.beatc.weatherforecast.presentation.presenter.MainPresenter;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;


import org.json.JSONException;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,IMainActivityViews {
    private TextView textView;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private Handler handler;
    ListView lv;
    private MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //アクションバーの設定
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        //フローティングボタンの設定
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FloatingActionButtonEvent(view);
//            }
//        });

        //ドロアのトグル
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //ボタンバーの設定
        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_favorites) {
                    Util.Log(Util.LogType.DEBUG, "### tab_favorites ###");
                }
                if (tabId == R.id.tab_category) {
                    Util.Log(Util.LogType.DEBUG, "### tab_category ###");
                }
                if (tabId == R.id.tab_add) {
                    Util.Log(Util.LogType.DEBUG, "### tab_add ###");
                }
            }
        });
        //ListViewの設定
        lv = (ListView) findViewById(R.id.listView1);
        MyAdapter myAdapter = new MyAdapter(MainActivity.this);
        myAdapter.setProductList((new ProductManager()).MakeProductList());
        lv.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();


        //リスト項目がクリックされた時の処理
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListView listView = (ListView) parent;
                String item = (String) listView.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), item + " clicked",
                        Toast.LENGTH_LONG).show();
            }
        });
        //リストが押された時の処理
        lv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //リスト項目が選択された時の処理
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ListView listView = (ListView) parent;
                String item = (String) listView.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), item + " selected",
                        Toast.LENGTH_LONG).show();
            }
            //リスト項目がなにも選択されていない時の処理
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "no item selected",
                        Toast.LENGTH_LONG).show();
            }
        });

        //リスト項目が長押しされた時の処理
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ListView listView = (ListView) parent;
                String item = (String) listView.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), item + " long clicked",
                        Toast.LENGTH_LONG).show();
                return false;
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(getApplicationContext(),  "Item clicked",
                            Toast.LENGTH_LONG).show();
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),  "Item Long clicked",
                        Toast.LENGTH_LONG).show();
                return false;
            }
        });
        lv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),  " ItemSelected",
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(),  "Item nothing selected",
                        Toast.LENGTH_LONG).show();
            }
        });

        //MainPresenterで値の設定
        mMainPresenter = new MainPresenter();
        mMainPresenter.setActivity(this);
        mMainPresenter.setView();


        // ナビゲーションの設定
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //天気予報の表示
        textView = (TextView) findViewById(R.id.tv_content);
        handler = new Handler();
        Thread thread = new Thread() {
            @Override
            public void run() {
                try{
                    Util.Log(Util.LogType.DEBUG, "### Obtain Weather START ###");
                    final WeatherForecast data = WeatherApi.getWeather(MainActivity.this,"400040");
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Util.Log(Util.LogType.DEBUG, "### RUN() ###");
                            //textView.setText(data.location.area);
                            textView.setText(data.location.area + ""+ data.location.prefecture + " " + data.location.city);
                            Util.Log(Util.LogType.DEBUG, "### setText() ###");
                            for(WeatherForecast.Forecast forecast : data.forecastList) {
                                textView.append("\n");
                                textView.append(forecast.dataLabel + " " + forecast.telop);
                            }
                        }
                    });
                    Util.Log(Util.LogType.DEBUG, "### Obtain Weather END ###");

                }catch(final IOException e) {

                    Util.Log(Util.LogType.DEBUG, "### IOException:" + e.toString());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this,"IOException is occurred",Toast.LENGTH_SHORT).show();
                        }
                    });
                    System.out.println("IOException END");
                }
                catch(final JSONException e) {

                    System.out.println("JSONException START");
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this,"JSONException is occurred",Toast.LENGTH_SHORT).show();
                        }
                    });
                    System.out.println("JSONException END");
                }
            }
        };
        thread.start();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        NavigationManager.onNavigationItemSelected(this, item);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void FloatingActionButtonEvent(View view){
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public void setNameView1(String name){
        textView1 = (TextView) findViewById(R.id.tv_name1);
        textView1.setText(name);
    }
    @Override
    public void setNameView2(String name){
        textView2 = (TextView) findViewById(R.id.tv_name2);
        textView2.setText(name);
    }
    @Override
    public void setNameView3(String name){
        textView3 = (TextView) findViewById(R.id.tv_name3);
        textView3.setText(name);
    }
}
