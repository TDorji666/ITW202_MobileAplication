package com.example.todo_16;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecycle;
    private WordListAdapter mAdapter;
    private LinkedList <String> mWordList=new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecycle=findViewById(R.id.recyclerview);
        mAdapter=new WordListAdapter(this, mWordList);
        mRecycle.setAdapter(mAdapter);
        mRecycle.setLayoutManager(new LinearLayoutManager(this));



    }

    public void view(View view) {
        int wordListSize = mWordList.size();
        // Add a new word to the wordList.
        mWordList.addLast("+ Word " + wordListSize);
        // Notify the adapter, that the data has changed.
        mRecycle.getAdapter().notifyItemInserted(wordListSize);
        // Scroll to the bottom.
        mRecycle.smoothScrollToPosition(wordListSize);
    }
}