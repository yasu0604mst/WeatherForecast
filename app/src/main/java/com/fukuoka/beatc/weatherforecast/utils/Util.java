package com.fukuoka.beatc.weatherforecast.utils;
import com.fukuoka.beatc.weatherforecast.consts.*;
import android.util.Log;
/**
 * Created by ted on 2017/06/18.
 */

public class Util {
    public static String getClassName() {
        return Thread.currentThread().getStackTrace()[2].getClassName();
    }
    public static LogType logType = LogType.DEBUG;
    public static enum LogType{
        DEBUG,
        INFO,
        ALL
    }
    public static String Log(LogType type, String msg) {
        String ret = "";
        if(type == logType || logType == LogType.ALL){
            //String className = Thread.currentThread().getStackTrace()[2].getClassName();
            Log.d(Const.TAG, ":" + msg);
        }
        return ret;
    }
}
