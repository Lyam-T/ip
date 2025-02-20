package Jake.TaskManagement;

import Jake.Command;
import Jake.Message;

public class Deadline extends Task {
    private final String by;

    public Deadline(String name, String by) {
        super(name);
        this.by = by;
    }

    @Override
    public String toString() {
        return Message.DEADLINE + super.toString() + Message.INDENT +  String.format(Message.GG, by);
    }

    @Override
    public String toFileString() {
        return Message.DEADLINE_FILE + Message.VERTICAL_BAR
                + super.getName() + Message.VERTICAL_BAR
                + (isDone() ? Message.TRUE : Message.FALSE) + Message.VERTICAL_BAR
                + by;
    }
}
