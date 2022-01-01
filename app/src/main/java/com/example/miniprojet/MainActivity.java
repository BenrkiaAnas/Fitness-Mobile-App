package com.example.miniprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button login = (Button) this.findViewById(R.id.login);
        Button createaccount = this.findViewById(R.id.signup);
        final Intent intent_login = new Intent(this,LoginActivity.class);
        final Intent intent_register = new Intent(this,RegisterActivity.class);

        // String[] some_array = getResources().getStringArray(R.array.user);


        // Toast.makeText(MainActivity.this,some_array[0].toString(),Toast.LENGTH_SHORT ).show();;



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent_login);
            }
        });

        createaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent_register);
            }
        });
    }
}