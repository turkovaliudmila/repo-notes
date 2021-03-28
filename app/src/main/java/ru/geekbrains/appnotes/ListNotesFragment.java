package ru.geekbrains.appnotes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListNotesFragment extends Fragment {

    public static ListNotesFragment newInstance() {
        return new ListNotesFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_notes, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_lines);
        NotesSource data = new NotesSource(getResources()).init();
        initRecyclerView(recyclerView, data);
        return view;
    }

    private void initRecyclerView(RecyclerView recyclerView, NotesSource data) {
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        final NotesAdapter adapter = new NotesAdapter(data);
        recyclerView.setAdapter(adapter);


    }
}
