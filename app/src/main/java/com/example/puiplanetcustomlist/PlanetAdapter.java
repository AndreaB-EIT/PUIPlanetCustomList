package com.example.puiplanetcustomlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.puiplanetcustomlist.model.Planet;

import java.util.LinkedList;
import java.util.List;

public class PlanetAdapter extends BaseAdapter {
    // the adapter is the link between data and UI
    private List<Planet> data = new LinkedList<>();
    Context ctx;

    public PlanetAdapter (Context ctx) {
        this.ctx = ctx;
    }

    public void addPlanets(List<Planet> list) {
        data.addAll(list);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        // should return the item's ID
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(ctx);
        View v = layoutInflater.inflate(R.layout.planet_row_layout_2, null);

        TextView textViewName = v.findViewById(R.id.txt_name);
        textViewName.setText(data.get(position).getName());

        TextView textViewGravity = v.findViewById(R.id.txt_gravity);
        textViewGravity.setText(data.get(position).getGravity());

        ImageView imageView = v.findViewById(R.id.img_image);
        imageView.setImageBitmap(data.get(position).getBitmap());

        return v;
    }


}
