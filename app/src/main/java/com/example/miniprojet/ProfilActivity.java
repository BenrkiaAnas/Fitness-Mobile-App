package com.example.miniprojet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.miniprojet.adapters.PlanAdapter;
import com.example.miniprojet.adapters.SettingAdapter;
import com.example.miniprojet.models.Plan;
import com.example.miniprojet.models.Setting;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class ProfilActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    ArrayList<Setting> listSettings = new ArrayList<>();

    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        addSettings();



        SettingAdapter adapter = new SettingAdapter(this,listSettings);
        // list view
        listview = findViewById(R.id.listSettings);
        listview.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        // On Click List View
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Setting currentSetting = (Setting) listview.getItemAtPosition(position);
                if(currentSetting.getNom_setting() == "Profil")
                {

                    Intent i = new Intent(ProfilActivity.this,ProfilModifyActivity.class);
                    startActivity(i);

                }else{

                    Intent i = new Intent(ProfilActivity.this,LoginActivity.class);
                    startActivity(i);

                }
            }
        });


        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.page_3:{
                        Intent i = new Intent(ProfilActivity.this,MealActivity.class);
                        startActivity(i);

                        return false;
                    }

                    case R.id.page_1:{
                        Intent i = new Intent(ProfilActivity.this,HomeActivity.class);
                        startActivity(i);

                        return false;
                    }
                    case R.id.page_4:{
                        Intent i = new Intent(ProfilActivity.this,PlanActivity.class);
                        startActivity(i);

                        return false;
                    }

                }
                return false;
            }
        });

    }

    public void addSettings()
    {

        listSettings.add(new Setting("Profil"));
        listSettings.add(new Setting("Se Déconnecter"));


    }
}