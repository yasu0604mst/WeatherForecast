package com.fukuoka.beatc.weatherforecast.presentation.presenter;

/**
 * Created by ted on 2017/07/01.
 */

public abstract class Presenter {
    //ActivityLifeCycle
    public abstract void initialize();
    public abstract void resume();
    public abstract void pause();
    public abstract void destroy();
}
