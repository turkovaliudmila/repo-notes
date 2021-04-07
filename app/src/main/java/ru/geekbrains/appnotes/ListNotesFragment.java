package ru.geekbrains.appnotes;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.ContextMenu;

public class ListNotesFragment extends Fragment {

    private NotesSource data;
    private NotesAdapter adapter;
    private RecyclerView recyclerView;

    public static ListNotesFragment newInstance() {
        return new ListNotesFragment();
    }

    public static ListNotesFragment newInstance(Note note) {
        return new ListNotesFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_notes, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_lines);
        data = new NotesSource(getResources()).init();
        initRecyclerView(recyclerView, data);
        return view;
    }

    private void initRecyclerView(RecyclerView recyclerView, NotesSource data) {
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new NotesAdapter(data, this);
        recyclerView.setAdapter(adapter);


    }
    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = requireActivity().getMenuInflater();
        inflater.inflate(R.menu.note_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_update:
                // Do some stuff
                return true;
            case R.id.action_delete:
                int position = adapter.getMenuPosition();
                AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
                builder.setTitle(R.string.title_delete_note);
                builder.setMessage(R.string.question_delete_note);
                builder.setCancelable(false);
                builder.setPositiveButton(R.string.button_yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        data.deleteNoteData(position);
                        adapter.notifyItemRemoved(position);
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
                return true;
        }
        return super.onContextItemSelected(item);
    }

}
