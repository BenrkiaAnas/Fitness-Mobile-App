package com.example.miniprojet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.miniprojet.adapters.ExerciceAdapter;
import com.example.miniprojet.models.Exercice;
import com.example.miniprojet.models.Plan;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ExerciceActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    ArrayList<Exercice> listExercice = new ArrayList<>();

    private static final String TAG = "ExerciceActivity";

    ListView listview;

    Integer count = 0;


    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference myRef = firebaseDatabase.getReference().child("Exercices");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice);

        Bundle params = getIntent().getExtras();
        Plan plan = params.getParcelable("plan");






        TextView name_plan = findViewById(R.id.textView33);
        TextView sessions_workout = findViewById(R.id.textView35);
        ImageView image_plan = findViewById(R.id.imageView4);
        TextView desc = findViewById(R.id.textView34);





        ExerciceAdapter exerciceAdapter = new ExerciceAdapter(this,listExercice);
        listview = findViewById(R.id.listexercice);
        listview.setAdapter(exerciceAdapter);
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                for (DataSnapshot snapshot1: snapshot.getChildren())
                {


                    Exercice exercice = new Exercice(snapshot1.child("name").getValue().toString(),
                            snapshot1.child("desc").getValue().toString(),
                            snapshot1.child("img").getValue().toString(),
                            snapshot1.child("time").getValue().toString());

                    listExercice.add(exercice);


                    count++;


                    Log.i(TAG, "Count "+count);



                }


                Log.i(TAG, "Count2 "+count);

                sessions_workout.setText(count+" Exercices");


                exerciceAdapter.notifyDataSetChanged();



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        name_plan.setText(plan.getName());
        desc.setText(plan.getDesc());




        String img = plan.getImg();

        int id = getResources().getIdentifier(plan.getImg(), "drawable", getPackageName());

        image_plan.setImageResource(id);



    }
}