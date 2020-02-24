package com.example.houserent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.squareup.picasso.Picasso;

import java.net.URI;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HouseAdapter extends RecyclerView.Adapter <HouseAdapter.HouseViewHolder>{
    private Context mContext;
    private List<UploadDetails> mUploadDetailes;

    public HouseAdapter(Context context , List<UploadDetails> uploadDetails){
        mContext=context;
        mUploadDetailes=uploadDetails;
    }
    @NonNull
    @Override
    public HouseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.row, parent,false);
        return new HouseViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HouseViewHolder holder, int position) {
        UploadDetails uploadCurrent = mUploadDetailes.get(position);
        holder.textViewTitle.setText(uploadCurrent.getTitle());
        holder.textViewPrice.setText(uploadCurrent.getPrice());
        holder.textViewDescription.setText(uploadCurrent.getDescription());
        //System.out.println(uploadCurrent.getDescription()+"Description");
        holder.textViewArea.setText(uploadCurrent.getArea());
        //holder.imageView.setImageURI(URI.parse(R.drawable.backgroung_splashscreen));
        Picasso.get().load(uploadCurrent.getmImageUrl()).fit().centerCrop().into(holder.imageView);
        Glide.with(mContext).load(uploadCurrent.getmImageUrl()).into(holder.imageView);
        System.out.println("Image "+uploadCurrent.getmImageUrl());
    }

    @Override
    public int getItemCount() {
        return mUploadDetailes.size();
    }

    public class HouseViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewTitle,textViewPrice,textViewArea,textViewDescription;
        public ImageView imageView;

        public HouseViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle=itemView.findViewById(R.id.text_title);
            textViewArea=itemView.findViewById(R.id.text_area);
            textViewDescription=itemView.findViewById(R.id.text_description);
            textViewPrice=itemView.findViewById(R.id.text_price);
            imageView=itemView.findViewById(R.id.image_view_upload);
        }
    }
}
