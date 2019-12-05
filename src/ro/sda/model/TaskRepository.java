package ro.sda.model;

import java.util.*;

public final class TaskRepository {

    private HashSet<Task> taskList = new HashSet<>();

    private static TaskRepository repo = new TaskRepository();

    public static TaskRepository getInstance() {
        return repo;
    }

    public Collection<Task> getAllTasks() {
        return Collections.unmodifiableCollection(taskList);
    }

    public void setCompleted(String nameOfTask) {
        for (Task tasks : taskList) {
            if (tasks.getTaskName().equalsIgnoreCase(nameOfTask)) {
                tasks.setChecked(true);
            }
        }
    }

    public void addTask(Task taskToAdd) {
        taskList.add(taskToAdd);
    }

    public Optional<Task> findToDoItem(String action) {
        return taskList.stream()
                .filter(task -> task.getTaskName().equalsIgnoreCase(action)).findFirst();
    }

    private TaskRepository() {
        taskList.add(Task.newtask().taskName("Spala vase").checked(false).build());
    }
}