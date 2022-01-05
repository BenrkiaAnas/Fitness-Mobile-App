package com.example.miniprojet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


    }

    HomeFragement homeFragement = new HomeFragement();
    WorkoutFragement workoutFragement = new WorkoutFragement();
    MealFragement mealFragement = new MealFragement();
    ProfilFragment profilFragment = new ProfilFragment();


    public boolean onNavigateItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.page_1:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragement).commit();
                return true;
            case R.id.page_3:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, mealFragement).commit();
                return true;

            case R.id.page_4:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, workoutFragement).commit();
                return true;

            case R.id.page_5:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, profilFragment).commit();
                return true;

        }
        return false;
    }
}