package com.example.miniprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.miniprojet.models.User;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        TextInputLayout email = this.findViewById(R.id.email);
        TextInputLayout password = this.findViewById(R.id.password);

        Button btn = this.findViewById(R.id.login);

        Intent i = new Intent(this,HomeActivity.class);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = email.getEditText().getText().toString();
                String passe = password.getEditText().getText().toString();
                String[] some_array = getResources().getStringArray(R.array.user);

                String emailLog = some_array[3];
                String passlog = some_array[4];






                if(mail.equals(emailLog) && passe.equals(passlog))
                {

                    Toast.makeText(LoginActivity.this,mail,Toast.LENGTH_SHORT ).show();
                    Toast.makeText(LoginActivity.this,passe,Toast.LENGTH_SHORT ).show();
                    Toast.makeText(LoginActivity.this,emailLog,Toast.LENGTH_SHORT ).show();
                    Toast.makeText(LoginActivity.this,passlog,Toast.LENGTH_SHORT ).show();

                    User user = new User(1,some_array[2],some_array[3],emailLog,passlog);
                    i.putExtra("user",user);

                    startActivity(i);


                }

            }
        });




    }
}