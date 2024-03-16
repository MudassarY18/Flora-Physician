package com.example.floraphysician;

import android.animation.ArgbEvaluator;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors=null;
    ArgbEvaluator argbEvaluator=new ArgbEvaluator();
    Button get_start_btn;
    ImageView home_img;

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setCancelable(false)
                .setTitle("Confirm Exit")
                .setMessage("Are you sure you want to exit Flora Physician?")
                .setPositiveButton("Exit", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            finishAffinity();
                        }
                    }
                })
                .setNegativeButton("Cancel", null)
                .show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        get_start_btn=findViewById(R.id.btn_getstarted);


        View card_view= getLayoutInflater().inflate(R.layout.item,null);
        home_img =card_view.findViewById(R.id.home_image);


        models = new ArrayList<>();
        models.add(new Model(R.drawable.computer,"Diagnose and Prescription","Capture and Upload Defected leaf of crops and detect Disease and Relative Medicine"));
        models.add(new Model(R.drawable.analyst_icon,"Analysts","See Profile of Analyst and Make call for quries about crops Disease"));
        models.add(new Model(R.drawable.medicine_icon,"Help","Instruction for How to use Medicine"));
        models.add(new Model(R.drawable.rating,"Rating and Feedback","Suggestion for improvement"));
        models.add(new Model(R.drawable.logout,"logout","logout in this app"));

        adapter= new Adapter(models,this);
        viewPager=findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,130,0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color5)};

        colors = colors_temp;



        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(final int position, float positionOffset, int positionOffsetPixels) {



                if (position <(adapter.getCount() -1) && position < (colors.length - 1)){
                    viewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(
                            positionOffset,colors[position],colors[position + 1]));


                    if(position==0)
                    {

                        get_start_btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent a=new Intent(MainActivity.this,Crop_List_Activity.class);
                                startActivity(a);
                            }
                        });

                    }else if (position == 1)
                    {

                        get_start_btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent b=new Intent(MainActivity.this,Analyst_profile.class);
                                startActivity(b);
                            }
                        });

                    }else if (position == 2)
                    {



                        get_start_btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent c=new Intent(MainActivity.this,Help_Activity.class);
                                startActivity(c);
                            }
                        });

                    }

                }else

                    if (position == 3)
                    {
                    get_start_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent b=new Intent(MainActivity.this,Feedback_Activity.class);
                            startActivity(b);
                        }
                    });


                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }else

                    if (position == 4)
                    {
                    get_start_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            FirebaseAuth.getInstance().signOut();
                            Intent intent = new Intent(MainActivity.this, signin.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                            startActivity(intent);
                        }
                    });

                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

    }
}

