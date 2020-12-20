package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class CustomGrid extends BaseAdapter{
    private Context mContext;
    private List<Items> web;
    private final int Imageid;

    public CustomGrid(Context c, List<Items> web, int Imageid ) {
        mContext = c;
        this.Imageid = Imageid;
        this.web = web;

    }


    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return web.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View grid;
        if (convertView == null) {
            Items[] array = new Items[web.size()];
            web.toArray(array);


            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_item, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
            textView.setText(array[position].display());
            imageView.setImageResource(Imageid);
        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}