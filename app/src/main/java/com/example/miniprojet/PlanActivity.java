package com.example.miniprojet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.miniprojet.adapters.PlanAdapter;
import com.example.miniprojet.models.Meal;
import com.example.miniprojet.models.Plan;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PlanActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    ArrayList<Plan> listPlans = new ArrayList<>();

    private static final String TAG = "PlanActivity";


    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference myRef = firebaseDatabase.getReference().child("Plans");


    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);



        PlanAdapter adapter = new PlanAdapter(this,listPlans);
        // list view
        listview = findViewById(R.id.listpost);
        listview.setAdapter(adapter);
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren())
                {
                    Plan plan = new Plan(snapshot1.child("name").getValue().toString(),
                            snapshot1.child("desc").getValue().toString(),
                            snapshot1.child("img").getValue().toString(),
                            snapshot1.child("duration").getValue().toString(),
                            snapshot1.child("difficulte").getValue().toString(),
                            snapshot1.child("timeweekly").getValue().toString());



                    listPlans.add(plan);




                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.page_3:{
                        Intent i = new Intent(PlanActivity.this,MealActivity.class);
                        startActivity(i);

                        return false;
                    }

                    case R.id.page_1:{
                        Intent i = new Intent(PlanActivity.this,HomeActivity.class);
                        startActivity(i);

                        return false;
                    }
                    case R.id.page_5:{
                        Intent i = new Intent(PlanActivity.this,ProfilActivity.class);
                        startActivity(i);

                        return false;
                    }

                }
                return false;
            }
        });

        // On Click Lister List View
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(PlanActivity.this,PlanDetail.class);
                Plan plan = listPlans.get(position);
                i.putExtra("plan",plan);
                startActivity(i);

            }
        });





    }


}