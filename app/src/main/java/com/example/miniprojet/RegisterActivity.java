package com.example.miniprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.miniprojet.models.User;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button signup = (Button) this.findViewById(R.id.btnContinue);


        TextInputLayout firstname = this.findViewById(R.id.firstname);
        TextInputLayout lastname = this.findViewById(R.id.lastname);
        TextInputLayout email = this.findViewById(R.id.email);
        TextInputLayout password = this.findViewById(R.id.password);



        final Intent i = new Intent(this,HomeActivity.class);



        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nom = firstname.getEditText().getText().toString();
                String prenom = lastname.getEditText().getText().toString();
                String mail = email.getEditText().getText().toString();
                String passe = password.getEditText().getText().toString();



                User user = new User(1,nom,prenom,mail,passe);

                i.putExtra("user",user);
                startActivity(i);




            }
        });


        //String[] some_array = getResources().getStringArray(R.array.user);


    }
}