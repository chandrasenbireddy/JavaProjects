package JavaProjects.TaskManagerCLI;

public class FilterByPriority implements TaskFilter {
    private Priority priority;

    public FilterByPriority(Priority priority) {
    this.priority = priority;
    }

    @Override
    public boolean filter(Task task) {
        return task.getPriority() == priority;
    }
}
