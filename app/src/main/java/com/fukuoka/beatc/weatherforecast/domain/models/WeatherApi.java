package com.fukuoka.beatc.weatherforecast.domain.models;

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


import com.fukuoka.beatc.weatherforecast.domain.utils.Util;

public class WeatherApi {
    private static final String USER_AGENT ="WeatherForcasts Sample";
    private static final String URL = "http://weather.livedoor.com/forecast/webservice/json/v1?city=";

    //public static String getWeather(Context context, String pointId) throws IOException {

    public static WeatherForecast getWeather(Context context, String pointId) throws IOException, JSONException{

        URL url = new URL(URL + pointId);
        HttpURLConnection urlConnection = (java.net.HttpURLConnection) url.openConnection();
        String ret = "";
        Util.Log(Util.LogType.DEBUG, "URL:" +  URL + pointId);
        Util.Log(Util.LogType.DEBUG, "### getWeather() START");
        try {
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            ret = readStream(in);
            Util.Log(Util.LogType.DEBUG, "### Res Accept:");
            Util.Log(Util.LogType.DEBUG, ret.toString());
            Util.Log(Util.LogType.DEBUG, "### END ###");
        } finally {
            urlConnection.disconnect();
        }
        Util.Log(Util.LogType.DEBUG, "### getWeather() END");
        return new WeatherForecast(new JSONObject(ret.toString()));
    }

    private static String readStream(InputStream is) {
        Util.Log(Util.LogType.DEBUG, "### readStream() SART");
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
        Util.Log(Util.LogType.DEBUG, "### readStream() END");
        return bo.toString();
    }
}
