package com.example.todo2;

public class TodoItem {
    private String text;
    private boolean isDone;

    public TodoItem(String text) {
        this.text = text;
        this.isDone = false; // Default: not done
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
