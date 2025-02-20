package Jake.TaskManagement;

import Jake.Message;

public class Task {
    private String name;
    private boolean isDone = false;

    public Task(String name) {
        this.name = name;
    }

    public void markDone() {
        if (isDone) {
            System.out.println(Message.DONE_ALREADY);
        }

        isDone = true;
    }

    public void markUndone() {
        if (!isDone) {
            System.out.println(Message.UNDONE_ALREADY);
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
        return (isDone) ? Message.DONE_SYMBOL + Message.INDENT + name
                        : Message.NOT_DONE_SYMBOL + Message.INDENT + name;
    }

    public String toFileString() {
        return null;
    }
}
