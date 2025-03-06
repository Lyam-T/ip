package Jake.TaskManagement;

import Jake.Ui;

public class Task {
    private String name;
    private boolean isDone = false;

    public Task(String name) {
        this.name = name;
    }

    public void markDone() {
        if (isDone) {
            System.out.println(Ui.DONE_ALREADY);
        }

        isDone = true;
    }

    public void markUndone() {
        if (!isDone) {
            System.out.println(Ui.UNDONE_ALREADY);
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
        return (isDone) ? Ui.DONE_SYMBOL + Ui.INDENT + name
                        : Ui.NOT_DONE_SYMBOL + Ui.INDENT + name;
    }

    public String toFileString() {
        return null;
    }
}
