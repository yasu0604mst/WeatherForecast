package com.fukuoka.beatc.weatherforecast.domain.entity;

/**
 * Created by ted on 2017/06/25.
 */

public class Product {
    long id;
    private String name;
    private String description;
    private int count;
    private int price;

    Product(){

    }
    public Product(String name, String description, int count, int price){
        this.id = this.id + 1;
        this.name = name;
        this.description = description;
        this.count = count;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    //名称
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    //詳細情報
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    //数量
    public int getCount(){
        return this.count;
    }
    public void setCount(int count){
        this.count = count;
    }

    //価格
    public int getPrice(){
        return price;
    }
    public void setPrice(int price){ this.price=price; }
}