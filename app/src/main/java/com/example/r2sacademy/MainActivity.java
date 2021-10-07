package com.example.r2sacademy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ImageView calculate, addStudent, liststudent, banking;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Go to account information page
        calculate = (ImageView)findViewById(R.id.Calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalculateActivity.class);
                Logger.getLogger("Test").warning("Move to Profile ");
                startActivity(intent);
            }
        });

        addStudent = (ImageView)findViewById(R.id.AddStudent);
        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddStudentActivity.class);
                Logger.getLogger("Test").warning("Move to Add Contact ");
                startActivity(intent);
            }
        });

        liststudent = (ImageView)findViewById(R.id.ListStudent);
        liststudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Students.class);
                Logger.getLogger("Test").warning("Move to Add Contact ");
                startActivity(intent);
            }
        });

        /*banking = (ImageView)findViewById(R.id.btnBanking);
        banking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, NotificationDialog.class);
                Logger.getLogger("Test").warning("Move to Add Contact ");
                startActivity(intent);
            }
        });*/
    }
}