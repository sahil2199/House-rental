package com.example.houserent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AboutUs extends AppCompatActivity {
    TextView title,title1,des;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        title=findViewById(R.id.house_title);
        title1=findViewById(R.id.house_title1);
        des=findViewById(R.id.house_des);
    }
}
