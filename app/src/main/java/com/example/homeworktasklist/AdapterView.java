package com.example.homeworktasklist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterView extends RecyclerView.Adapter<HolderView> {
    ArrayList<Task> tasks;

    public AdapterView(ArrayList<Task>task){
        this.tasks=task;
    }

    @NonNull
    @Override
    public HolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.hholder_view,parent,false);
        return new HolderView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderView holder, int position) {
        holder.setText(tasks.get(position));

    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }
}
