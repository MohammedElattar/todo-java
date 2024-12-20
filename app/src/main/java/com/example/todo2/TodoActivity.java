package com.example.todo2;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class TodoActivity extends AppCompatActivity {

    private EditText todoEditText;
    private ListView todoListView;
    private List<TodoItem> todoList;
    private TodoAdapter todoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        todoEditText = findViewById(R.id.todoEditText);
        todoListView = findViewById(R.id.todoListView);

        // Initialize the todo list and adapter
        todoList = new ArrayList<>();
        todoAdapter = new TodoAdapter(this, todoList);
        todoListView.setAdapter(todoAdapter);
    }

    // Method to add a new todo item
    public void addTodo(View view) {
        String todoText = todoEditText.getText().toString();

        if (!todoText.isEmpty()) {
            TodoItem newTodo = new TodoItem(todoText);
            todoList.add(newTodo);
            todoAdapter.notifyDataSetChanged(); // Refresh the list
            todoEditText.setText(""); // Clear the input field
            Toast.makeText(this, "Todo added", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Please enter a todo", Toast.LENGTH_SHORT).show();
        }
    }
}
