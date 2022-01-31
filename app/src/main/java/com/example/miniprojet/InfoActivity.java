package com.example.miniprojet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.miniprojet.models.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class InfoActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String Shared_Pref_Name = "CurrentUser";
    String Session_key = "Session_user";

    RadioGroup radioGroup;
    RadioButton radioButton;



    private static final String TAG = "InfoActivity";

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference myRef = firebaseDatabase.getReference().child("Users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        final Intent i = new Intent(this,ProfilActivity.class);


        radioGroup = (RadioGroup) this.findViewById(R.id.radioGroup);

        sharedPreferences = getSharedPreferences(Shared_Pref_Name,MODE_PRIVATE);
        editor = sharedPreferences.edit();

        final String username = sharedPreferences.getString(Session_key,"");

        EditText poids = findViewById(R.id.editTextTextPersonName4);
        EditText taille = findViewById(R.id.editTextTextPersonName5);
        EditText age = findViewById(R.id.editTextTextPersonName6);


        RadioButton male = findViewById(R.id.gender_male);
        RadioButton female = findViewById(R.id.gender_male);

        Button modify = findViewById(R.id.button7);
        ImageView back = findViewById(R.id.imageView7);

        Intent back_profil = new Intent(this,ProfilActivity.class);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(back_profil);


            }
        });

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.hasChild(username))
                {
                    poids.setText(snapshot.child(username).child("weight").getValue(String.class));
                    taille.setText(snapshot.child(username).child("height").getValue(String.class));
                    age.setText(snapshot.child(username).child("age").getValue(String.class));
                    if(snapshot.child(username).child("age").getValue(String.class).equals("0"))
                    {
                        male.setChecked(true);
                        female.setChecked(false);
                    }else{
                        female.setChecked(true);
                        male.setChecked(true);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        // Button Modify
        modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int checked = radioGroup.getCheckedRadioButtonId();
                String gender = "0";



                radioButton = findViewById(checked);

                String text = radioButton.getText().toString();
                if ("Homme".equals(text)) {
                    gender = "0";
                } else if ("Femme".equals(text)) {
                    gender = "1";
                }


                String name_edit = "";
                String lastname_edit = "";
                String email_edit = "";
                String age_edit = age.getText().toString();
                String weight_edit = poids.getText().toString();
                String height_edit = taille.getText().toString();
                String pass_edit = "";

                User user = new User("","","","",age_edit,weight_edit,height_edit,gender);

                String finalGender = gender;
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {







                        myRef.child(username).child("weight").setValue(weight_edit);
                        myRef.child(username).child("height").setValue(height_edit);
                        myRef.child(username).child("age").setValue(age_edit);
                        myRef.child(username).child("gender").setValue(finalGender);

                        startActivity(i);



                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

    }
}