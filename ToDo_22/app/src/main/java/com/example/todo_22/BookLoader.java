package com.example.todo_22;

import android.content.AsyncTaskLoader;
import android.content.Context;

import androidx.annotation.NonNull;

public class BookLoader extends AsyncTaskLoader<String> {
    private String mQueryString;

    public BookLoader(Context context, String QueryString) {
        super(context);
        mQueryString=QueryString;
    }

//    public BookLoader(@NonNull Context context, String QueryString){
//        super(context);
//        mQueryString=QueryString;
//    }


    @NonNull
    @Override
    public String loadInBackground() {
        return NetworkUtils.getBookInfo(mQueryString);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}
