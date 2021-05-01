package com.example.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void donut(View view) {
        Toast.makeText(this, "You ordered Donut", Toast.LENGTH_SHORT).show();
    }

    public void froyo(View view) {
        Toast.makeText(this, "You ordered Froyo", Toast.LENGTH_SHORT).show();
    }

    public void Icecream(View view) {
        Toast.makeText(this, "You ordered Ice Cream", Toast.LENGTH_SHORT).show();
    }

    public void dial(View view) {
        Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:77281325"));
        startActivity(intent);
    }
}