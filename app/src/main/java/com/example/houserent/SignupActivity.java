package com.example.houserent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
public class SignupActivity extends AppCompatActivity {
    TextInputEditText fname,lname,txtemail,mnumber,nwpwd,cfmpwd;
    Button btn_reg;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        fname = findViewById(R.id.firstname);
        lname=findViewById(R.id.lastname);
        txtemail=findViewById(R.id.textemail);
        mnumber=findViewById(R.id.mobilenumber);
        nwpwd=findViewById(R.id.newpwd);
        cfmpwd=findViewById(R.id.confirmpwd);
        btn_reg=findViewById(R.id.registerbutton);



        mAuth=FirebaseAuth.getInstance();
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=txtemail.getText().toString().trim();
                String password=nwpwd.getText().toString().trim();
                String confirmpassword=cfmpwd.getText().toString().trim();
                String firstname=fname.getText().toString().trim();
                String lastname=lname.getText().toString().trim();
                String mobilenumber=mnumber.getText().toString().trim();


                if (TextUtils.isEmpty(email)){
                    Toast.makeText(SignupActivity.this,"Please Enter Email",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(SignupActivity.this,"Please Enter Password",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(confirmpassword)){
                    Toast.makeText(SignupActivity.this,"Please Enter Confirm Password",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.length()<8){
                    Toast.makeText(SignupActivity.this,"Password Length Must be 8 or Greater",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(password.equals(confirmpassword)){
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                     startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                     Toast.makeText(SignupActivity.this,"Registration Successful",Toast.LENGTH_SHORT).show();
                                    }
                                    else{
                                        Toast.makeText(SignupActivity.this, "Authentication failed", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });

                }


            }
        });




    }
}
