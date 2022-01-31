package com.example.miniprojet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.miniprojet.models.Meal;
import com.example.miniprojet.models.Plan;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MealDetail extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_detail);

        Bundle params = getIntent().getExtras();
        Meal meal = params.getParcelable("meal");
        String from = params.getString("from");

        TextView name = findViewById(R.id.textView23);
        TextView descriptiion = findViewById(R.id.textView24);
        TextView calorie = findViewById(R.id.textView29);
        TextView carb = findViewById(R.id.textView30);
        TextView fat = findViewById(R.id.textView31);
        TextView protine = findViewById(R.id.textView32);
        ImageView image = findViewById(R.id.imageView);
        ImageView back = findViewById(R.id.imageView3);


        name.setText(meal.getNom());
        descriptiion.setText(meal.getDescr());
        calorie.setText(meal.getCalorie()+" g");
        carb.setText(meal.getCarb()+" g");
        fat.setText(meal.getFat()+" g");
        protine.setText(meal.getProtine()+" g");

        int id = getResources().getIdentifier(meal.getImg(), "drawable", getPackageName());

        image.setImageResource(id);

        Intent back_intent = new Intent(this,HomeActivity.class);
        Intent back_meal = new Intent(this,MealActivity.class);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(from.equals("home"))
                {

                    startActivity(back_intent);
                }else{
                    startActivity(back_meal);
                }

            }
        });


        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.page_4:{
                        Intent i = new Intent(MealDetail.this,PlanActivity.class);
                        startActivity(i);

                        return false;
                    }

                    case R.id.page_1:{
                        Intent i = new Intent(MealDetail.this,HomeActivity.class);
                        startActivity(i);

                        return false;
                    }
                    case R.id.page_5:{
                        Intent i = new Intent(MealDetail.this,ProfilActivity.class);
                        startActivity(i);

                        return false;
                    }

                }
                return false;
            }
        });



    }
}