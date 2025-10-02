package JavaProjects.TaskManagerCLI;

import java.util.ArrayList;
import java.util.Comparator;

public class SortByTitle implements TaskSorter{
    @Override
    public void sort(ArrayList<Task> tasks) {
        tasks.sort(Comparator.comparing(Task::getTitle));
    }
}
