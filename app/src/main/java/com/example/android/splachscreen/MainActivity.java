package com.example.android.splachscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView diamondImage2;
    TextView welcomeMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();


        Animation animation = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        diamondImage2.setAnimation(animation);
        welcomeMessage.setAnimation(animation);


        Thread timer = new Thread(){
            @Override
            public void run() {

                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    goToMainClass();
                    finish();

                }
            }
        };
        timer.start();
    }

    private void goToMainClass() {
        startActivity(new Intent(this,Main.class));
    }

    private void initializeViews() {
        diamondImage2 = findViewById(R.id.diamondImage);
        welcomeMessage = findViewById(R.id.welcomeMessage);
    }
}
