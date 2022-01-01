package com.example.miniprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.miniprojet.models.User;

public class CompleteProfile extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_profile);

        final Intent i = new Intent(this,HomeActivity.class);

        EditText weight = (EditText) this.findViewById(R.id.weight);
        EditText hight = (EditText) this.findViewById(R.id.hight);
        EditText age = (EditText) this.findViewById(R.id.age);

        radioGroup = (RadioGroup) this.findViewById(R.id.gender);





        Button completeProfile = (Button) this.findViewById(R.id.button);

        completeProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int checked = radioGroup.getCheckedRadioButtonId();
                int gender = 0;



                radioButton = findViewById(checked);

                String text = radioButton.getText().toString();
                if ("Homme".equals(text)) {
                    gender = 0;
                } else if ("Femme".equals(text)) {
                    gender = 1;
                }

                //Toast.makeText(CompleteProfile.this,text,Toast.LENGTH_SHORT ).show();



                float weight_personne = Float.valueOf(weight.getText().toString());
                float height_personne = Float.valueOf(hight.getText().toString());
                int age_personne = Integer.valueOf(age.getText().toString());
                User currentUser = new User(1,null,null,null,null,age_personne,weight_personne,height_personne,gender);
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