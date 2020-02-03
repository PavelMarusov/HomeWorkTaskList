package com.example.homeworktasklist;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class EditTextFragment extends Fragment {
    ArrayList <Task> tasks = new ArrayList<>();
    RecylerFragment recylerFragment = new RecylerFragment();
     IEditTextFr editTextFr;

     public static EditTextFragment editTextFragment(IEditTextFr iEditTextFr){
         EditTextFragment editTextFragment = new EditTextFragment();
         editTextFragment.editTextFr = iEditTextFr;
         return editTextFragment;
     }

    public EditTextFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_text, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final TextView title = view.findViewById(R.id.title_Edit);
        final TextView description = view.findViewById(R.id.deadLine_Edit);
        final TextView deadLine = view.findViewById(R.id.deadLine_Edit);
        Button saveBtn = view.findViewById(R.id.FT_button_save);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Task task = new Task();
                if (title.getText().toString().trim().equals("")){
                    massege("Нет темы");
                    return;
                }
                else{task.title = title.getText().toString().trim();}
                if (description.getText().toString().trim().equals("")){
                    massege("Нет описания");
                    return;
                }
                else {
                    task.description = description.getText().toString().trim();
                }
                if(deadLine.getText().toString().trim().equals("")){
                    massege("Нет deadline");
                    return;
                }
                else {
                    task.deadLine = deadLine.getText().toString().trim();
                }
                editTextFr.getIfo(task);
            }
        });

    }
    public void massege(String s){
        Toast.makeText( getActivity(),s,Toast.LENGTH_SHORT).show();
    }




}
