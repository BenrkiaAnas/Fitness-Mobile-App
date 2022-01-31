package com.example.miniprojet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.miniprojet.models.Plan;
import com.example.miniprojet.models.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class PlanDetail extends AppCompatActivity {

    private Context context;

    BottomNavigationView bottomNavigationView;

    private static final String TAG = "PlanDetail";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_detail);

        Button button = findViewById(R.id.button2);
        Intent i = new Intent(this,ExerciceActivity.class);

        Bundle params = getIntent().getExtras();
        Plan plan = params.getParcelable("plan");
        String from = params.getString("from");

        TextView name = findViewById(R.id.textView7);
        TextView description = findViewById(R.id.textView8);
        TextView duration = findViewById(R.id.textView10);
        TextView weeklyTime = findViewById(R.id.textView12);
        TextView difficulte = findViewById(R.id.textView22);
        ImageView image = findViewById(R.id.imageView6);
        ImageView back = findViewById(R.id.imageView5);

        name.setText(plan.getName());
        description.setText(plan.getDesc());
        duration.setText(plan.getDuration());
        weeklyTime.setText(plan.getTimeweekly());
        difficulte.setText(plan.getDifficulte());

        Intent back_intent = new Intent(this,HomeActivity.class);
        Intent back_plan = new Intent(this,PlanActivity.class);

        int id = getResources().getIdentifier(plan.getImg(), "drawable", getPackageName());

        image.setImageResource(id);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(from.equals("home"))
                {

                    startActivity(back_intent);
                }else{
                    startActivity(back_plan);
                }

            }
        });



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("plan",plan);
                i.putExtra("from","plan");
                Log.i(TAG, "Hello "+plan.toString());
                startActivity(i);
            }
        });

        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.page_3:{
                        Intent i = new Intent(PlanDetail.this,MealActivity.class);
                        startActivity(i);

                        return false;
                    }

                    case R.id.page_1:{
                        Intent i = new Intent(PlanDetail.this,HomeActivity.class);
                        startActivity(i);

                        return false;
                    }
                    case R.id.page_5:{
                        Intent i = new Intent(PlanDetail.this,ProfilActivity.class);
                        startActivity(i);

                        return false;
                    }

                }
                return false;
            }
        });







    }
}