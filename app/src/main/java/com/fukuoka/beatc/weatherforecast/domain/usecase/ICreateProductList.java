package com.fukuoka.beatc.weatherforecast.domain.usecase;

/**
 * Created by ted on 2017/06/28.
 */
import com.fukuoka.beatc.weatherforecast.domain.usecase.CreateProductList.GetProductInfoDelegate;

public interface ICreateProductList {
    void getProductInfo(GetProductInfoDelegate getProductInfoDelegate);
}
