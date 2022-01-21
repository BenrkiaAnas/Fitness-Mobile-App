package com.example.miniprojet.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.miniprojet.R;
import com.example.miniprojet.models.Plan;

import java.util.List;

public class PlanAdapter extends BaseAdapter {

    private Context context;
    private List<Plan> list_plans;

    public PlanAdapter(Context context, List<Plan> list_plans) {
        this.context = context;
        this.list_plans = list_plans;
    }


    @Override
    public int getCount() {
        return list_plans.size();
    }

    @Override
    public Object getItem(int position) {
        return list_plans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.layout_items,parent,false);
        }


        Plan currentPlan = (Plan) getItem(position);

        TextView texttitre = (TextView)
                convertView.findViewById(R.id.titre);
        TextView textdesc = (TextView)
                convertView.findViewById(R.id.desc);

        ImageView image = (ImageView)
                convertView.findViewById(R.id.imageview);


        texttitre.setText(currentPlan.getName());
        textdesc.setText(currentPlan.getDesc());

        int id = context.getResources().getIdentifier(currentPlan.getImg(), "drawable", context.getPackageName());

        image.setImageResource(id);

        return convertView;


    }
}
