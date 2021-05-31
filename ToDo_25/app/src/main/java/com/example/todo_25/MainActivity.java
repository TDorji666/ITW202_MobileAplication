package com.example.todo_25;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDB;
    EditText editName, editSurname, editMarks, editTextId;
    Button btnAddData, btnViewAll, btnDelete, btnViewUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDB=new DatabaseHelper(this);

        editName=findViewById(R.id.editText);
        editSurname=findViewById(R.id.editText2);
        editMarks=findViewById(R.id.editText3);
        editTextId=findViewById(R.id.editText2);

        btnAddData=findViewById(R.id.button);
        btnViewAll=findViewById(R.id.button3);
        btnDelete=findViewById(R.id.button4);
        btnViewUpdate=findViewById(R.id.button2);


    }
//    public void AddData(){
//        btnAddData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                boolean isInserted=myDB.insertData(editTextId.getText().toString(),
//                        editName.getText().toString(),
//                        editSurname.getText().toString(),
//                        editMarks.getText().toString());
//                if(isInserted==true)
//                    Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
//                else
//                    Toast.makeText(MainActivity.this, "Data not Inserted",Toast.LENGTH_LONG ).show();
//
//            }
//        });
//    }

    public void AddData(View view) {
        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted=myDB.insertData(editTextId.getText().toString(),
                        editName.getText().toString(),
                        editSurname.getText().toString(),
                        editMarks.getText().toString());
                if(isInserted==true)
                    Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "Data not Inserted",Toast.LENGTH_LONG ).show();

            }
        });
    }
}