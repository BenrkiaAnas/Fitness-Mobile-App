package com.example.miniprojet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
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

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String Shared_Pref_Name = "CurrentUser";
    String Session_key = "Session_user";

    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        LinearLayout linearLayout = findViewById(R.id.linearlayout);
        LinearLayout linearlayout_logout = findViewById(R.id.linearlayout_logout);
        LinearLayout linearlayout2 = findViewById(R.id.linearlayout2);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProfilActivity.this,ProfilModifyActivity.class);
                startActivity(i);
            }
        });

        linearlayout_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sharedPreferences = getSharedPreferences(Shared_Pref_Name,MODE_PRIVATE);
                editor = sharedPreferences.edit();

                editor.clear();
                editor.commit();


                Intent i = new Intent(ProfilActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });

        linearlayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProfilActivity.this,InfoActivity.class);
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

        /*addSettings();





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

                    sharedPreferences = getSharedPreferences(Shared_Pref_Name,MODE_PRIVATE);
                    editor = sharedPreferences.edit();

                    editor.clear();
                    editor.commit();

                    Intent i = new Intent(ProfilActivity.this,LoginActivity.class);
                    startActivity(i);

                }
            }
        });


        */

    }


}