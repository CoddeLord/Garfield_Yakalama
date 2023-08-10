package com.byredcode.garfieldyakalama;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MediumActivity extends AppCompatActivity {

    TextView textView, textView1;

    Handler handler;
    Runnable runnable;

    ImageView imageView;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView imageView10;
    ImageView imageView11;


    ImageView [] imageArray;

    int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medium);

        textView = findViewById(R.id.MediumTime);
        textView1 = findViewById(R.id.MediumSkor);


        imageView = findViewById(R.id.imageView30);
        imageView1 = findViewById(R.id.imageView31);
        imageView2 = findViewById(R.id.imageView32);
        imageView3 = findViewById(R.id.imageView33);
        imageView4 = findViewById(R.id.imageView34);
        imageView5 = findViewById(R.id.imageView35);
        imageView6 = findViewById(R.id.imageView36);
        imageView7 = findViewById(R.id.imageView37);
        imageView8 = findViewById(R.id.imageView38);
        imageView9 = findViewById(R.id.imageView39);
        imageView10 = findViewById(R.id.imageView40);
        imageView11 = findViewById(R.id.imageView41);


        imageArray = new ImageView[] {imageView,imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9,imageView10,imageView11};


        hiddenMedium();
        new CountDownTimer(45000,1000){

            @Override
            public void onTick(long l) {
                textView.setText("Zaman : " +l/1000);
            }

            @Override
            public void onFinish() {
                textView.setText("Süre Doldu");
                handler.removeCallbacks(runnable);

                for (ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);
                }

                AlertDialog.Builder alert = new AlertDialog.Builder( MediumActivity.this);
                alert.setTitle("Oyun Bitti");

                alert.setMessage("Tekrar Oynamak İstermisin");
                alert.setPositiveButton("Evet ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                    }
                });

                alert.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(MediumActivity.this, LevelActivity.class);
                        startActivity(intent);
                    }
                });
                alert.show();
            }
        }.start();
    }


    public void MediumCat(View view){
        number++;
        textView1.setText("Skor : " +number);
    }


    public void hiddenMedium(){
        handler= new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for ( ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);
                }
                Random random = new Random();
                int i = random.nextInt(11);
                imageArray[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this, 550);
            }
        };
        handler.post(runnable);
    }

}