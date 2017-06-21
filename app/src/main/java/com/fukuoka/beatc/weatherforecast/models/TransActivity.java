package com.fukuoka.beatc.weatherforecast.models;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.fukuoka.beatc.weatherforecast.activity.MainActivity;

/**
 * Created by ted on 2017/06/21.
 */

public class TransActivity {
    public static void TransTabActivity(AppCompatActivity activity){
        Intent intent = new Intent(activity, com.fukuoka.beatc.weatherforecast.activity.TabbedActivity.class);
        //intent.setClassName("org.jpn.techbooster.demo.intent","org.jpn.techbooster.demo.intent.SubActivity");
        intent.putExtra("test", "TEST STRING");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        Toast.makeText(activity, "Launch", Toast.LENGTH_SHORT).show();
        activity.finish();
    }
    public static  void TransBasicActivity(AppCompatActivity activity){
        Intent intent = new Intent(activity, com.fukuoka.beatc.weatherforecast.activity.BasicActivity.class);
        //intent.setClassName("org.jpn.techbooster.demo.intent","org.jpn.techbooster.demo.intent.SubActivity");
        intent.putExtra("test", "TEST STRING");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        Toast.makeText(activity, "Launch", Toast.LENGTH_SHORT).show();
        activity.finish();
    }
}
