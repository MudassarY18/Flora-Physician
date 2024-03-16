package com.example.floraphysician;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Crop_List_Activity extends AppCompatActivity {

    ImageView apple_img,blueberry_img,cherry_img,corn_img,grape_img,
              orange_img,peach_img,pepper_bell_img,potato_img,raspberry_img,
              soybean_img,squash_img,strawberry_img,tomato_img;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_crop__list_);




        apple_img=findViewById(R.id.apple_img);
        blueberry_img=findViewById(R.id.blueberry_img);
        cherry_img=findViewById(R.id.cherry_img);
        corn_img=findViewById(R.id.corn_img);
        grape_img=findViewById(R.id.grape_img);
        orange_img=findViewById(R.id.orange_img);
        peach_img=findViewById(R.id.peach_img);
        pepper_bell_img=findViewById(R.id.pepper_bell_img);
        potato_img=findViewById(R.id.potato_img);
        raspberry_img=findViewById(R.id.raspberry_img);
        soybean_img=findViewById(R.id.soybean_img);
        squash_img=findViewById(R.id.squash_img);
        strawberry_img=findViewById(R.id.strawberry_img);
        tomato_img=findViewById(R.id.tomato_img);



        apple_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Crop_List_Activity.this,DetectActivity.class);
                intent.putExtra("EXTRA_SESSION_IMAGE", R.drawable.apple_list);
                intent.putExtra("EXTRA_SESSION_TEXT", "apple");
                startActivity(intent);
            }
        });

        blueberry_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Crop_List_Activity.this,DetectActivity.class);
                intent.putExtra("EXTRA_SESSION_IMAGE", R.drawable.blueberry_list);
                intent.putExtra("EXTRA_SESSION_TEXT", "blueberry");
                startActivity(intent);
            }
        });

        cherry_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Crop_List_Activity.this,DetectActivity.class);
                intent.putExtra("EXTRA_SESSION_IMAGE", R.drawable.cherry_list);
                intent.putExtra("EXTRA_SESSION_TEXT", "cherry");
                startActivity(intent);
            }
        });

        corn_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Crop_List_Activity.this,DetectActivity.class);
                intent.putExtra("EXTRA_SESSION_IMAGE", R.drawable.corn_list);
                intent.putExtra("EXTRA_SESSION_TEXT", "corn");
                startActivity(intent);
            }
        });


        grape_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Crop_List_Activity.this,DetectActivity.class);
                intent.putExtra("EXTRA_SESSION_IMAGE", R.drawable.grape_list);
                intent.putExtra("EXTRA_SESSION_TEXT", "grape");
                startActivity(intent);
            }
        });


        orange_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Crop_List_Activity.this,DetectActivity.class);
                intent.putExtra("EXTRA_SESSION_IMAGE", R.drawable.orange_list);
                intent.putExtra("EXTRA_SESSION_TEXT", "orange");
                startActivity(intent);
            }
        });


        peach_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Crop_List_Activity.this,DetectActivity.class);
                intent.putExtra("EXTRA_SESSION_IMAGE", R.drawable.peach_list);
                intent.putExtra("EXTRA_SESSION_TEXT", "peach");
                startActivity(intent);
            }
        });


        pepper_bell_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Crop_List_Activity.this,DetectActivity.class);
                intent.putExtra("EXTRA_SESSION_IMAGE", R.drawable.pepper_bell_list);
                intent.putExtra("EXTRA_SESSION_TEXT", "pepper bell");
                startActivity(intent);
            }
        });


        potato_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Crop_List_Activity.this,DetectActivity.class);
                intent.putExtra("EXTRA_SESSION_IMAGE", R.drawable.potato_list);
                intent.putExtra("EXTRA_SESSION_TEXT", "potato");
                startActivity(intent);
            }
        });


        raspberry_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Crop_List_Activity.this,DetectActivity.class);
                intent.putExtra("EXTRA_SESSION_IMAGE", R.drawable.raspberry_list);
                intent.putExtra("EXTRA_SESSION_TEXT", "raspberry");
                startActivity(intent);
            }
        });


        soybean_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Crop_List_Activity.this,DetectActivity.class);
                intent.putExtra("EXTRA_SESSION_IMAGE", R.drawable.soybeans_list);
                intent.putExtra("EXTRA_SESSION_TEXT", "soybean");
                startActivity(intent);
            }
        });


        squash_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Crop_List_Activity.this,DetectActivity.class);
                intent.putExtra("EXTRA_SESSION_IMAGE", R.drawable.squash_list);
                intent.putExtra("EXTRA_SESSION_TEXT", "squash");
                startActivity(intent);
            }
        });


        strawberry_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Crop_List_Activity.this,DetectActivity.class);
                intent.putExtra("EXTRA_SESSION_IMAGE", R.drawable.strawberry_list);
                intent.putExtra("EXTRA_SESSION_TEXT", "strawberry");
                startActivity(intent);
            }
        });


        tomato_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Crop_List_Activity.this,DetectActivity.class);
                intent.putExtra("EXTRA_SESSION_IMAGE", R.drawable.tomato_list);
                intent.putExtra("EXTRA_SESSION_TEXT", "tomato");
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Crop_List_Activity.this,MainActivity.class);
        startActivity(intent);
    }
}
