package com.example.miniprojet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.miniprojet.adapters.MealAdapter;
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

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference myRef = firebaseDatabase.getReference().child("Plans");
    DatabaseReference myRef2 = firebaseDatabase.getReference().child("Meals");


    ArrayList<Plan> listPlans = new ArrayList<>();
    ArrayList<Meal> listMeals = new ArrayList<>();

    ListView listview;
    ListView listviewMeals;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);




        PlanAdapter adapter = new PlanAdapter(this,listPlans);
        // list view
        listview = findViewById(R.id.listpost);
        listview.setAdapter(adapter);
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren())
                {
                    Plan plan = new Plan(snapshot1.child("name").getValue().toString(),snapshot1.child("desc").getValue().toString(),snapshot1.child("img").getValue().toString());



                    listPlans.add(plan);




                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(HomeActivity.this,PlanDetail.class);
                Plan plan = listPlans.get(position);
                i.putExtra("plan",plan);
                i.putExtra("from","home");
                startActivity(i);

            }
        });






        MealAdapter adapter_meal = new MealAdapter(this,listMeals);
        // list view
        listviewMeals = findViewById(R.id.listrepas);
        listviewMeals.setAdapter(adapter_meal);

        myRef2.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren())
                {
                    Meal meal = new Meal(snapshot1.child("name").getValue().toString(),
                            snapshot1.child("desc").getValue().toString(),
                            snapshot1.child("img").getValue().toString(),
                            snapshot1.child("calorie").getValue().toString(),
                            snapshot1.child("fat").getValue().toString(),
                            snapshot1.child("carb").getValue().toString(),
                            snapshot1.child("protine").getValue().toString()
                            );


                    listMeals.add(meal);




                }

                adapter_meal.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        listviewMeals.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(HomeActivity.this,MealDetail.class);
                Meal meal = listMeals.get(position);
                i.putExtra("meal",meal);
                i.putExtra("from","home");
                startActivity(i);
            }
        });


        // Bottom Navigation
        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.page_3:{
                        Intent i = new Intent(HomeActivity.this,MealActivity.class);
                        startActivity(i);

                        return false;
                    }

                    case R.id.page_4:{
                        Intent i = new Intent(HomeActivity.this,PlanActivity.class);
                        startActivity(i);

                        return false;
                    }
                    case R.id.page_5:{
                        Intent i = new Intent(HomeActivity.this,ProfilActivity.class);
                        startActivity(i);

                        return false;
                    }

                }
                return false;
            }
        });


    }






}