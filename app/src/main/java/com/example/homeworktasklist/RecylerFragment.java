package com.example.homeworktasklist;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecylerFragment extends Fragment {
    RecyclerView recyclerView;
    AdapterView adapter;
    ArrayList<Task> tasks = new ArrayList<>();

    IRecyclerFragment iRecyclerFragment;

    public static RecylerFragment editRecyclerFr(IRecyclerFragment iRecyclerFragment) {
        RecylerFragment recylerFragment = new RecylerFragment();
        recylerFragment.iRecyclerFragment = iRecyclerFragment;
        return recylerFragment;
    }

    public RecylerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recyler, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler);
        adapter = new AdapterView(tasks);
        recyclerView.setAdapter(adapter);
        Button buttonAdd = view.findViewById(R.id.FR_btn_back);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iRecyclerFragment.goToBack();
            }
        });
        Bundle bundle = getArguments();
        if (bundle != null) {
            tasks.add((Task) bundle.getSerializable("task"));
            adapter.notifyDataSetChanged();
        }


    }

}
