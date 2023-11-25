package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView1 = findViewById(R.id.textview1);
        textView2 = findViewById(R.id.textView2);
        button = findViewById(R.id.button2);

        //Receiving the name from first activity
        Intent intent = getIntent();
        String userName = intent.getStringExtra("name");

        //generate random numbers
        int randomNumber = generateRandomNumber();
        textView2.setText(""+randomNumber);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(userName, randomNumber);
            }
        });

    }

    public int generateRandomNumber(){
        Random random = new Random();
        int upperLimit = 999;

        int randomNumber = random.nextInt(upperLimit);
        return randomNumber;
    }

    public void shareData(String userName, int randomNumber){

        //Implicit Intent
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_SUBJECT, userName + " got luck today!");
        intent.putExtra(Intent.EXTRA_TEXT, "His lucky number is "+ randomNumber);
        startActivity(Intent.createChooser(intent, "Choose a platform"));
    }
}