package com.example.notes_app.model;

public class NotesModel {
    public  String title,content;
    public int colorCode;

    public NotesModel(String title,String content, int colorCode) {
        this.title = title;
        this.content = content;
        this.colorCode = colorCode;
    }
}
