package com.example.miniprojet.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.miniprojet.R;
import com.example.miniprojet.models.Plan;
import com.example.miniprojet.models.Setting;

import java.util.List;

public class SettingAdapter extends BaseAdapter {


    private Context context;
    private List<Setting> list_setting;

    public SettingAdapter(Context context, List<Setting> list_setting) {
        this.context = context;
        this.list_setting = list_setting;
    }

    @Override
    public int getCount() {
        return list_setting.size();
    }

    @Override
    public Object getItem(int position) {
        return list_setting.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.listview_settings,parent,false);
        }




        TextView texttitre = (TextView)
                convertView.findViewById(R.id.titre);


        Setting currentSetting = (Setting) getItem(position);


        texttitre.setText(currentSetting.getNom_setting());

        return convertView;
    }
}
