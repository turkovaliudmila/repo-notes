package ru.geekbrains.appnotes;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NotesFragment extends Fragment {
    private boolean isLandscape;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initList(view);
    }

    private void initList(View view) {
        LinearLayout layoutView = (LinearLayout)view;
        String[] notes = getResources().getStringArray(R.array.notename);

        for (int i = 0; i < notes.length; i++) {
            String nameNote = notes[i];
            TextView tv = new TextView(getContext());
            tv.setText(nameNote);
            tv.setTextSize(30);
            layoutView.addView(tv);
            final int fi = i;
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDetailsNote(fi);
                }
            });
        }
     }

     private void showDetailsNote(int index) {
         if (isLandscape) {
             showLandscapeDetails(index);
         } else {
             showPortraitDetails(index);
         }
     }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        isLandscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        if (isLandscape) {
            showLandscapeDetails(0);
        }
    }

    private void showLandscapeDetails(int index) {
        DetailsNoteFragment detailsFragment = DetailsNoteFragment.newInstance(index);

        FragmentTransaction fragmentTransaction = requireActivity().getSupportFragmentManager()
                .beginTransaction();

        // добавляем фрагмент
        DetailsNoteFragment fragment= new DetailsNoteFragment();
        fragmentTransaction.add(R.id.details_container, detailsFragment);
        fragmentTransaction.commit();
    }

    private void showPortraitDetails(int index) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), DetailsActivity.class);
        intent.putExtra(DetailsNoteFragment.ARG_INDEX, index);
        startActivity(intent);
    }

}