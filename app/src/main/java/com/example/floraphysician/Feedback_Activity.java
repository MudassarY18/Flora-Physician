package com.example.floraphysician;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Feedback_Activity extends AppCompatActivity {

    TextView titlerate,resultrate;
    Button btnfeedback;
    ImageView charPlace,icSprite;
    RatingBar rateStarts;
    String answerValue;
    Animation char_anim,sprite_anim,btn_anim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_feedback_);

        titlerate = findViewById(R.id.titlerate);
        resultrate = findViewById(R.id.resultrate);

        btnfeedback = findViewById(R.id.btnfeedback);

        charPlace = findViewById(R.id.charPlace);
        icSprite = findViewById(R.id.icSprite);

        rateStarts = findViewById(R.id.rateStars);

        // load Animation
        char_anim = AnimationUtils.loadAnimation(this,R.anim.char_anim);
        sprite_anim = AnimationUtils.loadAnimation(this,R.anim.anim_sprite);
        btn_anim = AnimationUtils.loadAnimation(this,R.anim.btn_feed_anim);

        // give animate
        charPlace.startAnimation(char_anim);
        icSprite.startAnimation(sprite_anim);
        btnfeedback.startAnimation(btn_anim);


        //condition
        rateStarts.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                answerValue = String.valueOf((int)(rateStarts.getRating()));
                if(answerValue.equals("1")){
                    charPlace.setImageResource(R.drawable.iconestar);
                    charPlace.startAnimation(char_anim);
                    icSprite.animate().alpha(0).setDuration(300).start();
                    btnfeedback.startAnimation(btn_anim);
                    resultrate.setText("Unusable App");
                }
                else if (answerValue.equals("2")){
                    charPlace.setImageResource(R.drawable.iconestar);
                    charPlace.startAnimation(char_anim);
                    icSprite.animate().alpha(0).setDuration(300).start();
                    btnfeedback.startAnimation(btn_anim);
                    resultrate.setText("Poor App");
                }
                else  if (answerValue.equals("3")){
                    charPlace.setImageResource(R.drawable.icthreestar);
                    charPlace.startAnimation(char_anim);
                    icSprite.animate().alpha(0).setDuration(300).start();
                    btnfeedback.startAnimation(btn_anim);
                    resultrate.setText("Ok App");
                }
                else if (answerValue.equals("4")){
                    charPlace.setImageResource(R.drawable.icthreestar);
                    charPlace.startAnimation(char_anim);
                    icSprite.animate().alpha(1).setDuration(300).start();
                    icSprite.startAnimation(sprite_anim);
                    btnfeedback.startAnimation(btn_anim);
                    resultrate.setText("Good App");
                }
                else if (answerValue.equals("5")){
                    charPlace.setImageResource(R.drawable.icfivestar);
                    charPlace.startAnimation(char_anim);
                    icSprite.animate().alpha(1).setDuration(300).start();
                    icSprite.startAnimation(sprite_anim);
                    btnfeedback.startAnimation(btn_anim);
                    resultrate.setText("Excellent App");
                }
                else{
                    Toast.makeText(Feedback_Activity.this, "No point", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // import font

        Typeface MRegular = Typeface.createFromAsset(getAssets(),"fonts/MR.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(),"fonts/MM.ttf");

        //customize font
        titlerate.setTypeface(MRegular);
        resultrate.setTypeface(MMedium);
        btnfeedback.setTypeface(MMedium);

        btnfeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "syedawais653@gmail.com" });
                intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
                intent.putExtra(Intent.EXTRA_TEXT, "mail body");
                startActivity(Intent.createChooser(intent, ""));

            }
        });
    }
}
