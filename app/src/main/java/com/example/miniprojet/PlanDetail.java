package com.example.miniprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.miniprojet.models.Plan;
import com.example.miniprojet.models.User;

import java.util.List;

public class PlanDetail extends AppCompatActivity {

    private Context context;

    private static final String TAG = "PlanDetail";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_detail);

        Button button = findViewById(R.id.button2);
        Intent i = new Intent(this,ExerciceActivity.class);

        Bundle params = getIntent().getExtras();
        Plan plan = params.getParcelable("plan");

        TextView name = findViewById(R.id.textView7);
        TextView description = findViewById(R.id.textView8);
        TextView duration = findViewById(R.id.textView10);
        TextView weeklyTime = findViewById(R.id.textView12);
        TextView difficulte = findViewById(R.id.textView22);
        ImageView image = findViewById(R.id.imageView6);

        name.setText(plan.getName());
        description.setText(plan.getDesc());
        duration.setText(plan.getDuration());
        weeklyTime.setText(plan.getTimeweekly());
        difficulte.setText(plan.getDifficulte());

        int id = getResources().getIdentifier(plan.getImg(), "drawable", getPackageName());

        image.setImageResource(id);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("plan",plan);
                Log.i(TAG, "Hello "+plan.toString());

                startActivity(i);
            }
        });






    }
}