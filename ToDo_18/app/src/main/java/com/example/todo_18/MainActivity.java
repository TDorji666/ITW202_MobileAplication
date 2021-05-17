package com.example.todo_18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<Sports> mSportsData;
    private SportsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize recyclerview
        mRecyclerView=(RecyclerView)findViewById(R.id.recycleview);

        //set the layout manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initialize the arraylist that will contain the data
        mSportsData=new ArrayList<>();
        mAdapter=new SportsAdapter(this, mSportsData);
        mRecyclerView.setAdapter(mAdapter);

        //setData
        InitializeData();

    }
    private void InitializeData(){
        String[] sportsList=getResources().getStringArray(R.array.Sports_Title);
        String[] sportsInfo=getResources().getStringArray(R.array.Sports_info);
        TypedArray sportsImage=getResources().obtainTypedArray(R.array.sport_images);
        sportsImage.recycle();

        mSportsData.clear();

        for (int i=0; i<sportsList.length; i++){
            mSportsData.add(new Sports(sportsList[i], sportsInfo[i], sportsImage.getResourceId(i, 0)));
        }
        mAdapter.notifyDataSetChanged();
        sportsImage.recycle();
    }
}