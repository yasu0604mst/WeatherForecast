package com.fukuoka.beatc.weatherforecast.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import java.io.IOException;
import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import com.fukuoka.beatc.weatherforecast.R;
import com.fukuoka.beatc.weatherforecast.models.apis.WeatherApi;
import com.fukuoka.beatc.weatherforecast.models.apis.WeatherForecast;
import com.fukuoka.beatc.weatherforecast.services.GetWeatherForecastApiTask;
import com.fukuoka.beatc.weatherforecast.utils.Util;

import org.json.JSONException;

/**
 * Created by ted on 2017/05/30.
 */

public class MyActivity extends Activity {
    private TextView textView;
    public class GetWeatherForcastTask extends GetWeatherForecastApiTask {
        public GetWeatherForcastTask (Context context) {
            super(context);
        }
        @Override
        public void onPostExecute(WeatherForecast data) {
            super.onPostExecute(data);
            if(data != null) {
                Util.Log(Util.LogType.DEBUG, "### onPostExecute() ###");
                //textView.setText(data);
                textView.setText(data.location.area + ""+ data.location.prefecture + " " + data.location.city);
                for(WeatherForecast.Forecast forecast : data.forecastList) {
                    textView.append("\n");
                    textView.append(forecast.dataLabel + " " + forecast.telop);
                }
            }else if ( exception != null) {
                Toast.makeText(MyActivity.this,exception.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        handler = new Handler();
        setContentView(R.layout.content_main);
        textView = (TextView) findViewById(R.id.tv_content);
        Thread thread = new Thread() {
            @Override
            public void run() {
                try{
                    final WeatherForecast data = WeatherApi.getWeather(MyActivity.this,"400040");
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //textView.setText(data);
                            textView.setText(data.location.area + ""+ data.location.prefecture + " " + data.location.city);
                            for(WeatherForecast.Forecast forecast : data.forecastList) {
                                textView.append("\n");
                                textView.append(forecast.dataLabel + " " + forecast.telop);
                            }
                        }
                    });
                } catch (final JSONException e) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MyActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    });
                }catch (final IOException e) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MyActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        };
        thread.start();
        new GetWeatherForcastTask(this).execute("400040");
    }
}
