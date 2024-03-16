package com.example.floraphysician;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class signin extends AppCompatActivity {
    EditText emailtext, passwardtext;

    private FirebaseAuth mAth;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        emailtext = (EditText) findViewById(R.id.email);
        passwardtext = (EditText) findViewById(R.id.password);
        mAth= FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        progressDialog.setCanceledOnTouchOutside(false);

        FirebaseUser firebaseUser = mAth.getCurrentUser();

        if(firebaseUser !=null){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();

        }





    }
    public void signin(View view){
        final String email = emailtext.getText().toString().trim();
        final String password = passwardtext.getText().toString().trim();
        if (email.isEmpty()){
            emailtext.setError("email required");
            emailtext.requestFocus();
            return;
        }
        if (password.isEmpty()){
            passwardtext.setError("passward required");
            passwardtext.requestFocus();
            return;
        }
        progressDialog.setMessage("signing....");
        progressDialog.show();

        mAth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                            Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();

                        }else {
                            Toast.makeText(signin.this, "something wrong", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                    }
                });





    }

    public void signup(View view) {
        Intent intent=new Intent(signin.this, signup.class);
        startActivity(intent);
        finish();
    }

}
