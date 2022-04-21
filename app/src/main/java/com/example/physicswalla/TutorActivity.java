package com.example.physicswalla;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class TutorActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView tutorname,tutorsubject,tutorqualification;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor);


        imageView=findViewById(R.id.tutorimage);
        tutorname=findViewById(R.id.tutorname);
        tutorsubject=findViewById(R.id.tutorsubject);
        tutorqualification=findViewById(R.id.tutorqualification);


        //this is used to show the back botton into the appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        Intent intent=getIntent();
        String name=intent.getStringExtra("tutorname");
        String subject=intent.getStringExtra("tutorsubject");
        String qualification=intent.getStringExtra("tutorqualification");
        String image=intent.getStringExtra("tutorimage");

        tutorname.setText(name);
        tutorsubject.setText(subject);
        tutorqualification.setText(qualification);
        Picasso.get().load(image).into(imageView);
    }

    //this method is used for functionality for backbotton
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}