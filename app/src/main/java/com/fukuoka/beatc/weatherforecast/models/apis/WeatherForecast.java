package com.fukuoka.beatc.weatherforecast.models.apis;

/**
 * Created by ted on 2017/05/30.
 */

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

import com.fukuoka.beatc.weatherforecast.utils.Util;
import com.fukuoka.beatc.weatherforecast.utils.Util.*;

public class WeatherForecast {
    public final Location location;
    public final List<Forecast> forecastList = new ArrayList<Forecast>();
    public WeatherForecast(JSONObject jsonObject)throws JSONException{
        //Util.Log(Util.LogType.DEBUG, "### getWeather() START");
        Util.Log(Util.LogType.DEBUG, "### WeatherForecast() START ###");
        JSONObject locationObject = jsonObject.getJSONObject("location");
        location = new Location(locationObject);
        JSONArray forecastArray = jsonObject.getJSONArray("forecasts");
        int len = forecastArray.length();
        for(int i = 0; i < len ; i++) {
            JSONObject forecastJson = forecastArray.getJSONObject(i);
            Forecast forecast = new Forecast(forecastJson);
            forecastList.add(forecast);
        }
        Util.Log(Util.LogType.DEBUG, "### WeatherForecast() END ###");
    }
    public class Location {
        public final String area;
        public final String prefecture;
        public final String city;
        public Location(JSONObject jsonObject) throws JSONException{
            Util.Log(Util.LogType.DEBUG, "### Location() START ###");
            area = jsonObject.getString("area");
            prefecture = jsonObject.getString("prefecture");
            city = jsonObject.getString("city");
            Util.Log(Util.LogType.DEBUG, "### Location() END ###");
        }
    }
    public class Forecast {
        public final String date;
        public final String dataLabel;
        public final String telop;
        public final Image image;
        public final Temperature temperature;
        public Forecast(JSONObject jsonObject) throws JSONException{
            Util.Log(Util.LogType.DEBUG, "### Forecast() START ###");
            date = jsonObject.getString("date");
            dataLabel = jsonObject.getString("dateLabel");
            telop = jsonObject.getString("telop");
            image = new Image(jsonObject.getJSONObject("image"));
            temperature = new Temperature(jsonObject.getJSONObject("temperature"));
            Util.Log(Util.LogType.DEBUG, "### Forecast() END ###");
        }
    }
    public class Image {
        public final String title;
        public final String link;
        public final String url;
        public final int width;
        public final int height;
        public Image(JSONObject jsonObject) throws JSONException {
            Util.Log(Util.LogType.DEBUG, "### Image() START ###");
            title = jsonObject.getString("title");
            if(jsonObject.has("link")) {
                link = jsonObject.getString("link");
            }else{
                link = null;
            }
            url = jsonObject.getString("url");
            width = jsonObject.getInt("width");
            height = jsonObject.getInt("height");
            Util.Log(Util.LogType.DEBUG, "### Image() END ###");
        }
    }
    public class Temperature {
        public final Temp min;
        public final Temp max;
        public Temperature(JSONObject jsonObject)throws JSONException {
            Util.Log(Util.LogType.DEBUG, "### Temperature() START ###");
            if(!jsonObject.isNull("min")) {
                min = new Temp(jsonObject.getJSONObject("min"));
            }else {
                min = new Temp(null);
            }
            if(!jsonObject.isNull("max")){
                max = new Temp(jsonObject.getJSONObject("max"));
            }else{
                max = new Temp(null);
            }
            Util.Log(Util.LogType.DEBUG, "### Temperature() END ###");
        }
        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer(); // 最低 気温 / 最高 気温
            if (min. celsius != null) {
                sb. append( min. celsius);
            } else {
                sb. append(" - ");
            }
            sb. append("℃ / ");
            if (max. celsius != null) {
                sb. append( max. celsius);
            } else {
                sb. append(" - ");
            }
            sb. append("℃");
            return sb. toString();
        }
    }
    public class Temp{
        public final String celsius;
        public final String fahrenheit;
        public Temp(JSONObject jsonObject) throws JSONException{
            if(jsonObject == null) {
                celsius = null;
                fahrenheit = null;
                return;
            }
            celsius = jsonObject.getString("celsius");
            fahrenheit = jsonObject.getString("fahrenheit");
        }
    }

}
