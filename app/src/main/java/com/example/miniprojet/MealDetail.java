package com.example.miniprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.miniprojet.models.Meal;
import com.example.miniprojet.models.Plan;

public class MealDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_detail);

        Bundle params = getIntent().getExtras();
        Meal meal = params.getParcelable("meal");

        TextView name = findViewById(R.id.textView23);
        TextView descriptiion = findViewById(R.id.textView24);
        TextView calorie = findViewById(R.id.textView29);
        TextView carb = findViewById(R.id.textView30);
        TextView fat = findViewById(R.id.textView31);
        TextView protine = findViewById(R.id.textView32);
        ImageView image = findViewById(R.id.imageView);

        name.setText(meal.getNom());
        descriptiion.setText(meal.getDescr());
        calorie.setText(meal.getCalorie()+" g");
        carb.setText(meal.getCarb()+" g");
        fat.setText(meal.getFat()+" g");
        protine.setText(meal.getProtine()+" g");

        int id = getResources().getIdentifier(meal.getImg(), "drawable", getPackageName());

        image.setImageResource(id);



    }
}