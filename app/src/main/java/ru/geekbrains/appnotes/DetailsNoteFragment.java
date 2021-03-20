package ru.geekbrains.appnotes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DetailsNoteFragment extends Fragment {

    public static final String ARG_INDEX = "index";
    private int index;

    public DetailsNoteFragment() {
    }

    public static DetailsNoteFragment newInstance(int index) {
        DetailsNoteFragment fragment = new DetailsNoteFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_INDEX, index);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_INDEX);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details_note, container, false);

        TextView textName = view.findViewById(R.id.note_name);
        TextView textDesc = view.findViewById(R.id.note_description);
        TextView textDate = view.findViewById(R.id.note_date_creation);

        String[] names = getResources().getStringArray(R.array.notename);
        String[] descriptions = getResources().getStringArray(R.array.notedescription);
        String[] dates = getResources().getStringArray(R.array.notedate);

        textName.setText(names[index]);
        textDesc.setText(descriptions[index]);
        textDate.setText(dates[index]);

        return view;
    }
}