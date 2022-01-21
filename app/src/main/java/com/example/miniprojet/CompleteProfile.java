package com.example.miniprojet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miniprojet.models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ValueEventListener;

public class CompleteProfile extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;

    //Create object of DatabaseReference to access firebase classe
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

    DatabaseReference myRef = firebaseDatabase.getReference().child("Users");

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    private static final String TAG = "CompleteProfile";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_profile);

        final Intent i = new Intent(this,HomeActivity.class);

        EditText weight = (EditText) this.findViewById(R.id.weight);
        EditText hight = (EditText) this.findViewById(R.id.hight);
        EditText age = (EditText) this.findViewById(R.id.age);

        radioGroup = (RadioGroup) this.findViewById(R.id.gender);

        Bundle params = getIntent().getExtras();
        User user = params.getParcelable("user");

        Toast.makeText(CompleteProfile.this,"Hello",Toast.LENGTH_SHORT ).show();

        Toast.makeText(CompleteProfile.this,user.toString(),Toast.LENGTH_SHORT ).show();

        mAuth = FirebaseAuth.getInstance();
        mUser= mAuth.getCurrentUser();







        Button completeProfile = (Button) this.findViewById(R.id.button);

        completeProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(CompleteProfile.this,"Hello",Toast.LENGTH_SHORT ).show();


                int checked = radioGroup.getCheckedRadioButtonId();
                String gender = "0";



                radioButton = findViewById(checked);

                String text = radioButton.getText().toString();
                if ("Homme".equals(text)) {
                    gender = "0";
                } else if ("Femme".equals(text)) {
                    gender = "1";
                }

                //Toast.makeText(CompleteProfile.this,text,Toast.LENGTH_SHORT ).show();



                String weight_personne = weight.getText().toString();
                String height_personne = hight.getText().toString();
                String age_personne = age.getText().toString();

                final User currentUser = new User(user.getNom(),user.getPrenom(),user.getEmail(),user.getPassword(),age_personne,weight_personne,height_personne,gender);

                Log.i(TAG, "Hello "+currentUser.toString());

                String user_email = user.getEmail();

                String username = user_email.replaceAll("\\p{Punct}", "");


                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild(username))
                        {
                            Toast.makeText(CompleteProfile.this,"User Already Existe",Toast.LENGTH_SHORT ).show();
                        }else{




                            myRef.child(username).child("firstname").setValue(currentUser.getNom());
                            myRef.child(username).child("lastname").setValue(currentUser.getPrenom());
                            myRef.child(username).child("email").setValue(currentUser.getEmail());
                            myRef.child(username).child("password").setValue(currentUser.getPassword());
                            myRef.child(username).child("weight").setValue(currentUser.getWeight());
                            myRef.child(username).child("height").setValue(currentUser.getHeight());
                            myRef.child(username).child("age").setValue(currentUser.getAge());
                            myRef.child(username).child("gender").setValue(currentUser.getGender());


                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });




                //Toast.makeText(CompleteProfile.this,currentUser.toString(),Toast.LENGTH_SHORT ).show();

                i.putExtra("currentUser",currentUser);
                startActivity(i);
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