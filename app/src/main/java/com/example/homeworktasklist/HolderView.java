package com.example.homeworktasklist;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HolderView extends RecyclerView.ViewHolder {
    TextView titleText;
    TextView description;
    TextView deadlineText;
    public HolderView(@NonNull View itemView) {
        super(itemView);
         titleText = itemView.findViewById(R.id.HF_title);
         description = itemView.findViewById(R.id.HF_description);
         deadlineText = itemView.findViewById(R.id.HF_deadLine);

    }

    public  void  setText(Task task){
        titleText.setText(task.title);
        description.setText(task.description);
        deadlineText.setText(task.deadLine);
    }
}
