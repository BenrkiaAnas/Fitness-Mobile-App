package com.example.miniprojet;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

    private Context mContext;
    private Integer[] mImageIds;
    public ImageAdapter(Context c, Integer[] images){
        mContext = c;
        mImageIds = images;
    }
    @Override
    public int getCount() {
        return mImageIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mImageIds[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView i = new ImageView(mContext);
        i.setImageResource(mImageIds[position]);
        i.setLayoutParams(new Gallery.LayoutParams(600,500));
        i.setScaleType(ImageView.ScaleType.FIT_XY);
        return i;
    }
}
