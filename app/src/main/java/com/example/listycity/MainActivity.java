package com.example.listycity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;
    Button confirmCity;
    EditText enterCity;
    Button addCity;
    Button removeCity;
    int selectedPosition = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterCity = findViewById(R.id.enterCityName);
        confirmCity = findViewById(R.id.confirmCity);
        addCity = findViewById(R.id.addCity);
        removeCity = findViewById(R.id.removeCity);
        cityList = findViewById(R.id.city_list);

        String []cities = {"Edmonton", "Vancouver"};

        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);


        confirmCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cityName = enterCity.getText().toString();

                if(!cityName.isEmpty()) {
                    dataList.add(cityName);
                    cityAdapter.notifyDataSetChanged();
                    confirmCity.setVisibility(View.GONE);
                    enterCity.setVisibility(View.GONE);

                }

            }
        });

        addCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmCity.setVisibility(View.VISIBLE);
                enterCity.setVisibility(View.VISIBLE);
                enterCity.setHint("Enter a City");
                enterCity.setText("");


            }
        });


        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.getFocusables(position);
                view.setSelected(true);
                selectedPosition = position;
            }

        });

        removeCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedPosition != -1) {
                    dataList.remove(selectedPosition);
                    cityAdapter.notifyDataSetChanged();
                    selectedPosition = -1;
                }
            }
        });
        }




    }
