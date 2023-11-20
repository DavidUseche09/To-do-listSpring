package com.example.toDoListPractice;

public class Task {
    private String description;
    private boolean done;
    private int time;

    public Task(){};

    public Task(String description, boolean done, int time) {
        this.description = description;
        this.done = done;
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
