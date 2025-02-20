package Jake.TaskManagement;

import Jake.Command;
import Jake.Message;

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
        return Message.EVENT + super.toString() + Message.INDENT + String.format(Message.DURATION, from, to);
    }

    @Override
    public String toFileString() {
        return Message.EVENT_FILE + Message.VERTICAL_BAR
                + super.getName() + Message.VERTICAL_BAR
                + (isDone() ? Message.TRUE : Message.FALSE) + Message.VERTICAL_BAR 
                + from + Message.VERTICAL_BAR
                + to;
    }
}
