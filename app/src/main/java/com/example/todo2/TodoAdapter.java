package com.example.todo2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ArrayAdapter;

import java.util.List;

public class TodoAdapter extends ArrayAdapter<TodoItem> {
    private Context context;
    private List<TodoItem> todoList;

    public TodoAdapter(Context context, List<TodoItem> todoList) {
        super(context, 0, todoList);
        this.context = context;
        this.todoList = todoList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the current Todo item
        TodoItem todoItem = getItem(position);

        // If no recycled view, inflate a new one
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.todo_item, parent, false);
        }

        // Find views in the row layout
        TextView todoText = convertView.findViewById(R.id.todoText);
        CheckBox doneCheckBox = convertView.findViewById(R.id.doneCheckBox);
        Button deleteButton = convertView.findViewById(R.id.deleteButton);

        // Set text and checkbox state
        todoText.setText(todoItem.getText());
        doneCheckBox.setChecked(todoItem.isDone());

        // Handle done checkbox state change
        doneCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            todoItem.setDone(isChecked);
            Toast.makeText(context, "Marked as done", Toast.LENGTH_SHORT).show();
        });

        // Handle delete button click
        deleteButton.setOnClickListener(v -> {
            todoList.remove(position);
            notifyDataSetChanged(); // Refresh the list
            Toast.makeText(context, "Todo deleted", Toast.LENGTH_SHORT).show();
        });

        return convertView;
    }
}
