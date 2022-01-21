package com.example.miniprojet.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.miniprojet.R;
import com.example.miniprojet.models.Exercice;
import com.example.miniprojet.models.Meal;
import com.example.miniprojet.models.Plan;

import java.util.List;

public class ExerciceAdapter extends BaseAdapter {


    private Context context;
    private List<Exercice> list_exercice;

    public ExerciceAdapter(Context context, List<Exercice> list_exercice) {
        this.context = context;
        this.list_exercice = list_exercice;
    }

    @Override
    public int getCount() {
        return list_exercice.size();
    }

    @Override
    public Object getItem(int position) {
        return list_exercice.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.listviewplansdetail,parent,false);
        }
        Exercice currentExercice = (Exercice) getItem(position);

        TextView name = convertView.findViewById(R.id.titre);
        TextView time = convertView.findViewById(R.id.textView6);

        ImageView image = (ImageView)
                convertView.findViewById(R.id.imageView2);

        name.setText(currentExercice.getName());
        time.setText(currentExercice.getTime()+" s");


        String img = currentExercice.getImg();

        int id = context.getResources().getIdentifier(currentExercice.getImg(), "drawable", context.getPackageName());

        image.setImageResource(id);

        return convertView;


    }
}
