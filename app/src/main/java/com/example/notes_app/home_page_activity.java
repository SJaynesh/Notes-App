package com.example.notes_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.notes_app.adpter.NotesAddAdpter;
import com.example.notes_app.databinding.ActivityHomePageBinding;

import com.example.notes_app.model.NotesModel;

import java.util.ArrayList;
import java.util.List;

public class home_page_activity extends AppCompatActivity {

    ActivityHomePageBinding binding;
    static List<NotesModel> notesModelList = new ArrayList<NotesModel>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnAddNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page_activity.this, NotesAddActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        NotesAddAdpter notesAddAdpter = new NotesAddAdpter(this,notesModelList);
        binding.notesRecycleView.setAdapter(notesAddAdpter);
        super.onResume();
    }
}