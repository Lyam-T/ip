package Jake.TaskManagement;

public class Task {
    private String name;
    private boolean isDone = false;

    public Task(String name) {
        this.name = name;
    }

    public void markDone() {
        isDone = true;
    }

    public void markUndone() {
        isDone = false;
    }

    public boolean isDone() {
        return this.isDone;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return (isDone) ? "[X] " + name : "[ ] " + name;
    }

    public String toFileString() {
        return null;
    }
}
