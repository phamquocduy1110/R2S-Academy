package com.example.r2sacademy;

import android.os.Bundle;
import android.os.strictmode.NonSdkApiUsedViolation;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddStudentActivity extends AppCompatActivity {

    private EditText id, fullName, phone, email, gender, address, birthdate;
    private Button btnAdd, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        init();

    }

    public void init() {
        // initializing our views
        id = findViewById(R.id.txtID);
        fullName = findViewById(R.id.txtFullName);
        phone = findViewById(R.id.txtPhone);
        email = findViewById(R.id.txtEmail);
        gender = findViewById(R.id.txtGender);
        address = findViewById(R.id.txtAddress);
        birthdate = findViewById(R.id.txtBirthdate);

        btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // adding on click listener to our button.
        btnAdd = findViewById(R.id.btnAddStudent);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // validating if the text field is empty or not.
                if (id.getText().toString().isEmpty() && fullName.getText().toString().isEmpty() && phone.getText().toString().isEmpty() &&
                email.getText().toString().isEmpty() && gender.getText().toString().isEmpty() && address.getText().toString().isEmpty() && birthdate.getText().toString().isEmpty())
                {
                    Toast.makeText(AddStudentActivity.this, "Please enter all of values", Toast.LENGTH_SHORT).show();
                    return;
                }
                // calling a method to post the data and passing our value
                postData(id.getText().toString(),
                        fullName.getText().toString(),
                        phone.getText().toString(),
                        email.getText().toString(),
                        gender.getText().toString(),
                        address.getText().toString(),
                        birthdate.getText().toString());
            }
        });
    }

    private void postData(String id, String fullName, String phone, String email, String gender, String address, String birthdate) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://615dbb7b12571a0017207864.mockapi.io/api/")
                // as we are sending data in json format so
                // we have to add Gson converter factory
                .addConverterFactory(GsonConverterFactory.create())
                // at last we are building our retrofit builder.
                .build();
        // below line is to create an instance for our retrofit api class.
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        // passing data from our text fields to our modal class.
        ListStudent modal = new ListStudent(id, fullName, phone, email, gender, address, birthdate);

        // calling a method to create a post and passing our modal class.
        Call<ListStudent> call = jsonPlaceHolderApi.createStudent(modal);

        // on below line we are executing our method.
        call.enqueue(new Callback<ListStudent>() {

            @Override
            public void onResponse(Call<ListStudent> call, Response<ListStudent> response) {
                Toast.makeText(AddStudentActivity.this, "Create new student successfully", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ListStudent> call, Throwable t) {
                Toast.makeText(AddStudentActivity.this, "Create failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
