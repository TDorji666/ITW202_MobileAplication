package com.example.todo_18;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.concurrent.RecursiveAction;

public class SportsAdapter extends RecyclerView.Adapter <SportsAdapter.ViewHolder> {
    private ArrayList<Sports> mSportsData;
    private Context mContext;
    private ImageView mSportsImage;
    SportsAdapter(Context context, ArrayList<Sports> SportsData){
        this.mSportsData=SportsData;
        this.mContext=context;
    }
    @NonNull
    @Override
    public SportsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.listitem, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull SportsAdapter.ViewHolder holder, int position) {
        Sports currentSport=mSportsData.get(position);
        holder.bindTo(currentSport);

    }

    @Override
    public int getItemCount() {
        return mSportsData.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView mTitle;
        private TextView mInfo;

        ViewHolder(View itemView){
            super(itemView);
            mTitle=itemView.findViewById(R.id.title);
            mInfo= itemView.findViewById(R.id.subtitle);
            mSportsImage=itemView.findViewById(R.id.sportImage);
        }
        void bindTo(Sports currentSport){
            //populate textview with data
            mTitle.setText(currentSport.getTitle());
            mInfo.setText(currentSport.getInfo());
            Glide.with(mContext).load(currentSport.getImageResource()).into(mSportsImage);
        }
    }
}
