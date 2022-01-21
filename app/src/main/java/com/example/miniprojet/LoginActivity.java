package com.example.miniprojet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.miniprojet.models.User;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference myRef = firebaseDatabase.getReference().child("Users");



    private static final String TAG = "LoginActivity";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String Shared_Pref_Name = "CurrentUser";
    String Session_key = "Session_user";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        TextInputLayout email = this.findViewById(R.id.email);
        TextInputLayout password = this.findViewById(R.id.password);

        Button btn = this.findViewById(R.id.login);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = email.getEditText().getText().toString();
                String passe = password.getEditText().getText().toString();
                //Toast.makeText(LoginActivity.this,"passlog",Toast.LENGTH_LONG).show();


                sharedPreferences = getSharedPreferences(Shared_Pref_Name,MODE_PRIVATE);
                editor = sharedPreferences.edit();

                String username = mail.replaceAll("\\p{Punct}", "");

                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild(username))
                        {
                            String password_log = snapshot.child(username).child("password").getValue(String.class);
                            String email_log = snapshot.child(username).child("email").getValue(String.class);

                            if(mail.equals(email_log) && passe.equals(password_log))
                            {

                                //Toast.makeText(LoginActivity.this,mail,Toast.LENGTH_SHORT ).show();
                                //Toast.makeText(LoginActivity.this,passe,Toast.LENGTH_SHORT ).show();
                                //Toast.makeText(LoginActivity.this,emailLog,Toast.LENGTH_SHORT ).show();
                                //Toast.makeText(LoginActivity.this,passlog,Toast.LENGTH_SHORT ).show();


                                editor.putString(Session_key,username).commit();

                                Intent i = new Intent(LoginActivity.this,HomeActivity.class);


                                startActivity(i);

                                Log.i(TAG, "User Exist");




                            }else{

                                Log.i(TAG, "User Is Not Exist");

                                Toast.makeText(LoginActivity.this,"Erreur enter a new pass",Toast.LENGTH_LONG).show();

                            }

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });




            }
        });




    }
}