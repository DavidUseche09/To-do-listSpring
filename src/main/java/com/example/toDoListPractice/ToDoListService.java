package com.example.toDoListPractice;
import com.sun.source.util.TaskEvent;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToDoListService {
    private List<Task> taskList = new ArrayList<>();

    public String addTask(String taskDescription){
        Task task = new Task();
        task.setDescription(taskDescription);
        task.setDone(false);
        task.setTime(0);
        taskList.add(task);
        return task.getDescription();
    }

    public Task taskCompleted(int i, int time){
        Task task = taskList.get(i);
        task.setDone(true);
        task.setTime(time);
        taskList.set(i, task);
        return task;
    }

    public List<Task> missingTasksList() {
        return taskList.stream()
                .filter(t -> !t.isDone())
                .collect(Collectors.toList());
    }

    public List<Task> doneTasksList() {
        return taskList.stream()
                .filter(Task::isDone)
                .collect(Collectors.toList());
    }

    public List<Task> allTasks() {
        return new ArrayList<>(taskList);
    }

    public boolean deleteTask(int i){
        if (i >= 0 && i < taskList.size()) {
            taskList.remove(i);
            return true;
        } else {
            return false;
        }
    }

    public String updateTask(int i, String newDescription) {
        Task task = taskList.get(i);
        task.setDescription(newDescription);
        taskList.set(i, task);
        return task.getDescription();
    }

    public Task taskDetails(int i) {
        return taskList.get(i);
    }
}