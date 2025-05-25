package ucr.TaskManager.model;

public class Task {
    //variables for task
    private int id;
    private String title;
    private String description;
    private String dueDate;
    private String courseCode;
    private boolean isCompleted;

    //empty constructor
    public Task() {
    }

    //constructor
    public Task(int id, String title, String description, String dueDate, String courseCode, boolean isCompleted) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.courseCode = courseCode;
        this.isCompleted = isCompleted;
    }


    //getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", isCompleted=" + isCompleted +
                '}';
    }
}//class end
