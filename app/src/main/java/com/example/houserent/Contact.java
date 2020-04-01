package com.example.houserent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.os.Bundle;

public class Contact extends AppCompatActivity {
    TextView mfirstname,mlastname,mtitle,memail,mnum;
    EditText mtxtemail,fname,lname;
    EditText mmnumber,mpnum;
    Button btn_enow;
    private FirebaseAuth mAuth;
    String email, fullname, mobilenumber;
    FirebaseDatabase mfirebaseDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        mtitle=findViewById(R.id.title1);
        fname=findViewById(R.id.fname);
        lname=findViewById(R.id.lname);
        memail=findViewById(R.id.email);
        mnum=findViewById(R.id.num);
        mpnum=findViewById(R.id.pnum);
        mfirstname = findViewById(R.id.firstname);
        mlastname = findViewById(R.id.lastname);
        mtxtemail = findViewById(R.id.pemail);
        mmnumber = findViewById(R.id.pnum1);
        btn_enow = findViewById(R.id.contact_button);
        getSupportActionBar().setTitle("Contact");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference=firebaseDatabase.getReference();
        databaseReference.child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Userprofile userprofile=dataSnapshot.getValue(Userprofile.class);
                fname.setText(userprofile.getFirstName());
                lname.setText(userprofile.getLastName());
                mmnumber.setText(userprofile.getMobileNumber());
                mtxtemail.setText(userprofile.getTxtEmail());

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Contact.this,databaseError.getCode(),Toast.LENGTH_SHORT).show();
            }
        });
        
        /*mfirebaseDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
        btn_enow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = mtxtemail.getText().toString().trim();
                fullname = mfullname.getText().toString().trim();
                mobilenumber = mmnumber.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(Contact.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(fullname)) {
                    Toast.makeText(Contact.this, "Please Enter Full Name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(mobilenumber)) {
                    Toast.makeText(Contact.this, "Please Enter Mobile Number", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    */
    }
}
