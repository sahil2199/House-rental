package com.example.houserent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class houselist extends AppCompatActivity {
    RecyclerView rv;
    ImageView img;
    TextView area,price,title,desc;
    CardView cv;
    ArrayList<String> image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_houselist);
        img=(ImageView) findViewById(R.id.imageView);
        area=(TextView) findViewById(R.id.area);
        price=(TextView) findViewById(R.id.price);
        title=(TextView) findViewById(R.id.title);
        desc=(TextView) findViewById(R.id.description);
        cv=(CardView) findViewById(R.id.cv);

    }
}
