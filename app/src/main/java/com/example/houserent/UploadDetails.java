package com.example.houserent;

public class UploadDetails {
    private String mTitle;
    private String mImageUrl;
    private String mDescription;
    private String mArea;
    private String mPrice;


    public UploadDetails(){
        //Empty Constructor
    }
    public UploadDetails(String title,String description,String area,String price,String imageUrl){
        mTitle=title;
        mArea=area;
        mDescription=description;
        mImageUrl=imageUrl;
        mPrice=price;
    }

    public String getTitle(){
        return mTitle;
    }
    public void setTitle(String title){
        mTitle=title;
    }


    public String getArea(){
        return mArea;
    }
    public void setArea(String area){
        mArea=area;
    }


    public String getPrice(){
        return mPrice;
    }
    public void setPrice(String price){
        mPrice=price;
    }


    public String getDesccription(){
        return mDescription;
    }
    public void setDescription(String description){
        mDescription=description;
    }

    public String getmImageUrl(){
        return mImageUrl;
    }
    public void setImageUrl(String imageUrl){
        mImageUrl=imageUrl;
    }
}
