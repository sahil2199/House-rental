package com.example.houserent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MyHouse extends AppCompatActivity {
    TextView price_fix,bhk_fix,area_fix,address_fix;
    TextView city_fix,additional_details,floor_fix,balcony_fix,balcony_house;
    TextView bedroom_fix,bathroom_fix,bathroom_house,furnish_fix;
    TextView bachelor_fix,maintenance_fix,total_floor_fix;
    TextView car_park_fix,facing_fix,listed_fix,available_fix;

    TextInputEditText price_house,bhk_house,area_house,address_house,city_house,floor_house,furnish_house,available_house;
    TextInputEditText bachelor_house,maintenance_house,car_park_house,facing_house,bedroom_house,listed_house,total_floor_house;
    ImageView img_detail_page1;
    ScrollView scrollView;
    HorizontalScrollView horizontalScrollView;
    View view,view1,view3,view4,view5,view6,view9,view10,view11,view12,view13,view14,view15;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_house);

        img_detail_page1=findViewById(R.id.imageView_detail_page1);


        price_fix=findViewById(R.id.price_fix);
        price_house=findViewById(R.id.price_house);
        bhk_fix=findViewById(R.id.BHK_fix);
        bhk_house=findViewById(R.id.BHK_house);
        area_fix=findViewById(R.id.area_fix);
        area_house=findViewById(R.id.area_house);
        address_fix=findViewById(R.id.address_fix);
        address_house=findViewById(R.id.address_house);
        city_fix=findViewById(R.id.City_fix);
        city_house=findViewById(R.id.City_house);
        additional_details=findViewById(R.id.Additional_details);
        floor_fix=findViewById(R.id.Floor_fix);
        floor_house=findViewById(R.id.Floor_house);
        balcony_fix=findViewById(R.id.Balcony_fix);
        balcony_house=findViewById(R.id.Balcony_house);
        bedroom_fix=findViewById(R.id.Bedroom_fix);
        bedroom_house=findViewById(R.id.Bedroom_house);
        bathroom_fix=findViewById(R.id.Bathroom_fix);
        bathroom_house=findViewById(R.id.Bathroom_house);
        maintenance_fix=findViewById(R.id.Maintenance_fix);
        maintenance_house=findViewById(R.id.Maintenance_house);
        furnish_fix=findViewById(R.id.Furnish_fix);
        furnish_house=findViewById(R.id.Furnish_house);
        bachelor_fix=findViewById(R.id.Bachelors_fix);
        bachelor_house=findViewById(R.id.Bachelors_house);
        total_floor_fix=findViewById(R.id.Total_floor_fix);
        total_floor_house=findViewById(R.id.Total_floor_house);
        car_park_fix=findViewById(R.id.Car_parking_fix);
        car_park_house=findViewById(R.id.Car_parking_house);
        facing_fix=findViewById(R.id.Facing_fix);
        facing_house=findViewById(R.id.Facing_house);
        listed_fix=findViewById(R.id.Listed_fix);
        listed_house=findViewById(R.id.Listed_house);
        available_fix=findViewById(R.id.available_fix);
        available_house=findViewById(R.id.available_house);


        scrollView=findViewById(R.id.scrollView_detail_page);
        horizontalScrollView=findViewById(R.id.horizontal_scrollView_imageView);



        view=findViewById(R.id.view);
        view1=findViewById(R.id.view1);
        view3=findViewById(R.id.view3);
        view4=findViewById(R.id.view4);
        view5=findViewById(R.id.view5);
        view6=findViewById(R.id.view6);
        view9=findViewById(R.id.view9);
        view10=findViewById(R.id.view10);
        view11=findViewById(R.id.view11);
        view12=findViewById(R.id.view12);
        view13=findViewById(R.id.view13);
        view14=findViewById(R.id.view14);
        view15=findViewById(R.id.view15);


        getSupportActionBar().setTitle("My House Detail");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}
