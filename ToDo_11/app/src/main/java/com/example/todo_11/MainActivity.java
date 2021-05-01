package com.example.todo_11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView mHello;
    private String[] mColor = {"red", "pink", "purple", "deep_purple",
            "indigo", "blue", "light_blue", "cyan", "teal", "green",
            "light_green", "lime", "yellow", "amber", "orange", "deep_orange",
            "brown", "grey", "blue_grey", "black" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHello= findViewById(R.id.tview);
        if (savedInstanceState !=null){
            mHello.setTextColor(savedInstanceState.getInt("color"));
        }
    }
    @Override
    public void onSaveInstanceState (Bundle outState) {

        super.onSaveInstanceState(outState);
        outState.putInt("color", mHello.getCurrentTextColor());
    }

    public void change(View view) {
        Random random=new Random();
        String colorName=mColor[random.nextInt(8)];
        int colorResourceName=getResources().getIdentifier(colorName, "color", getApplicationContext().getPackageName());

        int colorRes= ContextCompat.getColor(this, colorResourceName);
        mHello.setTextColor(colorRes);

    }
}