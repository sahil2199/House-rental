package com.example.houserent;

public class Userprofile {
    public String firstName;
    public String lastName;
    public String txtEmail;
    public String mobileNumber;

    public Userprofile() {
        //empty constructor
    }


    public Userprofile(String fname, String lname, String txtemail, String mnumber) {
        firstName = fname;
        lastName = lname;
        txtEmail = txtemail;
        mobileNumber = mnumber;


    }

  /*  public String getFname() {
        return mfname;
    }

    public void setFname(String fname) {
        mfname = fname;
    }

    public String getLname(){
        return mlname;
    }
    public void setLname(String lname){
        mlname=lname;
    }


    public String getTxtemail(){
        return mtxtemail;
    }
    public void setTxtemail(String txtemail){
        mtxtemail=txtemail;
    }

    public String getMnumber(){
        return mmnumber;
    }
    public void setMnumber(String mnumber){
        mmnumber=mnumber;
    }*/
}

