package com.example.iq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class graph extends AppCompatActivity {
    BarChart barChart;
    BarData barData;
    BarDataSet barDataSet;
    ArrayList barEntries;
    SharedPreferences sharedPreferences;
    int scr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        Bundle data=getIntent().getExtras();
        scr=data.getInt("Score");
        barChart=findViewById(R.id.BarChart);
        getEntries();
        barDataSet=new BarDataSet(barEntries,"");
        barData=new BarData(barDataSet);
        barChart.setData(barData);
        barChart.getAxisLeft().setAxisMaximum(100);
        barChart.getAxisLeft().setAxisMinimum(0);
        barChart.getAxisRight().setAxisMinimum(0);
        barChart.getAxisRight().setAxisMaximum(100);



    }
    private void getEntries(){
        barEntries=new ArrayList<>();
        barEntries.add(new BarEntry(0f,scr));

    }
    }
