package com.example.miniprojet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.miniprojet.adapters.SlideAdapter;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Button login = (Button) this.findViewById(R.id.login);
        Button createaccount = this.findViewById(R.id.signup);
        final Intent intent_login = new Intent(this,LoginActivity.class);
        final Intent intent_register = new Intent(this,RegisterActivity.class);

        Intent intent_notif = new Intent(this,PushNotificationService.class);
        startService(intent_notif);

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
        });*/

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        SlideAdapter myadapter = new SlideAdapter(this);
        viewPager.setAdapter(myadapter);

        Intent i = new Intent(this,RegisterActivity.class);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                // TODO Auto-generated method stub

                System.out.println("onPageSelected "+arg0);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub
                if(arg0 == 3)
                {
                    startActivity(i);
                }
                System.out.println("onPageScrolled");
            }

            @Override
            public void onPageScrollStateChanged(int num) {
                // TODO Auto-generated method stub
                System.out.println("onPageScrollStateChanged");


            }
        });


    }
}