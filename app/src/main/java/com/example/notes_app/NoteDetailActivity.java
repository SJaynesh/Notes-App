package com.example.notes_app;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import com.example.notes_app.databinding.ActivityNoteDetailBinding;
import android.os.Bundle;
import android.view.View;


public class NoteDetailActivity extends AppCompatActivity {

    ActivityNoteDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNoteDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String title = getIntent().getStringExtra("title");
        String content = getIntent().getStringExtra("content");
        int colorCode = getIntent().getIntExtra("colorCode", Color.GRAY);

        binding.detailTitle.setText(title);
        binding.detailContent.setText(content);
        binding.detailNote.setBackgroundColor(colorCode);
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}