package com.example.houserent;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class houselistadapter {
    String image,description,title,area,price;
    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView area,price,title,desc;
        CardView cv;
        public MyViewHolder(View view)
        {
            img=(ImageView) view.findViewById(R.id.imageView);
            area=(TextView) view.findViewById(R.id.area);
            price=(TextView) view.findViewById(R.id.price);
            title=(TextView) view.findViewById(R.id.title);
            desc=(TextView) view.findViewById(R.id.description);
            cv=(CardView) view.findViewById(R.id.cv);
        }
    }

}
