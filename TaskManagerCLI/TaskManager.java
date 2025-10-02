package JavaProjects.TaskManagerCLI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class TaskManager {
    // Task management logic here
    ArrayList<Task> orderedTasks = new ArrayList<>();
    HashMap<Integer, Task> tasks = new HashMap<>();
    public void addTask(Task task) {
        tasks.put(task.getId(), task);
        orderedTasks.add(task);
    }
    public void removeTask(int id) {
        Task task = tasks.get(id);
        if (task != null) {
            tasks.remove(task.getId());
            orderedTasks.remove(task);
        }
    }
    public Task editTasks(int id, String title, String description, Status status, Priority priority, String dueDate, String creationDate, String completionDate) {
        Task task = tasks.get(id);
        if (task != null) {
            if (title != null && !title.isBlank()) task.setTitle(title);
            if (description != null && !description.isBlank()) task.setDescription(description);
            if (status != null) task.setStatus(status);
            if (priority != null) task.setPriority(priority);
            if (dueDate != null && !dueDate.isBlank()) task.setDueDate(dueDate);
            if (creationDate != null && !creationDate.isBlank()) task.setCreationDate(creationDate);
            if (completionDate != null && !completionDate.isBlank()) task.setCompletionDate(completionDate);
            return task;
        }
        return null;
    }
    public void viewAllTasks() {
        for (Task task : orderedTasks) {
            System.out.println(task.toString());
        }
    }
    public Task getTaskById(int id) {
        if (!tasks.containsKey(id)) {
            System.out.println("Task with ID " + id + " not found.");
            return null;
        }
        return tasks.get(id);
    }
}
