package com.example.footballleague.adapters;

import static com.example.footballleague.adapters.CompetitionAdapter.position;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.footballleague.R;
import com.example.footballleague.model.Competition;

import java.util.ArrayList;

public class RecyclerViewDetails extends RecyclerView.Adapter<RecyclerViewDetails.RecyclerViewDetailsViewHolder> {
    private ArrayList<Competition> CompetitionArrayList = new ArrayList<>();
    private Context context;

    public RecyclerViewDetails(Context context) {
        this.context = context;
    }

    public void setList(ArrayList<Competition> CompetitionArrayList) {
        this.CompetitionArrayList = CompetitionArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerViewDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }
    public  Competition getCompetitionAt(){
        return CompetitionArrayList.get(position);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerViewDetailsViewHolder holder, int position) {

        holder.competitionText.setText(CompetitionArrayList.get(position).getName());
        holder.areaText.setText(CompetitionArrayList.get(position).getNameArea());
        holder.planText.setText(CompetitionArrayList.get(position).getPlan());

        if(CompetitionArrayList.get(position).getEmblem().equals(null)){
            //if any competition has no emblem
            holder.competitionImage.setImageResource(R.mipmap.ball);
        }else {
            Glide.with(context).load(CompetitionArrayList.get(position).getEmblem())
                    .into(holder.competitionImage);

        }
        if(CompetitionArrayList.get(position).getFlagArea().equals(null)){
            //if any competition has no flag
            holder.competitionImage.setImageResource(R.mipmap.ball);
        }else {
            Glide.with(context).load(CompetitionArrayList.get(position).getEmblem())
                    .into(holder.flagAreaImageView);

        }
    }

    @Override
    public int getItemCount() {
        return CompetitionArrayList.size();
    }

    public class RecyclerViewDetailsViewHolder extends RecyclerView.ViewHolder {

        private ImageView competitionImage,flagAreaImageView;
        private TextView competitionText, areaText,planText;
        public RecyclerViewDetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            competitionImage=itemView.findViewById(R.id.competitionImage_imageView);
            flagAreaImageView=itemView.findViewById(R.id.flagArea_imageView);
            competitionText=itemView.findViewById(R.id.competitionName1_TextView);
            areaText=itemView.findViewById(R.id.areaName1_TextView);
            planText=itemView.findViewById(R.id.plan_TextView);
        }
    }


}
