package com.example.footballleague;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.footballleague.adapters.CompetitionAdapter;
import com.example.footballleague.adapters.RecyclerViewInterface;
import com.example.footballleague.model.Competition;
import com.example.footballleague.viewModels.CompetitionViewModel;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {

    private CompetitionViewModel competitionViewModel;
    private CompetitionAdapter adapter;
    private RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerViewID);
        adapter=new CompetitionAdapter(this,this);
        recyclerView.setAdapter(adapter);

        competitionViewModel=new ViewModelProvider(this).get(CompetitionViewModel.class);
        competitionViewModel.getCompetition();

        competitionViewModel.getCompetitionList().observe(this, new Observer<ArrayList<Competition>>() {
            @Override
            public void onChanged(ArrayList<Competition> competitions) {
                adapter.setList(competitions);
                competitionViewModel.insertCompetition(adapter.getCompetitionAt());
            }
        });
    }

    @Override
    public void onItemClick(int position) {
        Intent intent=new Intent(MainActivity.this,DetailsActivity.class);
        // using Parcelable here is better
        String areaName=adapter.getCompetitionAt().getNameArea();
        String flagArea=adapter.getCompetitionAt().getFlagArea();
        String competitionName=adapter.getCompetitionAt().getName();
        String plan=adapter.getCompetitionAt().getPlan();
        String emblem=adapter.getCompetitionAt().getEmblem();

        intent.putExtra("areaNameKey",areaName);
        intent.putExtra("flagAreaKey",flagArea);
        intent.putExtra("competitionNameKey",competitionName);
        intent.putExtra("planKey",plan);
        intent.putExtra("emblemKey",emblem);

        startActivity(intent);
    }
}