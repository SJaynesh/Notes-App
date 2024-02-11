package com.example.notes_app.adpter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notes_app.NoteDetailActivity;
import com.example.notes_app.R;
import com.example.notes_app.model.NotesModel;

import java.util.ArrayList;
import java.util.List;

public class NotesAddAdpter extends RecyclerView.Adapter<NotesAddAdpter.DataViewHolder>{

    Activity activity;
    List<NotesModel> notesModelList = new ArrayList<>();
    public NotesAddAdpter(Activity activity,List<NotesModel> notesModelList)
    {
        this.activity = activity;
        this.notesModelList = notesModelList;
    }
    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.activity_notes_tile,parent,false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        holder.tileTitle.setText(notesModelList.get(position).title);
        holder.tileContent.setText(notesModelList.get(position).content);
        holder.tileLinear.setBackgroundColor(notesModelList.get(position).colorCode);

        holder.tileLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, NoteDetailActivity.class);
                intent.putExtra("title",notesModelList.get(position).title);
                intent.putExtra("content",notesModelList.get(position).content);
                intent.putExtra("colorCode",notesModelList.get(position).colorCode);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return notesModelList.size();
    }
    class DataViewHolder extends  RecyclerView.ViewHolder
    {
        LinearLayout tileLinear;
        TextView tileTitle, tileContent;
        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            tileLinear = itemView.findViewById(R.id.tileLinear);
            tileTitle = itemView.findViewById(R.id.tileTitle);
            tileContent = itemView.findViewById(R.id.tileContent);
        }
    }
}
