package com.fukuoka.beatc.weatherforecast.domain.models;

import java.util.ArrayList;
import com.fukuoka.beatc.weatherforecast.domain.entity.Product;
/**
 * Created by ted on 2017/06/27.
 */

public class ProductManager {
    private ProductManager incetance = null;
    public ProductManager getInstance(){
        if(incetance == null){
            incetance = new ProductManager();
        }
        return  incetance;
    }

    public ArrayList<Product> MakeProductList()
    {
        ArrayList<Product> list = new ArrayList<>();

        list.add(new Product("リンゴ","津軽産地の美味しいリンゴです",100,150));
        list.add(new Product("ばなな","パナマ産のバナナです。すっきり美味しい",100,250));
        list.add(new Product("イチゴ","福岡産のあまおう。美味しくてあまい",100,150));
        list.add(new Product("みかん","愛媛産のミカンです",100,150));
        list.add(new Product("メロン","夕張産の甘いメロンです。すっきり美味しい",100,150));
        list.add(new Product("もも","岡山産の甘いももです。夏にぴったりの美味しい",100,150));
        return list;
    }

}
