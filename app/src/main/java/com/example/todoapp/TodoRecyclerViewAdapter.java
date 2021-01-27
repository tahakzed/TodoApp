package com.example.todoapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class TodoRecyclerViewAdapter extends RecyclerView.Adapter<TodoRecyclerViewAdapter.ViewHolder> {
    private String[] taskList;
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView taskTv;
        public ViewHolder(View view){
            super(view);
            taskTv=view.findViewById(R.id.task_tv);
        }
        public TextView getTaskTv(){
            return taskTv;
        }
    }

    public TodoRecyclerViewAdapter(String[] taskList){
        this.taskList=taskList;
    }
    @NonNull
    @Override
    public TodoRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.getTaskTv().setText(taskList[position]);
    }

    @Override
    public int getItemCount() {
        return taskList.length;
    }
}
