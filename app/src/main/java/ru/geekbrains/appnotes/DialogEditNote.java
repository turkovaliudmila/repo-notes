package ru.geekbrains.appnotes;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogEditNote extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final View contentView = requireActivity().getLayoutInflater().inflate(R.layout.fragment_edit_note, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setTitle(R.string.title_edit_note);
        builder.setView(contentView);
        builder.setCancelable(false);
        builder.setPositiveButton(R.string.button_edit, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText editName = contentView.findViewById(R.id.editNoteName);
                String nameNote = editName.getText().toString();
                EditText editDesc = contentView.findViewById(R.id.editNoteDescription);
                String descNote = editDesc.getText().toString();
                EditText editDate = contentView.findViewById(R.id.editNoteDateCreation);
                String dateNote = editDesc.getText().toString();
                dismiss();
                ((MenuActivity)requireActivity()).onDialogResult(new Note(nameNote, descNote, dateNote));
            }
        });
        return builder.create();

        //return super.onCreateDialog(savedInstanceState);
    }
}
