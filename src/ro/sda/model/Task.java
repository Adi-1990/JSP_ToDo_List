package ro.sda;

import java.util.Objects;

public class Task {

    private String taskName;
    private boolean checked;

    public String getTaskName() { return taskName; }

    public boolean isChecked() { return checked; }

    public void setChecked(boolean checked) { this.checked = checked; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return checked == task.checked &&
                taskName.equals(task.taskName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskName, checked);
    }

    public static Builder newtask() { return new Builder(); }

    private Task(Builder builder) {
        this.taskName = builder.taskName;
        this.checked = builder.checked;
    }

    public static final class Builder {
        private String taskName;
        private boolean checked;

        private Builder() {
        }

        public Task build() {
            return new Task(this);
        }

        public Builder taskName(String taskName) {
            this.taskName = taskName;
            return this;
        }

        public Builder checked(boolean checked) {
            this.checked = checked;
            return this;
        }
    }
}