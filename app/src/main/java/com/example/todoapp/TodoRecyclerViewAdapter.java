package com.example.todoapp;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Map;

public class TodoRecyclerViewAdapter extends RecyclerView.Adapter<TodoRecyclerViewAdapter.ViewHolder> {
    private Map<String,String> tasks;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView taskTv;
        private final TextView taskTitle;
        private final CardView cardView;
        private final View underline;
        public ViewHolder(View view){
            super(view);
            taskTv=view.findViewById(R.id.task_tv);
            taskTitle=view.findViewById(R.id.task_title);
            cardView=view.findViewById(R.id.cardViewTask);
            underline=view.findViewById(R.id.underline);
        }
        public TextView getTaskTv(){
            return taskTv;
        }
        public TextView getTaskTitle(){return  taskTitle;}
        public CardView getCardView(){return cardView;}
        public View getUnderline(){return underline;}
    }

    public TodoRecyclerViewAdapter(Map<String,String> tasks){
        this.tasks=tasks;
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
        String temp=tasks.keySet().toArray()[position].toString();
        String taskType=temp.substring(temp.indexOf("[")+1,temp.length()-1);
        String key=temp.substring(0,temp.indexOf("["));
        TextView title=holder.getTaskTitle();
        TextView task=holder.getTaskTv();
        CardView card= holder.getCardView();
        View ul=holder.getUnderline();
        if(taskType.equals("important"))
        {
            card.setCardBackgroundColor(card.getContext().getResources().getColor(R.color.important));
            title.setTextColor(title.getContext().getResources().getColor(R.color.important_text));
            ul.setBackgroundColor(ul.getContext().getResources().getColor(R.color.important_text));
            task.setTextColor(task.getContext().getResources().getColor(R.color.important_text));
        }
        else if(taskType.equals("sw_important"))
        {
            card.setCardBackgroundColor(card.getContext().getResources().getColor(R.color.sw_important));
            title.setTextColor(title.getContext().getResources().getColor(R.color.sw_important_text));
            ul.setBackgroundColor(ul.getContext().getResources().getColor(R.color.sw_important_text));
            task.setTextColor(task.getContext().getResources().getColor(R.color.sw_important_text));
        }
        else if(taskType.equals("filler"))
        {
            card.setCardBackgroundColor(card.getContext().getResources().getColor(R.color.filler));
            title.setTextColor(title.getContext().getResources().getColor(R.color.filler_text));
            ul.setBackgroundColor(ul.getContext().getResources().getColor(R.color.filler_text));
            task.setTextColor(task.getContext().getResources().getColor(R.color.filler_text));
        }

        title.setText(key);
        task.setText(tasks.get(temp));

    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }
}
