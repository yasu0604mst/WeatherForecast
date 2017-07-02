package com.fukuoka.beatc.weatherforecast.presentation.presenter;

import com.fukuoka.beatc.weatherforecast.domain.entity.Product;
import com.fukuoka.beatc.weatherforecast.domain.usecase.FollowerListUseCase;
import com.fukuoka.beatc.weatherforecast.domain.usecase.ICreateProductList;
import com.fukuoka.beatc.weatherforecast.domain.usecase.CreateProductList;
import com.fukuoka.beatc.weatherforecast.presentation.activity.IMainActivityViews;
import com.fukuoka.beatc.weatherforecast.presentation.activity.MainActivity;
import com.fukuoka.beatc.weatherforecast.domain.usecase.CreateProductList.GetProductInfoDelegate;
import com.fukuoka.beatc.weatherforecast.domain.usecase.FollowerListUseCase.FollowerListUseCaseCallback;

import java.util.Collection;

/**
 * Created by ted on 2017/06/28.
 */

public class MainPresenter extends Presenter implements FollowerListUseCaseCallback{
    private ICreateProductList _useCase;
    private IMainActivityViews _activity;

    public MainPresenter() {
        _useCase = new CreateProductList();
    }

    public void setActivity(MainActivity activity) {
        _activity = activity;
    }

    public void setView(){
        _useCase.getProductInfo(new GetProductInfoDelegate(){
            @Override
            public void getName(String result){
                _activity.setNameView1(result);
            }
            @Override
            public void getDescription(String result){
                _activity.setNameView2(result);
            }
            @Override
            public void getPrice(String result){
                _activity.setNameView3(result);
            }
        });
    }
    public void onCreate() {

    }
    @Override
    public void initialize(){

    }
    @Override
    public void resume(){

    }
    @Override
    public void pause(){

    }
    @Override
    public void destroy(){

    }
    @Override
    public void onUserListLoaded(final Collection<Product> usersCollection){

    }
    @Override
    public void onError(){

    }
}
