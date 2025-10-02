package JavaProjects.TaskManagerCLI;

import java.util.Objects;

public class Task {
    private int id;
    private String title;
    private String description;
    private Status status;
    private Priority priority;
    private String dueDate;
    private String creationDate;
    private String completionDate;

    public Task(int id, String title, String description, Status status, Priority priority, String dueDate, String creationDate, String completionDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.dueDate = dueDate;
        this.creationDate = creationDate;
        this.completionDate = completionDate;
    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public Status getStatus() {
        return status;
    }
    public Priority getPriority() {
        return priority;
    }
    public String getDueDate() {
        return dueDate;
    }
    public String getCreationDate() {
        return creationDate;
    }
    public String getCompletionDate() {
        return completionDate;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public void setPriority(Priority priority) {
        this.priority = priority;
    }
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
    public void setCreationDate(String creationDate) {this.creationDate = creationDate;}
    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + "'" +
                ",Description= '" + description + "'" +
                ", status= " + status +
                ", priority= " + priority +
                ", dueDate= '" + dueDate + "'" +
                ", creationDate= '" + creationDate + "'" +
                ", completionDate= '" + completionDate + "'" +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return getId() == task.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
