package Jake.TaskManagement;

public class ToDo extends Task {
    public ToDo(String name) {
        super(name);
    }

    public ToDo(String name, Boolean isDone) {
        super(name);
        if (isDone) {
            super.markDone();
        }
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    public String toFileString() {
        return "T | " + super.getName() + " | " + (isDone() ? "1" : "0") + " | ";
    }
}
