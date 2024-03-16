package com.example.floraphysician;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Help_Activity extends AppCompatActivity {

    RecyclerView NewsRecyclerview;
    NewsAdapter newsAdapter;
    List<NewsItem> mData;
    FloatingActionButton fabSwitcher;
    boolean isDark = false;
    ConstraintLayout rootLayout;
    EditText searchInput ;
    CharSequence search="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_help_);
       // ini view

        fabSwitcher = findViewById(R.id.fab_switcher);
        rootLayout = findViewById(R.id.root_layout);
        searchInput = findViewById(R.id.search_input);
        NewsRecyclerview = findViewById(R.id.news_rv);
        mData = new ArrayList<>();

        Intent  intent = getIntent();
        String str = intent.getStringExtra("medicine");
        searchInput.setText(str);







        // load theme state

        isDark = getThemeStatePref();
        if(isDark) {
            // dark theme is on

            searchInput.setBackgroundResource(R.drawable.search_input_dark_style);
            rootLayout.setBackgroundColor(getResources().getColor(R.color.black));


        }
        else
        {
            // light theme is on
            searchInput.setBackgroundResource(R.drawable.search_input_style);
            rootLayout.setBackgroundColor(getResources().getColor(R.color.white));


        }



        // fill list news with data
        mData.add(new NewsItem("Dithane M45","Dithane is fungicide chemical for Apple black rot disease. Dithane special fungicide is a unique broad-spectrum multisite fungicide that offers long-lasting protection and better disease control than other fungicides in its class. It is recommended for use at nurseries, greenhouses, sod farms, golf courses and other commercial turf settings.","Year of launch (1961)",R.drawable.dithane));
        mData.add(new NewsItem("Orchard Spray","Non-toxic solutions for orchards have been difficult to locate — until now. Bonide Orchard Spray is a safe, one-hit concentrate for common insect attacks and fungal problems. Small-scale gardeners will find it a great value because it’s also formulated for use on vegetables, ornamental plants, houseplants and even lawns!","Year of launch (1956)",R.drawable.orchard_spray));
        mData.add(new NewsItem("Mencozeb","Antifungal chemical Mencozeb is a dithiocarbamate non-systemic agricultural fungicide with multi-site, protective action on contact. It is a combination of two other dithiocarbamates: maneb and zineb. The mixture controls many fungal diseases in a wide range of field crops, fruits, nuts, vegetables, and ornamentals.","Year of launch (1962)",R.drawable.mencozeb));
        mData.add(new NewsItem("Ridomil","RIDOMIL GOLD controls soil and leaf diseases in a number of crops including vegetables, grapes, citrus, potatoes,ornamentals,tobacco and cotton. RIDOMIL GOLD is a highly effective fungicide for the control of Oomycete fungi (including late blight and Downy mildew)","Year of launch (1977)",R.drawable.ridomil));
        mData.add(new NewsItem("Gramoxone","GRAMOXONE is a unique, fast acting, non-selective, contact herbicide for control of most fibrous rooted grasses and annual broadleaf weeds with varied uses in a wide variety of crops. GRAMOXONE is a non-selective herbicide that is used by millions of growers and is, after nearly 50 years, still one of the most widely used herbicides in the world. It is used in around 100 countries on more than 100 crops.\n" +
                "Gramoxone is use for Maize, Soya, wheat, rice, potatoes, fruit (oranges, apples, bananas), coffee, tea, cocoa, cotton and sugarcane.","Year of launch (1955)",R.drawable.gramoxone));
        mData.add(new NewsItem("Liquid Copper Spray","Approved for organic gardening! Bonide Liquid Copper Spray controls a wide range of plant diseases, including powdery mildew, rusts, black spot, late blight and more. May be applied as a dormant or growing season spray on flowers, fruits and vegetables. Will NOT burn plants.","Year of launch(1962)",R.drawable.copper));
        mData.add(new NewsItem("Natural Disease\nControl","Monterey All Natural Disease Control is a ready-to-use blend of naturally occurring ingredients that control plant foliar diseases. All stages of the disease is controlled, but applying before infestation gives the best results. May be applied any time during the growing season up to the day of harvest on crops. Non-phytotoxic — will not burn plants when used as directed." +
                " This product meets the program standards set forth by the National Organic Program (NOP).","Year of launch(1962)",R.drawable.natural_disease_control));
        mData.add(new NewsItem("Garden Fungicide","Ideal for use on fruits, vegetables and flowers! Safer Garden Fungicide contains sulfur (0.40%) to control a long list of fungal diseases including powdery mildew, rust, scab, brown rot, rose black spot and more. Works great on roses and tomatoes! OMRI Listed for use in organic production.","Year of launch(1969)",R.drawable.garden_fungicide));


        // adapter ini and setup

        newsAdapter = new NewsAdapter(this,mData,isDark);
        NewsRecyclerview.setAdapter(newsAdapter);
        NewsRecyclerview.setLayoutManager(new LinearLayoutManager(this));


        fabSwitcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDark = !isDark ;
                if (isDark) {
                    recreate();
                    rootLayout.setBackgroundColor(getResources().getColor(R.color.black));
                    searchInput.setBackgroundResource(R.drawable.search_input_dark_style);


                }
                else {
                    recreate();
                    rootLayout.setBackgroundColor(getResources().getColor(R.color.white));
                    searchInput.setBackgroundResource(R.drawable.search_input_style);

                }

                newsAdapter = new NewsAdapter(getApplicationContext(),mData,isDark);
                if (!search.toString().isEmpty()){

                    newsAdapter.getFilter().filter(search);

                }

                NewsRecyclerview.setAdapter(newsAdapter);
                saveThemeStatePref(isDark);




            }
        });


        searchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                newsAdapter.getFilter().filter(s);
                search = s;


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



    }

    private void saveThemeStatePref(boolean isDark) {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPref",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isDark",isDark);
        editor.commit();
    }

    private boolean getThemeStatePref () {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPref",MODE_PRIVATE);
        boolean isDark = pref.getBoolean("isDark",false) ;
        return isDark;

    }



    public void onBackPressed() {
        Intent intent = new Intent(Help_Activity.this,MainActivity.class);
        startActivity(intent);
    }

}

