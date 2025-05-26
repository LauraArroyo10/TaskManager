package ucr.TaskManager.controller;

import org.springframework.web.bind.annotation.*;
import ucr.TaskManager.model.Task;

import java.util.ArrayList;

import static java.lang.reflect.Array.set;

@RestController
@RequestMapping("/Task")


public class TaskController {
    private ArrayList<Task> tasks;

    public TaskController(ArrayList<Task> tasks) {
        this.tasks = new ArrayList<>();
        //data:testers
        this.tasks.add(new Task(1, "Proyecto dibujo ", "Realizar bitacora", "25-05-2025", "DIB0809", true));
        this.tasks.add(new Task(2, "Proyecto Redes ", "Resolver Mapeo", "25-05-2025", "RDS0884", false));

        this.tasks.add(new Task(3, "Estudiar conceptos relacionados a \n" +
                "Spring Boot  ", "Repasar la clase Controller, las \n" +
                "anotaciones vistas en la clase y hacer \n" +
                "las pruebas con Postman ", "“25-05-2025", "TM3100", false));
    }
    //___________________________________________________________________________________
    // Add a new task
    @PostMapping("/NewTask")
    public String postT(@RequestBody Task t) {
        tasks.add(t);
        return "Se ha añadido con exito tu tarea";
    }
    //___________________________________________________________________________________
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
    //___________________________________________________________________________________
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
    //___________________________________________________________________________________
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

    //___________________________________________________________________________________
    // Get all tasks that still need to be completed
    @GetMapping("/IncompleteT")
    public ArrayList<Task> getIncompleteT() {
        //create a list for the filtered tasks
        ArrayList<Task> incompleteTasks = new ArrayList<>();
        //go through the main array in oreder to see every task state
        for (int taskPosition = 0; taskPosition < tasks.size(); taskPosition++) {
            //if the state that is on view  is not complete then add to the incompleteTasks the tasks that meet the requirement (being false)
           // next line = add  tasks.get tasks position gets a specific task that meets the false state.  (if) decides, if a specific
            //task is different of isComplete, this means , it is not complete, then it would take the specific task according to its position and add it to the arraylist
            if (!tasks.get(taskPosition).isComplete()) {
                incompleteTasks.add(tasks.get(taskPosition));
            }
        }
        //then return the ones from the get and show the incomplete tasks
        return incompleteTasks;
    }

    //___________________________________________________________________________________
    // Update task state
    @PatchMapping("/TaskStateUpd")
    public String upTState(@RequestBody Task task) {
       // every single task from the array
        for (Task t : tasks) {
            //if the task that enters is the same as the task in tasks  then set
        if(task.equals(t)){
            //this line works as a toggle switch, whether it is trueor false it will change according to the state
            t.setComplete(!t.isComplete());
        }
        }
        //this just notifies the option you changed
        if(task.isComplete()) {
            return "Tarea completada ";
        }else{
            return "Tarea por terminar";
        }
    }



    //___________________________________________________________________________________
    // Modify a specific attribute of the task
    @PatchMapping("/TaskAttributeUpd")
    public String modTAttribute(@RequestBody String title) {
        if (!tasks.isEmpty()) {
            for (Task t : tasks) {
                if (t.getTitle().equals(title)) {
                    t.setTitle(title);
                    return "Titulo de tarea modificado";
                }
            }
                    return "No se ha podido modificar el titulo";
                }
        return "No se han podido encontrar tareas";
    }

    //___________________________________________________________________________________




    // Modify all attributes of the task
    @PutMapping("/TaskUpd/{title}")
    public String modTAttributes(@RequestBody Task task) {
        //verify that the task exists
        for (Task t : tasks) {
            if (t.equals(task)) {
                    if (t.getId()== (task.getId())){
                    t.setId(task.getId());
                } else {
                    return "Id de tarea ya existe";
                    }
                    t.setTitle(task.getTitle());
                    t.setDescription(task.getDescription());
                    t.setDueDate(task.getDueDate());
                    t.setCourseCode(task.getCourseCode());
                return "Tarea modificada!!!";
                }
            }
        return "No se pueden modificar tareas que noexisten";
    }


//___________________________________________________________________________________
    // Delete a task by ID
    @DeleteMapping("/DelT/{id}")
    public String delT(@PathVariable int id) {
        for (Task t : tasks) {
            if (id == t.getId()) {
                tasks.remove(t);
                return "Tarea elimianda con exito";
            }
        }
        return "No se ha podido elimianr tu tarea";
    }




}
