package com.example.miniprojet.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.miniprojet.R;
import com.example.miniprojet.models.Meal;

import java.util.List;

public class MealAdapter extends BaseAdapter {

    private Context context;
    private List<Meal> list_meals;

    public MealAdapter(Context context, List<Meal> list_meals) {
        this.context = context;
        this.list_meals = list_meals;
    }


    @Override
    public int getCount() {
        return list_meals.size();
    }

    @Override
    public Object getItem(int position) {
        return list_meals.get(position);
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


        Meal currentMeal = (Meal) getItem(position);

        TextView texttitre = (TextView)
                convertView.findViewById(R.id.titre);
        TextView textdesc = (TextView)
                convertView.findViewById(R.id.desc);

        ImageView image = (ImageView)
                convertView.findViewById(R.id.imageview);


        texttitre.setText(currentMeal.getNom());
        textdesc.setText(currentMeal.getDescr());

        String img = currentMeal.getImg();

        int id = context.getResources().getIdentifier(currentMeal.getImg(), "drawable", context.getPackageName());

        image.setImageResource(id);

        return convertView;
    }
}
