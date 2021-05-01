package com.example.todo_08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private EditText mEditweb ;
    private EditText mEditLoca;
    private EditText mEditshare;
    private Button btnweb;
    private Button btnloca;
    private Button btnshare;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditweb=findViewById(R.id.edit);
        mEditLoca=findViewById(R.id.edit2);
        mEditshare=findViewById(R.id.edit3);
        btnweb=findViewById(R.id.btn);
        btnloca=findViewById(R.id.btn2);
        btnshare=findViewById(R.id.btn3);



    }

    public void website(View view) {


        String webpage=mEditweb.getText().toString();
        Uri uri= Uri.parse(webpage);
        Intent intent=new Intent(Intent.ACTION_VIEW, uri);


        if (intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
        else{
            Log.d("webpage", "ERROR! website not found");
        }



    }

    public void location(View view) {
        String location=mEditLoca.getText().toString();
        Uri uri=Uri.parse("geo:0,0?q=" + location);
        Intent intent=new Intent(Intent.ACTION_VIEW, uri);

        if (intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
        else{
            Log.d("location" ,"ERROR! Location: not found");
        }

    }

    public void share(View view) {
        String share=mEditshare.getText().toString();
        Intent intent=new Intent(Intent.ACTION_SEND);
        String mimeType="text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with: ")
                .setText(share)
                .startChooser();



    }


}