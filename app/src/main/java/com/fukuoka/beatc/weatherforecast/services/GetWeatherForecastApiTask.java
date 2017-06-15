package com.fukuoka.beatc.weatherforecast.services;

/**
 * Created by ted on 2017/05/22.
 */
import android.content.Context;
import android.os.AsyncTask;

import com.fukuoka.beatc.weatherforecast.models.apis.WeatherApi;
import com.fukuoka.beatc.weatherforecast.models.apis.WeatherForecast;

import java.io.IOException;
import org.json.JSONException;

public class GetWeatherForecastApiTask extends AsyncTask<String, Void, WeatherForecast> {
    private final Context context;
    public Exception exception;
    public GetWeatherForecastApiTask(Context context){
        System.out.println("GetWeatherForecastApiTask() Start");
        this.context = context;
    }
    @Override
    protected WeatherForecast doInBackground(String...params){
        try{
            return WeatherApi.getWeather(context,params[0]);
        }catch (IOException e) {
            exception = e;
        }
        catch (JSONException e) {
            exception = e;
        }
        return null;
    }
}
