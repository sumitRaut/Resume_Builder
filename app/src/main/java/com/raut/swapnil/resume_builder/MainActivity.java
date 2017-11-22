package com.raut.swapnil.resume_builder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView image1, image2 , image3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image1 = (ImageView)findViewById(R.id._image);
        image2 = (ImageView)findViewById(R.id._image2);
        image3 = (ImageView)findViewById(R.id._image3);

        image1.setOnClickListener(this);
        image2.setOnClickListener(this);
        image3.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        Intent i;
        switch (view.getId()){

            case R.id._image:
                i = new Intent(MainActivity.this, Personal_Details.class);
                startActivity(i);
                break;

            case R.id._image2:
                i =new Intent(MainActivity.this, Personal_Details.class);
                startActivity(i);
                break;

            case R.id._image3:
                i = new Intent(MainActivity.this, Personal_Details.class);
                startActivity(i);
                break;

        }
    }
}
