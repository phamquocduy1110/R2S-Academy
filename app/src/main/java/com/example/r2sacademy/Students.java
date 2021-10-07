package com.example.r2sacademy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Students extends AppCompatActivity {
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_student);

        textViewResult = findViewById(R.id.text_view_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://615dbb7b12571a0017207864.mockapi.io/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<ListStudent>> call = jsonPlaceHolderApi.getListStudent();

        call.enqueue(new Callback<List<ListStudent>>() {
            @Override
            public void onResponse(Call<List<ListStudent>> call, Response<List<ListStudent>> response) {
                if(!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<ListStudent> listStudents = response.body();

                assert listStudents != null;

                for(ListStudent listStudent : listStudents) {
                    String content = "";
                    content += "ID: " + listStudent.getId() + "\n";
                    content += "Full name: " + listStudent.getFullName() + "\n";
                    content += "Phone: " + listStudent.getPhone() + "\n";
                    content += "Email: " + listStudent.getEmail() + "\n";
                    content += "Gender: " + listStudent.getGender() + "\n";
                    content += "Address: " + listStudent.getAddress() + "\n";
                    content += "Birthdate: " + listStudent.getBirthdate() + "\n\n";

                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<ListStudent>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
}