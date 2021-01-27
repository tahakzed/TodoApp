package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        taskList=findViewById(R.id.task_list);
        TodoRecyclerViewAdapter adapter=new TodoRecyclerViewAdapter(new String[]{"Task 1 Task 1 Task 1 Task 1 Task 1 Task 1\n" +
                "Task 1 Task 1 Task 1","Task 3  3 Task 3 Task 3" +
                "Task 3 Task 3 Task 3 " ,"Task 4 Task 4 Task 4 Task 4 Task 4 Task 4 "});
        taskList.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));
        taskList.setAdapter(adapter);
    }
}