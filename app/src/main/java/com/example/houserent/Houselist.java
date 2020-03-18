package com.example.houserent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Houselist extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private HouseAdapter mAdapter;

    private DatabaseReference mDatabaseReference;
    private List<UploadDetails> mUploadDetails;
    private ProgressBar mProgressCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_houselist);
        mRecyclerView=findViewById(R.id.recycler_view);
        mProgressCircle=findViewById(R.id.progress_cirle);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mUploadDetails = new ArrayList<>();
        mDatabaseReference = FirebaseDatabase.getInstance().getReference("houses");
        getSupportActionBar().setTitle("House List");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapShot : dataSnapshot.getChildren()){
                    UploadDetails uploadDetails = postSnapShot.getValue(UploadDetails.class);
                    System.out.println("House details"+uploadDetails);
                    mUploadDetails.add(uploadDetails);
                }

                mAdapter = new HouseAdapter(Houselist.this,mUploadDetails);
                mRecyclerView.setAdapter(mAdapter);
                mProgressCircle.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Houselist.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                mProgressCircle.setVisibility(View.INVISIBLE);
            }
        });
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
            startActivity(new Intent(this,LoginActivity.class));
            return true;
        }
        if(id==android.R.id.home)
            onBackPressed();
        return true;

    }
}
