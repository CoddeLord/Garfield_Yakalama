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

public class EasyActivity extends AppCompatActivity {

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

    ImageView [] imageArry;

    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy);


        textView = findViewById(R.id.textView20);
        textView1 = findViewById(R.id.SkorText1);

        imageView = findViewById(R.id.imageView20);
        imageView1 = findViewById(R.id.imageView21);
        imageView2 = findViewById(R.id.imageView22);
        imageView3 = findViewById(R.id.imageView23);
        imageView4 = findViewById(R.id.imageView24);
        imageView5 = findViewById(R.id.imageView25);
        imageView6 = findViewById(R.id.imageView26);
        imageView7 = findViewById(R.id.imageView27);
        imageView8 = findViewById(R.id.imageView28);

        imageArry = new ImageView[] {imageView, imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8};

        HiddenImage();

        new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long l) {
                textView.setText("Zaman : " +l/1000);
            }

            @Override
            public void onFinish() {
                textView.setText("Süre Doldu");

                handler.removeCallbacks(runnable);

                for (ImageView image : imageArry){
                    image.setVisibility(View.INVISIBLE);
                }

                AlertDialog.Builder alert= new AlertDialog.Builder(EasyActivity.this);
                alert.setTitle("Oyun Bitti");
                alert.setMessage("Tekrar Oynamak İstermisiniz");
                alert.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
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
                        Intent intent = new Intent(EasyActivity.this, LevelActivity.class);
                        startActivity(intent);
                    }
                });
                alert.show();

            }
        }.start();


    }

    public void easyCat(View view){
        number ++;
        textView1.setText("Skor : " +number);
    }

    public void HiddenImage(){
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for (ImageView image : imageArry){
                    image.setVisibility(View.INVISIBLE);
                }
                Random random = new Random();

                int i = random.nextInt(9);
                imageArry[i].setVisibility(View.VISIBLE);

                handler.postDelayed(this, 700);
            }
        };
        handler.post(runnable);
    }
}