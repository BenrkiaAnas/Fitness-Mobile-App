package com.example.miniprojet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.miniprojet.models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    //Create object of DatabaseReference to access firebase classe
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference myRef = firebaseDatabase.getReference().child("Users");

    FirebaseAuth mAuth;
    FirebaseUser mUser;


    private static final String TAG = "RegisterActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button signup = this.findViewById(R.id.btnContinue);


        TextInputLayout firstname = this.findViewById(R.id.firstname);
        TextInputLayout lastname = this.findViewById(R.id.lastname);
        TextInputLayout email = this.findViewById(R.id.email);
        TextInputLayout password = this.findViewById(R.id.password);

        mAuth = FirebaseAuth.getInstance();
        mUser= mAuth.getCurrentUser();



        final Intent i = new Intent(this,CompleteProfile.class);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String nom = firstname.getEditText().getText().toString();
                String prenom = lastname.getEditText().getText().toString();
                String mail = email.getEditText().getText().toString();
                String passe = password.getEditText().getText().toString();



                User user = new User(nom,prenom,mail,passe,"","","","");


                Toast.makeText(RegisterActivity.this,"Hello",Toast.LENGTH_LONG).show();


                Log.i(TAG, "Hello "+user.toString());

                i.putExtra("user",user);
                startActivity(i);




            }
        });


        //String[] some_array = getResources().getStringArray(R.array.user);


    }
}