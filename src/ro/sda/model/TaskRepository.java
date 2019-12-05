package ro.sda;

import java.util.*;

public final class TaskRepository {

    private HashSet<Task> taskList = new HashSet<>();

    private TaskRepository() {
        taskList.add(Task.newtask().taskName("Spala vase").checked(false).build());
        taskList.add(Task.newtask().taskName("Mai spala-le odata").checked(false).build());
        taskList.add(Task.newtask().taskName("Du-te si du gunoiu'").checked(true).build());
    };
    private static TaskRepository repo = new TaskRepository();

    public static TaskRepository getInstance() { return repo; }

    public Collection<Task> getAllTasks() { return Collections.unmodifiableCollection(taskList); }

    public void addTask(Task taskToAdd) { taskList.add(taskToAdd); }

    public void setCompleted(String nameOfTask) {
        for (Task a : taskList) {
            if (a.getTaskName().equalsIgnoreCase(nameOfTask)) {
                a.setChecked(true);
            }
        }
    }

}