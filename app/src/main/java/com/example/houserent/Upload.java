package com.example.houserent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class Upload extends AppCompatActivity {

    private static final int PICK_IMAGE_REQ=1;

    private Button mButtonChooseimage,mButtonUpload;
    private ImageView mImageView;
    private ProgressBar mProgressBar;
    private TextInputEditText mTextTitle,mTextPrice,mTextArea,mTextDescription;

    private Uri mImageUri;

    private StorageReference mStorageReference;
    private DatabaseReference mDatabaseReference;
    private FirebaseUser currentFirebaseUser ;
    private StorageTask mUploadtask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        /*getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);*/
        mButtonChooseimage=findViewById(R.id.button_choose_image);
        mImageView=findViewById(R.id.upload_image_view);
        mProgressBar=findViewById(R.id.progress_bar);
        mButtonUpload=findViewById(R.id.button_upload);
        mTextTitle=findViewById(R.id.text_title);
        mTextDescription=findViewById(R.id.text_description);
        mTextArea=findViewById(R.id.text_area);
        mTextPrice=findViewById(R.id.text_price);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mStorageReference= FirebaseStorage.getInstance().getReference("houses");
        mDatabaseReference= FirebaseDatabase.getInstance().getReference("houses");
        currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;


        mButtonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mUploadtask!=null && mUploadtask.isInProgress()){
                    Toast.makeText(Upload.this, "Upload in Progress...", Toast.LENGTH_SHORT).show();
                }
                else{
                uploadFile();
                }
            }
        });


        mButtonChooseimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void openFileChooser(){
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,PICK_IMAGE_REQ);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_IMAGE_REQ && resultCode == RESULT_OK && data != null && data.getData()!= null){
            mImageUri = data.getData();
            Picasso.get().load(mImageUri).into(mImageView);
            //mImageView.setImageURI(mImageUri);
        }
    }


    private String getFileExtension(Uri uri){
        ContentResolver cR =getContentResolver();
        MimeTypeMap mime =MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }

    private void uploadFile(){
        if(mImageUri!=null) {
            final StorageReference fileReference = mStorageReference.child(System.currentTimeMillis()+"."+getFileExtension(mImageUri));

            mUploadtask = fileReference.putFile(mImageUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Handler handler=new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    mProgressBar.setProgress(0);
                                }
                            },5000);
                            fileReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {

                                    UploadDetails uploadDetails=new UploadDetails(mTextTitle.getText().toString().trim(),
                                            mTextDescription.getText().toString().trim(), mTextArea.getText().toString().trim(),
                                            mTextPrice.getText().toString().trim(),uri.toString());

                                    String getuid=FirebaseAuth.getInstance().getUid();
                                    mDatabaseReference.child(getuid).setValue(uploadDetails);
                                    Toast.makeText(Upload.this, "Upload Successful", Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(getApplicationContext(),MainActivity.class));

                                }
                            });
                            }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Upload.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = ( 100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                            mProgressBar.setProgress( (int) progress);
                        }
                    });
        }
        else
        {
            Toast.makeText(this, "No File Selected", Toast.LENGTH_SHORT).show();
    }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.example_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if(id==R.id.item1){
            startActivity(new Intent(this,Profile.class));

            return true;
        }
        if(id==R.id.item2){
            FirebaseAuth.getInstance().signOut();
            finish();
            Intent intent =new Intent(this,LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

            return true;
        }
        if(id==android.R.id.home)
        onBackPressed();
        return true;
    }
}
