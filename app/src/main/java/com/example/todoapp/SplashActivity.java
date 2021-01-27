package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    TextView welcomeText;
    Animation welcomeAnimation,bg_anim;
    ImageView bgImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        welcomeText=findViewById(R.id.welcomeText);
        bgImg=findViewById(R.id.bg_img);
        bg_anim=AnimationUtils.loadAnimation(this,R.anim.background_animation);
        welcomeAnimation= AnimationUtils.loadAnimation(this,R.anim.text_animation);
        bgImg.startAnimation(bg_anim);
        welcomeText.startAnimation(welcomeAnimation);
        Handler handler=new Handler();
        handler.postDelayed(() -> {
            Intent intent=new Intent(SplashActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        },2000);
    }


}