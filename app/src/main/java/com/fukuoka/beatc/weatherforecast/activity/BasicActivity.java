package com.fukuoka.beatc.weatherforecast.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.fukuoka.beatc.weatherforecast.R;

public class BasicActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

//        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        // ナビゲーションの設定
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view2);
        navigationView.setNavigationItemSelectedListener(this);

    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Toast.makeText(BasicActivity.this, "camera", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_gallery) {
            Toast.makeText(BasicActivity.this, "nav_gallery", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_slideshow) {
            Toast.makeText(BasicActivity.this, "nav_slideshow", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_manage) {
            Toast.makeText(BasicActivity.this, "nav_manage", Toast.LENGTH_SHORT).show();
            //TransTabActivity();
        } else if (id == R.id.nav_share) {
            Toast.makeText(BasicActivity.this, "nav_share", Toast.LENGTH_SHORT).show();
            //TransTabActivity();
        } else if (id == R.id.nav_send) {
            Toast.makeText(BasicActivity.this, "nav_send", Toast.LENGTH_SHORT).show();
            //TransBasicActivity();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void FloatingActionButtonEvent(View view){
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
//    private  void TransTabActivity(){
//        Intent intent = new Intent(this, com.fukuoka.beatc.weatherforecast.activity.TabbedActivity.class);
//        //intent.setClassName("org.jpn.techbooster.demo.intent","org.jpn.techbooster.demo.intent.SubActivity");
//        intent.putExtra("test", "TEST STRING");
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(intent);
//        finish();
//    }
//    private  void TransBasicActivity(){
//        Intent intent = new Intent(this, com.fukuoka.beatc.weatherforecast.activity.BasicActivity.class);
//        //intent.setClassName("org.jpn.techbooster.demo.intent","org.jpn.techbooster.demo.intent.SubActivity");
//        intent.putExtra("test", "TEST STRING");
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(intent);
//        finish();
//    }

}
