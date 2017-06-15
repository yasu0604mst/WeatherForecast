package com.fukuoka.beatc.weatherforecast.models.apis;

/**
 * Created by ted on 2017/05/22.
 */

import android.content.Context;

import java.net.HttpURLConnection;
import java.io.IOException;
import java.net.URL;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherApi {
    private static final String USER_AGENT ="WeatherForcasts Sample";
    private static final String URL = "http://weather.livedoor.com/forecast/webservice/json/v1?city=";

    //public static String getWeather(Context context, String pointId) throws IOException {

    public static WeatherForecast getWeather(Context context, String pointId) throws IOException, JSONException{

        URL url = new URL(URL + pointId);
        HttpURLConnection urlConnection = (java.net.HttpURLConnection) url.openConnection();
        String ret = "";
        System.out.println("URL:" +  URL + pointId);
        System.out.println("getWeather() START");
        try {
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            ret = readStream(in);
            System.out.println("Res Accept:");
            System.out.println(ret.toString());
        } finally {
            urlConnection.disconnect();
        }
        System.out.println("getWeather() END");
        return new WeatherForecast(new JSONObject(ret.toString()));
    }

    private static String readStream(InputStream is) {
        System.out.println("readStream() SART");
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        try {
            int i = is.read();
            while(i != -1) {
                bo.write(i);
                i = is.read();
            }
        } catch (IOException e) {
            return "";
        }
        System.out.println("readStream() END");
        return bo.toString();
    }
}
