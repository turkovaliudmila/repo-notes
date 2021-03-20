package ru.geekbrains.appnotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;

import static android.text.TextUtils.replace;


public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }

        if (savedInstanceState == null) {
            DetailsNoteFragment detailsFragment = new DetailsNoteFragment();
            detailsFragment.setArguments(getIntent().getExtras());

            FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                    .beginTransaction();

            // добавляем фрагмент
            DetailsNoteFragment fragment= new DetailsNoteFragment();
            fragmentTransaction.replace(R.id.fragment_container, detailsFragment);
            fragmentTransaction.commit();
        }
    }
}