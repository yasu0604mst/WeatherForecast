package com.fukuoka.beatc.weatherforecast.activity;

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
import java.util.ArrayList;

import android.os.Handler;

import com.fukuoka.beatc.weatherforecast.R;
import com.fukuoka.beatc.weatherforecast.models.Product;
import com.fukuoka.beatc.weatherforecast.models.MyAdapter;
import com.fukuoka.beatc.weatherforecast.models.NavigationManager;
import com.fukuoka.beatc.weatherforecast.models.apis.WeatherApi;
import com.fukuoka.beatc.weatherforecast.models.apis.WeatherForecast;
import com.fukuoka.beatc.weatherforecast.utils.Util;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;


import org.json.JSONException;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private TextView textView;
    private Handler handler;
    ListView lv;
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
//        String[] members = { "mhidaka", "rongon_xp", "kacchi0516", "kobashinG",
//                "seit", "kei_i_t", "furusin_oriver" };
//
//        lv = (ListView) findViewById(R.id.listView1);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                this,
//                android.R.layout.simple_expandable_list_item_1,
//                members);
//        //adapter.add("added");
//        lv.setAdapter(adapter);

        lv = (ListView) findViewById(R.id.listView1);

        ArrayList<Product> list = new ArrayList<>();
        MyAdapter myAdapter = new MyAdapter(MainActivity.this);
        myAdapter.setProductList(list);
        lv.setAdapter(myAdapter);

        list.add(new Product("リンゴ","津軽産地の美味しいリンゴです",100,150));
        list.add(new Product("ばなな","パナマ産のバナナです。すっきり美味しい",100,250));
        list.add(new Product("イチゴ","福岡産のあまおう。美味しくてあまい",100,150));
        list.add(new Product("みかん","愛媛産のミカンです",100,150));
        list.add(new Product("メロン","夕張産の甘いメロンです。すっきり美味しい",100,150));
        list.add(new Product("もも","岡山産の甘いももです。夏にぴったりの美味しい",100,150));

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
}
