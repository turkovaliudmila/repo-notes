package ru.geekbrains.appnotes;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

public class MenuActivity extends AppCompatActivity {
    private ListNotesFragment listNotesFragment;
    private NotesAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_menu);
        initView();
    }

    private void initView() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initDrawer(toolbar);
        listNotesFragment = ListNotesFragment.newInstance();
        adapter = listNotesFragment.getAdapter();
        recyclerView = listNotesFragment.getRecyclerView();
        addFragment(listNotesFragment);
    }

    private void initDrawer(Toolbar toolbar) {
        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.naw_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.settingsSideMenu:
                        showToast("Select settings");
                        return true;
                    case R.id.aboutAppSideMenu:
                        showToast("Select about app");
                        return true;
                }
                return false;
            }
        }
        );
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.addNote:
                //addFragment(EditNoteFragment.newInstance(0, new Note("Name", "", "")));
                DialogFragment dlg = new DialogEditNote();
                dlg.show(getSupportFragmentManager(), "transactionTag");
                return true;
            case R.id.deleteNote:
                showToast("Select delete note");
                return true;
            case R.id.editNote:
                showToast("Select edit note");
                return true;
            case R.id.favorites:
                showToast("Select favorites");
                return true;
            case R.id.aboutApp:
                showToast("Select about app");
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showToast(String text) {
        Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void addFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction();

        fragmentTransaction.replace(R.id.fragment_container2, fragment);
        fragmentTransaction.commit();
    }

    public void onDialogResult(Note note) {
        listNotesFragment.getListNotes().addNoteData(note);
        adapter.notifyItemInserted(listNotesFragment.getListNotes().size()-1);
        recyclerView.scrollToPosition(listNotesFragment.getListNotes().size()-1);
    }
}
