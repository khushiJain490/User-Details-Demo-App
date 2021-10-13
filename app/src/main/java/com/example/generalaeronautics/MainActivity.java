package com.example.generalaeronautics;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout email;
    private TextInputLayout password;
    String pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loader load = new loader(MainActivity.this);

        Button login = (Button) findViewById(R.id.cirLoginButton);


        login.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                email = findViewById(R.id.textInputEmail);
                password = (TextInputLayout) findViewById(R.id.textInputEmail);

                final String emailInput = email.getEditText().getText().toString().trim();
                final String phonelInput = email.getEditText().getText().toString().trim();
                final String pass = password.getEditText().getText().toString().trim();


                if (validateEmail(emailInput) == false && validatePhone(phonelInput) == false || pass.isEmpty() == true) {
                    Toast.makeText(MainActivity.this, "Not a valid Input", Toast.LENGTH_LONG).show();

                } else {

                    load.startLoading();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            load.dissmissDialog();
                        }
                    }, 5000);

                    startActivity(new Intent(MainActivity.this, homeScreenActivity.class));
                }

            }


        });
    }


    private boolean validateEmail(String email) {

        if (Patterns.EMAIL_ADDRESS.matcher(email).matches())
            return true;
        else
            return false;
    }

    private boolean validatePhone(String phone) {
        if (Patterns.PHONE.matcher(phone).matches())
            return true;
        else
            return false;
    }


}






