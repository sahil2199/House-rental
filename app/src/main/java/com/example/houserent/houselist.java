package com.example.houserent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Person;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import sun.*;

public class houselist extends AppCompatActivity {
    RecyclerView rv;
    ImageView img;
    TextView area,price,title,desc;
    CardView cv;
    ArrayList<String> area_string,price_string,title_string,desc_string;
    ArrayList<Bitmap> image;
    FirebaseAuth auth;
    FirebaseDatabase fd;
    DatabaseReference ref;

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
        auth=FirebaseAuth.getInstance();
        fd=FirebaseDatabase.getInstance();
        ref=fd.getReference().child("houses");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    getdata((Map<String,Object>) dataSnapshot.getValue());
;            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(layoutManager);
        houselistadapter ob=new houselistadapter(getApplicationContext(),image,title_string,desc_string,area_string,price_string);
        rv.setAdapter(ob);
    }
    public void getdata(Map<String,Object> houses)
    {
        image=new ArrayList<Bitmap>();
        area_string=new ArrayList<String>();
        price_string=new ArrayList<String>();
        title_string=new ArrayList<String >();
        desc_string=new ArrayList<String >();
        for(Map.Entry<String, Object> entry : houses.entrySet())
        {
            Map house=(Map) entry.getValue();
            String img=((String) house.get("image"));
            byte[] by=android.util.Base64.decode(img,16);
            InputStream inputStream  = new ByteArrayInputStream(by);
            Bitmap bitmap  = BitmapFactory.decodeStream(inputStream);
            image.add(bitmap);
            area_string.add((String) house.get("area"));
            price_string.add((String) house.get("price"));
            title_string.add((String) house.get("title"));
            desc_string.add((String) house.get("description"));
        }
    }
}
