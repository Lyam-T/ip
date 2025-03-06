package Jake.TaskManagement;

import Jake.Ui;

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
        return Ui.EVENT + super.toString() + Ui.INDENT + String.format(Ui.DURATION, from, to);
    }

    @Override
    public String toFileString() {
        return Ui.EVENT_FILE + Ui.VERTICAL_BAR
                + super.getName() + Ui.VERTICAL_BAR
                + (isDone() ? Ui.TRUE : Ui.FALSE) + Ui.VERTICAL_BAR
                + from + Ui.VERTICAL_BAR
                + to;
    }
}
