package com.fukuoka.beatc.weatherforecast.domain.usecase;

/**
 * Created by ted on 2017/05/22.
 */
import android.content.Context;
import android.os.AsyncTask;

import com.fukuoka.beatc.weatherforecast.domain.models.WeatherApi;
import com.fukuoka.beatc.weatherforecast.domain.models.WeatherForecast;

import java.io.IOException;
import org.json.JSONException;

import com.fukuoka.beatc.weatherforecast.domain.utils.Util;

public class GetWeatherForecastApiTask extends AsyncTask<String, Void, WeatherForecast> {
    private final Context context;
    public Exception exception;
    public GetWeatherForecastApiTask(Context context){
        Util.Log(Util.LogType.DEBUG, "### GetWeatherForecastApiTask() START ###");
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
