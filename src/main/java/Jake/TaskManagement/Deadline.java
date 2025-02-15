package Jake.TaskManagement;

public class Deadline extends Task {
    private final String by;

    public Deadline(String name, String by) {
        super(name);
        this.by = by;
    }

    public Deadline(String name, boolean isDone, String by) {
        super(name);
        if (isDone) {
            super.markDone();
        }
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (gg by: " + by + ")";
    }

    @Override
    public String toFileString() {
        return "D | " + super.getName() + " | " + (isDone() ? "1" : "0") + " | " + by;
    }
}
