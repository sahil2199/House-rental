package com.example.houserent;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Contact extends AppCompatActivity {
    private TextView contect,to,subject,message;
    private EditText memail,msubject,msg,mobile_no;
    private Button send_email;
    String sellerID;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        memail = findViewById(R.id.pemail);
        msubject = findViewById(R.id.msubject);
        msg = findViewById(R.id.message_text);
        mobile_no = findViewById(R.id.pnum1);
        sellerID = getIntent().getStringExtra("sellerId");
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("Users").child(sellerID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Userprofile userprofile = dataSnapshot.getValue(Userprofile.class);
                memail.setText(userprofile.getTxtEmail());
                msubject.setText("Regarding to rent your house");
                mobile_no.setText(userprofile.getMobileNumber());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}