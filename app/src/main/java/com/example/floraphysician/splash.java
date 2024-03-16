package com.example.floraphysician;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Circle;

public class splash extends AppCompatActivity {
    TextView tvSplash, tvSubSplash;
    Animation alpha_to_go,btgone,btgtwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final ProgressBar progressBar = (ProgressBar)findViewById(R.id.spin_kit);
        final Sprite circle = new Circle();
        progressBar.setVisibility(View.INVISIBLE);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        tvSplash=findViewById(R.id.ptext);
        tvSubSplash=findViewById(R.id.ntext);

        // load animation
        alpha_to_go= AnimationUtils.loadAnimation(this,R.anim.alpha_to_go);
        btgone=AnimationUtils.loadAnimation(this,R.anim.btgone);
        btgtwo=AnimationUtils.loadAnimation(this,R.anim.btgtwo);

        // passing animation

        tvSplash.startAnimation(btgone);
        tvSubSplash.startAnimation(btgone);


        //import font
        Typeface MLight = Typeface.createFromAsset(getAssets(),"fonts/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(),"fonts/MMedium.ttf");
        Typeface MRegular = Typeface.createFromAsset(getAssets(),"fonts/MRegular.ttf");

        // customize font
        tvSplash.setTypeface(MRegular);
        tvSubSplash.setTypeface(MLight);

        progressBar.setIndeterminateDrawable(circle);
        progressBar.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent a=new Intent(splash.this,MainActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
                finish();
            }
        }, 5000);
    }
}




