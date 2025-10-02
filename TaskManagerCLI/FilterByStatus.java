package JavaProjects.TaskManagerCLI;

public class FilterByStatus implements TaskFilter{
    private Status status;

    public FilterByStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean filter(Task task) {
        return task.getStatus() == status;
    }
}
