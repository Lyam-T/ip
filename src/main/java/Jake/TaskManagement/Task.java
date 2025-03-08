package Jake.TaskManagement;

import Jake.Ui;

public class Task {
    private String name;
    private boolean isDone = false;

    public Task(String name) {
        this.name = name;
    }

    public Boolean markDone() {
        if (isDone) {
            return false;
        }

        isDone = true;
        return true;
    }

    public Boolean markUndone() {
        if (!isDone) {
            return false;
        }
        
        isDone = false;
        return true;
    }

    public boolean isDone() {
        return this.isDone;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return (isDone) ? Ui.DONE_SYMBOL + Ui.INDENT + name
                        : Ui.NOT_DONE_SYMBOL + Ui.INDENT + name;
    }

    public String toFileString() {
        return null;
    }
}
