package Jake.TaskManagement;

public class Event extends Task {
    private final String from;
    private final String to;

    public Event(String name, String from, String to) {
        super(name);
        this.from = from;
        this.to = to;
    }

    public Event(String name, boolean isDone, String from, String to) {
        super(name);
        if (isDone) {
            super.markDone();
        }
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (" + from + " -> " + to + ")";
    }

    @Override
    public String toFileString() {
        return "E | " + super.getName() + " | " + (isDone() ? "1" : "0") + " | " + from + " | " + to;
    }
}
