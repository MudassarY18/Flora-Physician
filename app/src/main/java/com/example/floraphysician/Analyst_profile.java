package com.example.floraphysician;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

public class Analyst_profile extends AppCompatActivity {


   HorizontalInfiniteCycleViewPager pager;
    Custom_Adapter adapter;



       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
           setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_analyst_profile);




        pager=findViewById(R.id.cycle_viewpager);
        adapter=new Custom_Adapter(this);
        pager.setAdapter(adapter);


       }


}
