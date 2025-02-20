package Jake.TaskManagement;

public class Task {
    private String name;
    private boolean isDone = false;

    public Task(String name) {
        this.name = name;
    }

    public void markDone() {
        if (isDone) {
            System.out.println("Task is already done! Don't need to mark it done again.");
        }

        isDone = true;
    }

    public void markUndone() {
        if (!isDone) {
            System.out.println("Task is already undone! Don't need to mark it undone again.");
        }
        
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
