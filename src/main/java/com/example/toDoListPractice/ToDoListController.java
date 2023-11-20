package com.example.toDoListPractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class ToDoListController {

    @Autowired
    private ToDoListService toDoListService;

    @PostMapping("/add")
    public String addTask(@RequestBody String addDescription){
        return toDoListService.addTask(addDescription);
    }

    @PutMapping("/done/{i}/{time}")
    public Task taskCompleted(@PathVariable int i, @PathVariable int time){
        return toDoListService.taskCompleted(i,time);
    }

    @GetMapping("/missingTasks")
    public List<Task> missingTasks() {
        return toDoListService.missingTasksList();
    }

    @GetMapping("/doneTasks")
    public List<Task> doneTasks() {
        return toDoListService.doneTasksList();
    }

    @GetMapping("/all")
    public List<Task> allTasks() {
        return toDoListService.allTasks();
    }

    @DeleteMapping("/delete/{i}")
    public boolean deleteTask(@PathVariable int i){
        return toDoListService.deleteTask(i);
    }

    @PutMapping("/update/{i}")
    public String updateTask(@PathVariable int i, @RequestBody String newDescription){
        return toDoListService.updateTask(i,newDescription);
    }

    @GetMapping("/details/{i}")
    public Task taskDetails(@PathVariable int i){
        return toDoListService.taskDetails(i);
    }
}
