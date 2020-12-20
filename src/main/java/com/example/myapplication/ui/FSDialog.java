package com.example.myapplication.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.example.myapplication.DataBaseHandler;
import com.example.myapplication.DataBaseHandler2;
import com.example.myapplication.Items;
import com.example.myapplication.R;
import com.example.myapplication.data.model.User;


public class FSDialog extends DialogFragment {

    public static final String TAG = "example_dialog";

    private Toolbar toolbar;

    public static FSDialog display(FragmentManager fragmentManager) {
        FSDialog exampleDialog = new FSDialog();
        exampleDialog.show(fragmentManager, TAG);
        return exampleDialog;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.AppTheme_FullScreenDialog);


    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.dialog_fragment, container, false);

        toolbar = view.findViewById(R.id.toolbar);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar.setNavigationOnClickListener(v -> dismiss());
        toolbar.setTitle("Item Title");
        toolbar.inflateMenu(R.menu.dialog_menu);

        final EditText editTextTextPersonName = getView().findViewById(R.id.editTextTextPersonName);
        final EditText editTextTextNumber = getView().findViewById(R.id.editTextNumber);
        final EditText notes = getView().findViewById(R.id.editTextTextPersonName2);
        toolbar.setOnMenuItemClickListener(item -> {

            String itemName = editTextTextPersonName.getText().toString();
            int itemCount = Integer.valueOf(editTextTextNumber.getText().toString());
            Items newItem = new Items(1, itemName, itemCount);
            DataBaseHandler2 db = new DataBaseHandler2(getContext());
            db.getWritableDatabase();

            db.addItem(newItem);

            dismiss();
            return true;
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
            dialog.getWindow().setLayout(width, height);
            dialog.getWindow().setWindowAnimations(R.style.AppTheme);
        }
    }
}