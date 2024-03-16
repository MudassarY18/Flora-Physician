package com.example.floraphysician;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;


public class signup extends AppCompatActivity {
    EditText nametext,depatmenttext,emailtext, passwardtext;
    Button regist;
    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        nametext=findViewById(R.id.name);
       // depatmenttext=findViewById(R.id.depat);
        emailtext=findViewById(R.id.mail);
        passwardtext=findViewById(R.id.pass);
        regist=findViewById(R.id.reg_ads);
        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);
    }
    private void registerUser(){
        String email = emailtext.getText().toString();
        String password = passwardtext.getText().toString();
        String name = nametext.getText().toString();
      //  String department = depatmenttext.getText().toString();

        if (TextUtils.isEmpty(name)){
            //email is empty

            Toast.makeText(this, "Enter Name", Toast.LENGTH_SHORT).show();
            //stopping the function execution further
            return;
        }

       /* if (TextUtils.isEmpty(department)){
            //password is empty

            Toast.makeText(this, "Enter department", Toast.LENGTH_SHORT).show();
            //stopping the function execution further
            return;
        }*/ if (TextUtils.isEmpty(email)){
            //password is empty

            Toast.makeText(this, "Enter email", Toast.LENGTH_SHORT).show();
            //stopping the function execution further
            return;
        } if (TextUtils.isEmpty(password)){
            //password is empty

            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
            //stopping the function execution further
            return;
        }

        progressDialog.setMessage("Registring User...");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Intent intent = new Intent(signup.this, MainActivity.class );
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                            //user is successfully logged in
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(), "Registerd Successfully", Toast.LENGTH_SHORT).show();
                        } else {
                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                progressDialog.dismiss();
                                Toast.makeText(getApplicationContext(), "This Email is already registerd", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                            }
                        }
                    }
                });
    }

    public void onClickreg(View view) {
        if (view == regist) {
            registerUser();
        }


    }

}