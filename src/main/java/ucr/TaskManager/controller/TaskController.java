package ucr.TaskManager.controller;

import org.springframework.web.bind.annotation.*;
import ucr.TaskManager.model.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.reflect.Array.get;

@RestController
@RequestMapping("/Task")
public class TaskController {
    private ArrayList<Task> tasks;

    public TaskController(ArrayList<Task> tasks) {
        this.tasks = new ArrayList<>();
    }

    // Add a new task
    @PostMapping("/NewTask")
    public String postT(@RequestBody Task t) {
        tasks.add(t);
        return "Se ha añadido con exito tu tarea";
    }

//    // Get all tasks
//    @GetMapping("/AllTasks")
//    public List<Task> getAll() {
//        if (!tasks.isEmpty()) {
//            return tasks;
//        }
//        //collections perform operations for arraylists. with this I can return an empty list/length 0
//        //So I can keep working with the type object List that is actually where Arraylists takes its methods
//        return Collections.emptyList();
//    }

    // Get all tasks
    @GetMapping("/AllTasks")
    public ArrayList<Task> getAll() {
        if (!tasks.isEmpty()) {
            return tasks;
        }
        return new ArrayList<>();
    }

    // Get a task by ID
    @GetMapping("/TaskById/{id}")
    public Task getById(@PathVariable int id) {
        //Task t----------> it refers to an individual tasks///tasks-----------> refers to the array
        for (Task t : tasks) {
            if (id == t.getId()) {
                return t;
            }
        }
        return null;
    }

    // Get all completed tasks
    @GetMapping("/CompleteT")
    public String getCompleteT(String state) {
        for(Task t : tasks){
          //  (if t == t.isCompleted()){
                return "";
            }
       // }
        return state;
    }


    // Get all tasks that still need to be completed
    @GetMapping("/IncompleteT")
    public String getIncompleteT() {
        return "";
    }

    // Update task state
    @PatchMapping("/TaskStateUpd")
    public String upTState() {

        return "";
    }

    // Modify a specific attribute of the task
    @PatchMapping("/TaskAttributeUpd")
    public String modTAttribute() {
        return "";
    }

    // Modify all attributes of the task
    @PutMapping("/TaskUpd")
    public String modTAttributes(Task task) {
        //verify that the task exists
       // if()
        return "";
    }

    // Delete a task by ID
    @DeleteMapping("/DelT")
    public String delT(int id) {

        return "Tarea eliminada con exito";
    }

}
