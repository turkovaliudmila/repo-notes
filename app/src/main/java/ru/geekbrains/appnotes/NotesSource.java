package ru.geekbrains.appnotes;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

public class NotesSource {
    private List<Note> dataSource;
    private Resources resources;
    public static final int SIZE_ARRAY = 3;

    public NotesSource(Resources resources) {
        dataSource = new ArrayList<>(SIZE_ARRAY);
        this.resources = resources;
    }

    public NotesSource init() {
        String[] names = resources.getStringArray(R.array.notename);
        String[] descriptions = resources.getStringArray(R.array.notedescription);
        String[] dates = resources.getStringArray(R.array.notedate);
        for (int i = 0; i < SIZE_ARRAY; i++) {
            dataSource.add(new Note(names[i], descriptions[i], dates[i]));
        }
        return this;
    }

    public Note getNote(int position) {
        return dataSource.get(position);
    }

    public int size() {
        return SIZE_ARRAY;
    }

    public void deleteNoteData(int position) {
        dataSource.remove(position);
    }

    public void addNoteData(Note note) {
        dataSource.add(note);
    }
}
