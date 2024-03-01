package com.example.footballleague.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.footballleague.R;
import com.example.footballleague.model.Competition;

import java.util.ArrayList;

public class CompetitionAdapter extends RecyclerView.Adapter<CompetitionAdapter.CompetitionViewHolder> {
    private ArrayList<Competition> CompetitionArrayList = new ArrayList<>();

    private final RecyclerViewInterface recyclerViewInterface;
    private Context context;
    static int  position;

    public CompetitionAdapter(RecyclerViewInterface recyclerViewInterface, Context context) {
        this.recyclerViewInterface = recyclerViewInterface;
        this.context = context;
    }

    public void setList(ArrayList<Competition> CompetitionArrayList) {
        this.CompetitionArrayList = CompetitionArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CompetitionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CompetitionViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.competition_item,parent,false),recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull CompetitionViewHolder holder, int position) {

        holder.competitionText.setText(CompetitionArrayList.get(position).getName());
        holder.areaText.setText(CompetitionArrayList.get(position).getNameArea());

        if(CompetitionArrayList.get(position).getEmblem().equals(null)){
            //if any competition has no emblem
                holder.competitionImage.setImageResource(R.mipmap.ball);
        }else {
            Glide.with(context).load(CompetitionArrayList.get(position).getEmblem())
                    .into(holder.competitionImage);

        }

    }
    public  Competition getCompetitionAt(){
        return CompetitionArrayList.get(position);
    }

    @Override
    public int getItemCount() {
        return CompetitionArrayList.size();
    }

    public static class CompetitionViewHolder extends RecyclerView.ViewHolder  {
        private ImageButton competitionImage;
        private TextView competitionText, areaText;
        public CompetitionViewHolder(@NonNull View itemView,RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            competitionImage=itemView.findViewById(R.id.competition_imageView);
            competitionText=itemView.findViewById(R.id.competitionName_TextView);
            areaText=itemView.findViewById(R.id.areaName_TextView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerViewInterface !=null){

                         position=getAbsoluteAdapterPosition();

                        if(position!=RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(position);
                        }
                    }
                }
            });
        }

    }
}
