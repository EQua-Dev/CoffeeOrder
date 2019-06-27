package com.example.coffeeorder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.KeyStore;

public class MainActivity extends AppCompatActivity {

    EditText userNameEdttxt ;
    EditText passwordEdttxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);


        userNameEdttxt = findViewById(R.id.username);
        passwordEdttxt = findViewById(R.id.password);



        final Button button = findViewById(R.id.loginButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Denies user access to OrderPage if credential requirements are not satisfied
                if(userNameEdttxt.getText().toString().isEmpty()|| passwordEdttxt.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Input Username and Password", Toast.LENGTH_SHORT).show();

                }else {
                    // Creates a new intent to OrderPage when login button is clicked
                    Intent myIntent = new Intent(MainActivity.this, OrderPage.class);
                    MainActivity.this.startActivity(myIntent);


                }

            }


        });
    }


    }

