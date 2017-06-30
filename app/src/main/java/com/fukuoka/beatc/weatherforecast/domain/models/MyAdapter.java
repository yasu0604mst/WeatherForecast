package com.fukuoka.beatc.weatherforecast.domain.models;

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
import com.fukuoka.beatc.weatherforecast.domain.entity.Product;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    Context context;
    LayoutInflater layoutInflater = null;
    ArrayList<Product> productList;

    public MyAdapter(Context context) {
        this.context = context;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return productList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.product_rows,parent,false);

        ((TextView)convertView.findViewById(R.id.name)).setText(productList.get(position).getName());
        ((TextView)convertView.findViewById(R.id.description)).setText(String.valueOf(productList.get(position).getDescription()));
        ((TextView)convertView.findViewById(R.id.count2)).setText(String.valueOf(productList.get(position).getCount()));
        ((TextView)convertView.findViewById(R.id.price)).setText(String.valueOf(productList.get(position).getPrice()));
        return convertView;
    }
}
