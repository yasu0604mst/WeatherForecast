package com.fukuoka.beatc.weatherforecast.models;

/**
 * Created by ted on 2017/06/25.
 */

public class Food {
    long id;
    private String name;
    private int price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price=price;
    }

}