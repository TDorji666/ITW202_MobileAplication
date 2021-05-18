package com.example.todo_18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

import com.gcit.todo_18.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclearView;
    private ArrayList<Sport> mSportData;
    private SportAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclearView = findViewById(R.id.recycleview);

        //set the layout manager
        int gridColumnCount=getResources().getInteger(R.integer.grid_column_count);
        mRecyclearView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));

        //Initialize the Arraylist that will contain the data
        mSportData = new ArrayList<>();
        //Initialize the adapter and set it to the RecyclearView
        mAdapter = new SportAdapter(this, mSportData);
        mRecyclearView.setAdapter(mAdapter);

        //get the  data
        initializeData();
    }

    private void initializeData() {
        //get the resources form XMl file
        TypedArray sportsImageResources = getResources().obtainTypedArray(R.array.sports_images);
        String[] sportsList = getResources().getStringArray(R.array.Sports_titles);
        String[] sportsInfo = getResources().getStringArray(R.array.Sports_info);

        //clear the existing data(to avoid duplication)
        mSportData.clear();


        //create the ArrayList of Sports Object with the titles and info
        for (int i=0;i<sportsList.length;i++){
            mSportData.add(new Sport(sportsList[i], sportsInfo[i], sportsImageResources.getResourceId(i,0)));
        }
        //Notify the adapter of the change
        mAdapter.notifyDataSetChanged();
        sportsImageResources.recycle();
    }
}