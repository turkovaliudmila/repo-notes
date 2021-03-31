package ru.geekbrains.appnotes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class EditNoteFragment extends Fragment {
    public static final String ARG_INDEX = "index";
    public static final String ARG_NAME = "name";
    public static final String ARG_DESC = "description";
    public static final String ARG_DATE_CREATION = "date_creation";
    private int index;
    private Note note;

    public EditNoteFragment() {
    }

    public static EditNoteFragment newInstance(int index, Note note) {
        EditNoteFragment fragment = new EditNoteFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_INDEX, index);
        args.putString(ARG_NAME, note.getName());
        args.putString(ARG_DESC, note.getDescription());
        args.putString(ARG_DATE_CREATION, note.getDateCreation());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_INDEX);
            String noteName = getArguments().getString(ARG_NAME);
            String noteDescription = getArguments().getString(ARG_DESC);
            String noteDate = getArguments().getString(ARG_DATE_CREATION);
            note = new Note(noteName, noteDescription, noteDate);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_note, container, false);

        EditText editName = view.findViewById(R.id.editNoteName);
        EditText editDesc = view.findViewById(R.id.editNoteDescription);
        EditText editDate = view.findViewById(R.id.editNoteDateCreation);

        editName.setText(note.getName());
        editDesc.setText(note.getDescription());
        editDate.setText(note.getDateCreation());

        return view;
    }
}
