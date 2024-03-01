package com.example.footballleague;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.footballleague.adapters.CompetitionAdapter;
import com.example.footballleague.adapters.RecyclerViewDetails;
import com.example.footballleague.model.Competition;
import com.example.footballleague.viewModels.CompetitionViewModel;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {
    private CompetitionViewModel competitionViewModel;
    private RecyclerViewDetails adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        recyclerView=findViewById(R.id.recyclerViewDetailsID);
        adapter=new RecyclerViewDetails(this);
        recyclerView.setAdapter(adapter);

         ImageView competitionImage,flagAreaImageView;
         TextView competitionText, areaText,planText;

        Intent intent = getIntent();
        String ct = intent.getStringExtra("competitionNameKey");
        String at = intent.getStringExtra("areaNameKey");
        String pt = intent.getStringExtra("planKey");
        String ci = intent.getStringExtra("emblemKey");
        String fi = intent.getStringExtra("flagAreaKey");




        competitionViewModel=new ViewModelProvider(this).get(CompetitionViewModel.class);
        competitionViewModel.getAllCompetitions();

        competitionViewModel.getCompetitionList().observe(this, new Observer<ArrayList<Competition>>() {
            @Override
            public void onChanged(ArrayList<Competition> competitions) {
                //This code is not completely correct
                //There was no time to do it any other way now
                Competition competition=new Competition();
                competition.setName(ct);
                competition.setNameArea(at);
                competition.setPlan(pt);
                competition.setEmblem(ci);
                competition.setFlagArea(fi);

                competitions.set(0,competition);
                adapter.setList(competitions);
                competitionViewModel.insertCompetition(adapter.getCompetitionAt());
            }
        });

    }
    }
