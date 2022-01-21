package com.example.miniprojet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

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

public class MealActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    private static final String TAG = "MealActivity";




    ArrayList<Meal> listMeals = new ArrayList<Meal>();

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference myRef = firebaseDatabase.getReference().child("Meals");

    ListView listviewMeals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);

        MealAdapter adapter = new MealAdapter(this,listMeals);





        // list view
        listviewMeals = findViewById(R.id.listmeal);
        listviewMeals.setAdapter(adapter);
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {

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

                    case R.id.page_4:{
                        Intent i = new Intent(MealActivity.this,PlanActivity.class);
                        startActivity(i);

                        return false;
                    }

                    case R.id.page_1:{
                        Intent i = new Intent(MealActivity.this,HomeActivity.class);
                        startActivity(i);

                        return false;
                    }
                    case R.id.page_5:{
                        Intent i = new Intent(MealActivity.this,ProfilActivity.class);
                        startActivity(i);

                        return false;
                    }

                }
                return false;
            }
        });

        listviewMeals.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MealActivity.this,MealDetail.class);
                Meal meal = listMeals.get(position);
                i.putExtra("meal",meal);
                startActivity(i);
            }
        });

    }

}