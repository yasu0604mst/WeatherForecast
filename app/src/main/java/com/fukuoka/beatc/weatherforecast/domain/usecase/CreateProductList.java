package com.fukuoka.beatc.weatherforecast.domain.usecase;

/**
 * Created by ted on 2017/06/28.
 */

public class CreateProductList implements ICreateProductList {
    public static interface GetProductInfoDelegate {
        void getName(String result);
        void getDescription(String result);
        void getPrice(String result);
    }
    @Override
    public void getProductInfo(GetProductInfoDelegate delegate){
        delegate.getName("SONY SFR Camera");
        delegate.getDescription("ソニーの一眼レフカメラです");
        delegate.getPrice("300000");
    }
}
