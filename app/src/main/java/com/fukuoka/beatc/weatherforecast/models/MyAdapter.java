package com.fukuoka.beatc.weatherforecast.models;

/**
 * Created by ted on 2017/06/25.
**/
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.fukuoka.beatc.weatherforecast.R;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    Context context;
    LayoutInflater layoutInflater = null;
    ArrayList<Food> foodList;

    public MyAdapter(Context context) {
        this.context = context;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setFoodList(ArrayList<Food> foodList) {
        this.foodList = foodList;
    }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int position) {
        return foodList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return foodList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.food_rows,parent,false);

        ((TextView)convertView.findViewById(R.id.name)).setText(foodList.get(position).getName());
        ((TextView)convertView.findViewById(R.id.price)).setText(String.valueOf(foodList.get(position).getPrice()));
        ((TextView)convertView.findViewById(R.id.name2)).setText(foodList.get(position).getName());
        ((TextView)convertView.findViewById(R.id.price2)).setText(String.valueOf(foodList.get(position).getPrice()));
        return convertView;
    }
}
