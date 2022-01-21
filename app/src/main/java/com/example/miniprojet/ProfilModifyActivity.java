package com.example.miniprojet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.miniprojet.models.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfilModifyActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String Shared_Pref_Name = "CurrentUser";
    String Session_key = "Session_user";

    RadioGroup radioGroup;
    RadioButton radioButton;



    private static final String TAG = "ProfilModifyActivity";

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference myRef = firebaseDatabase.getReference().child("Users");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_modify);


        final Intent i = new Intent(this,ProfilActivity.class);


        radioGroup = (RadioGroup) this.findViewById(R.id.radioGroup);

        sharedPreferences = getSharedPreferences(Shared_Pref_Name,MODE_PRIVATE);
        editor = sharedPreferences.edit();

        final String username = sharedPreferences.getString(Session_key,"");

        Log.i(TAG, "Username "+username);

        EditText nom = findViewById(R.id.editTextTextPersonName);
        EditText prenom = findViewById(R.id.editTextTextPersonName2);
        EditText email = findViewById(R.id.editTextTextPersonName3);
        EditText poids = findViewById(R.id.editTextTextPersonName4);
        EditText taille = findViewById(R.id.editTextTextPersonName5);
        EditText age = findViewById(R.id.editTextTextPersonName6);
        EditText password = findViewById(R.id.editTextTextPassword);


        RadioButton male = findViewById(R.id.gender_male);
        RadioButton female = findViewById(R.id.gender_male);

        Button modify = findViewById(R.id.button7);



        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.hasChild(username))
                {

                    nom.setText(snapshot.child(username).child("firstname").getValue(String.class));
                    prenom.setText(snapshot.child(username).child("lastname").getValue(String.class));
                    email.setText(snapshot.child(username).child("email").getValue(String.class));
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


                String name_edit = nom.getText().toString();
                String lastname_edit = prenom.getText().toString();
                String email_edit = email.getText().toString();
                String age_edit = age.getText().toString();
                String weight_edit = poids.getText().toString();
                String height_edit = taille.getText().toString();
                String pass_edit = password.getText().toString();

                User user = new User(name_edit,lastname_edit,email_edit,pass_edit,age_edit,weight_edit,height_edit,gender);

                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        snapshot.child(username).getRef().removeValue();




                        String username_new = email_edit.replaceAll("\\p{Punct}", "");


                        myRef.child(username_new).child("firstname").setValue(user.getNom());
                        myRef.child(username_new).child("lastname").setValue(user.getPrenom());
                        myRef.child(username_new).child("email").setValue(user.getEmail());
                        myRef.child(username_new).child("password").setValue(user.getPassword());
                        myRef.child(username_new).child("weight").setValue(user.getWeight());
                        myRef.child(username_new).child("height").setValue(user.getHeight());
                        myRef.child(username_new).child("age").setValue(user.getAge());
                        myRef.child(username_new).child("gender").setValue(user.getGender());

                        startActivity(i);



                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });



    }

    public int onRadioButtonClicked(View view)
    {
        int checked = radioGroup.getCheckedRadioButtonId();
        int gender = 0;

        radioButton = this.findViewById(checked);

        String text = radioButton.getText().toString();
        if ("Male".equals(text)) {
            gender = 0;
        } else if ("Female".equals(text)) {
            gender = 1;
        }

        return gender;
    }
}