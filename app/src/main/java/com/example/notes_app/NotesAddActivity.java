package com.example.notes_app;

import static com.example.notes_app.home_page_activity.notesModelList;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.notes_app.databinding.ActivityNotesAddBinding;
import com.example.notes_app.model.NotesModel;

public class NotesAddActivity extends AppCompatActivity {

    ActivityNotesAddBinding binding;
    boolean allCheckedField = false;
    int colorCode = Color.GRAY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNotesAddBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("TAG","Back onClick");
                finish();
            }
        });

        binding.color1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colorCode = Color.BLUE;
                Log.e("ERROR","COLOR CODE : "+colorCode);
            }
        });
        binding.color2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colorCode = Color.RED;
            }
        });

        binding.color3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colorCode = Color.CYAN;
            }
        });

        binding.color4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colorCode = Color.YELLOW;
            }
        });

        binding.notesDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allCheckedField = checkAllTextField();
               if (allCheckedField) {
                   String title = binding.titleId.getText().toString();
                   String content = binding.contentId.getText().toString();


                   NotesModel model = new NotesModel(title,content,colorCode);
                   notesModelList.add(model);
                   Log.i("TAG","onClick"+notesModelList.get(0).title);
                   finish();
               }
            }
        });
    }
    private  boolean checkAllTextField() {
        if (binding.titleId.length()==0) {
            binding.titleId.setError("This field is required");
            return  false;
        }
        if(binding.contentId.length()==0) {
            binding.contentId.setError("This field is required");
            return  false;
        }
        return  true;
    }
}