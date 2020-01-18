package com.example.houserent;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class houselistadapter extends RecyclerView.Adapter<houselistadapter.MyViewHolder> {
        public Context context;
        ArrayList<Bitmap> img;
        ArrayList<String> title,desc,price,area;
        public class MyViewHolder extends RecyclerView.ViewHolder{
            public ImageView img;
            public TextView title,desc,area,price;
            public MyViewHolder(View view){
                super(view);
                img=(ImageView) view.findViewById(R.id.imageView);
                title=(TextView) view.findViewById(R.id.title);
                desc=(TextView) view.findViewById(R.id.description);
                area=(TextView) view.findViewById(R.id.area);
                price=(TextView) view.findViewById(R.id.price);
            }
        }
        public houselistadapter(Context context, ArrayList<Bitmap> img,ArrayList<String> title,ArrayList<String> desc,ArrayList<String> price,ArrayList<String> area){
            this.img=img;
            this.title=title;
            this.desc=desc;
            this.price=price;
            this.area=area;
        }
        public MyViewHolder onCreateViewHolder(ViewGroup parent,int viewtype){
            View itemview= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
            return new MyViewHolder(itemview);
        }
        public void onBindViewHolder(MyViewHolder holder,int pos){

        }
        public int getItemCount(){
            return title.size();
        }
    }
