package com.fukuoka.beatc.weatherforecast.models;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.fukuoka.beatc.weatherforecast.R;
import com.fukuoka.beatc.weatherforecast.activity.MainActivity;

/**
 * Created by ted on 2017/06/21.
 */

public class NavigationManager {

    public static  void onNavigationItemSelected(AppCompatActivity activity, MenuItem item){

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Toast.makeText(activity, "camera", Toast.LENGTH_SHORT).show();
            SelectedCamera(activity);
        } else if (id == R.id.nav_home) {
            Toast.makeText(activity, "nav_home", Toast.LENGTH_SHORT).show();
            SelectedHome(activity);
        } else if (id == R.id.nav_gallery) {
            Toast.makeText(activity, "nav_gallery", Toast.LENGTH_SHORT).show();
            SelectedGallery(activity);
        } else if (id == R.id.nav_slideshow) {
            Toast.makeText(activity, "nav_slideshow", Toast.LENGTH_SHORT).show();
            SelectedSlideshow(activity);
        } else if (id == R.id.nav_manage) {
            Toast.makeText(activity, "nav_manage", Toast.LENGTH_SHORT).show();
            SelectedManage(activity);
        } else if (id == R.id.nav_share) {
            Toast.makeText(activity, "nav_share", Toast.LENGTH_SHORT).show();
            SelectedShare(activity);
        } else if (id == R.id.nav_send) {
            Toast.makeText(activity, "nav_send", Toast.LENGTH_SHORT).show();
            SelectedSend(activity);
        }
    }
    private static void SelectedHome(AppCompatActivity activity){
        Intent intent = new Intent(activity, com.fukuoka.beatc.weatherforecast.activity.MainActivity.class);
        intent.putExtra("test", "TEST STRING");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        Toast.makeText(activity, "Launch", Toast.LENGTH_SHORT).show();
        activity.finish();
    }
    private static void SelectedCamera(AppCompatActivity activity){
        Intent intent = new Intent(activity, com.fukuoka.beatc.weatherforecast.activity.BasicActivity.class);
        //intent.setClassName("org.jpn.techbooster.demo.intent","org.jpn.techbooster.demo.intent.SubActivity");
        intent.putExtra("test", "TEST STRING");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        Toast.makeText(activity, "Launch", Toast.LENGTH_SHORT).show();
        activity.finish();
    }
    private static void SelectedGallery(AppCompatActivity activity){
        Intent intent = new Intent(activity, com.fukuoka.beatc.weatherforecast.activity.BasicActivity.class);
        //intent.setClassName("org.jpn.techbooster.demo.intent","org.jpn.techbooster.demo.intent.SubActivity");
        intent.putExtra("test", "TEST STRING");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        Toast.makeText(activity, "Launch", Toast.LENGTH_SHORT).show();
        activity.finish();
    }
    private static void SelectedSlideshow(AppCompatActivity activity){
        Intent intent = new Intent(activity, com.fukuoka.beatc.weatherforecast.activity.TabHostActivity.class);
        //intent.setClassName("org.jpn.techbooster.demo.intent","org.jpn.techbooster.demo.intent.SubActivity");
        intent.putExtra("test", "TEST STRING");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        Toast.makeText(activity, "Launch", Toast.LENGTH_SHORT).show();
        activity.finish();
    }
    private static void SelectedManage(AppCompatActivity activity){
        Intent intent = new Intent(activity, com.fukuoka.beatc.weatherforecast.activity.TabbedActivity.class);
        //intent.setClassName("org.jpn.techbooster.demo.intent","org.jpn.techbooster.demo.intent.SubActivity");
        intent.putExtra("test", "TEST STRING");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        Toast.makeText(activity, "Launch", Toast.LENGTH_SHORT).show();
        activity.finish();
    }
    private static void SelectedShare(AppCompatActivity activity){
        Intent intent = new Intent(activity, com.fukuoka.beatc.weatherforecast.activity.TabbedActivity.class);
        //intent.setClassName("org.jpn.techbooster.demo.intent","org.jpn.techbooster.demo.intent.SubActivity");
        intent.putExtra("test", "TEST STRING");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        Toast.makeText(activity, "Launch", Toast.LENGTH_SHORT).show();
        activity.finish();
    }
    private static void SelectedSend(AppCompatActivity activity){
        Intent intent = new Intent(activity, com.fukuoka.beatc.weatherforecast.activity.BasicActivity.class);
        //intent.setClassName("org.jpn.techbooster.demo.intent","org.jpn.techbooster.demo.intent.SubActivity");
        intent.putExtra("test", "TEST STRING");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        Toast.makeText(activity, "Launch", Toast.LENGTH_SHORT).show();
        activity.finish();
    }
}
