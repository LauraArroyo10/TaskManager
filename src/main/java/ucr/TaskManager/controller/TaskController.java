package ucr.TaskManager.controller;

import org.springframework.web.bind.annotation.*;
import ucr.TaskManager.model.Task;

import java.util.ArrayList;

@RestController
@RequestMapping("/Task")
public class TaskController {
    private ArrayList<Task> tasks;

    public TaskController(ArrayList<Task> tasks) {
        this.tasks = new ArrayList<>();
        //data:testers
        this.tasks.add(new Task(1, "Proyecto dibujo ", "Realizar bitacora", "2025-05-31", "DIB0809", true));
        this.tasks.add(new Task(2, "Proyecto Redes ", "Resolver Mapeo", "2025-05-31", "RDS0884", false));
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
    public ArrayList<Task> getCompleteT() {
        ArrayList<Task> completeTasks = new ArrayList<>();
        for (int taskPosition = 0; taskPosition < tasks.size(); taskPosition++) {
            if (tasks.get(taskPosition).isComplete()) {
                completeTasks.add(tasks.get(taskPosition));
            }
        }
        return completeTasks;
    }


    // Get all tasks that still need to be completed
    @GetMapping("/IncompleteT")
    public ArrayList<Task> getIncompleteT() {
        //create a list for the filtered tasks
        ArrayList<Task> incompleteTasks = new ArrayList<>();
        //go through the main array in oreder to see every task state
        for (int taskPosition = 0; taskPosition < tasks.size(); taskPosition++) {
            //if the state that is on view  is not complete then add to the incompleteTasks the tasks that meet the requirement (being false)
           // next line = add  tasks.get tasks position gets a specific task that meets the false state. the if decides, if an specific
            //task is different of isComplete, this means , it is not complete, then it would take the specific task according to its position and add it to the arraylist
            if (!tasks.get(taskPosition).isComplete()) {
                incompleteTasks.add(tasks.get(taskPosition));
            }
        }
        //then return the ones from the get and show the incomplete tasks
        return incompleteTasks;
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
