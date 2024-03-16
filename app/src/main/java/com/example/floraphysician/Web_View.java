package com.example.floraphysician;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

@SuppressWarnings("ALL")
public class Web_View extends AppCompatActivity {

    WebView web_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web__view);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        TextView message = findViewById(R.id.no_internet_message);
        message.setVisibility(View.INVISIBLE);

        web_view =findViewById(R.id.web_view);

        WebSettings webSettings = web_view.getSettings();
        webSettings.setJavaScriptEnabled(true);
        ConnectivityManager connectivityManager = (ConnectivityManager)
                getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo == null || !networkInfo.isConnected() || !networkInfo.isAvailable()){

            final Dialog dialog = new Dialog(this);

            dialog.setContentView(R.layout.alert_dialog);
            dialog.setCanceledOnTouchOutside(false);
            dialog.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            dialog.getWindow().getAttributes().windowAnimations = android.R.style.Animation_Dialog;

            message.setVisibility(View.VISIBLE);

            Button btnTryAgain = dialog.findViewById(R.id.btn_try_again);
            btnTryAgain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recreate();
                    dialog.dismiss();
                }
            });
            dialog.show();
        }else{
            message.setVisibility(View.INVISIBLE);
            Intent intent = getIntent();
            String str = intent.getStringExtra("Url");
            web_view.loadUrl(str);
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Web_View.this,Help_Activity.class);
        startActivity(intent);
    }
}
