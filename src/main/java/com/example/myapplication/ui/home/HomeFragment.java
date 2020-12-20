package com.example.myapplication.ui.home;


import android.content.ClipData;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.CustomGrid;
import com.example.myapplication.DataBaseHandler;
import com.example.myapplication.DataBaseHandler2;
import com.example.myapplication.Items;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.ui.FSDialog;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HomeFragment extends Fragment {


    private HomeViewModel homeViewModel;
    GridView grid;
    List<Items> web;
    int imageId = R.drawable.ic_delivery;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        final DataBaseHandler2 db = new DataBaseHandler2(getContext());
        db.getReadableDatabase();
        web = db.getAllItems();


        CustomGrid adapter = new CustomGrid(getContext(), web, imageId);
        grid= (GridView) root.findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                openDialog();

            }
        });

        return root;
    }

    private void openDialog(){
        FSDialog.display(getParentFragmentManager());
    }
}