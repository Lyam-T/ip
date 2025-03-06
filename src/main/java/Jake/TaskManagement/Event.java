package Jake.TaskManagement;

import Jake.Ui;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    private final LocalDateTime from;
    private final LocalDateTime to;

    public Event(String name, LocalDateTime from, LocalDateTime to) {
        super(name);
        this.from = from;
        this.to = to;
    }

    public Event(String name, boolean isDone, LocalDateTime from, LocalDateTime to) {
        super(name);
        if (isDone) {
            super.markDone();
        }
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm");
        return Ui.EVENT + super.toString() + Ui.INDENT + String.format(Ui.DURATION, from.format(formatter), to.format(formatter));
    }

    @Override
    public String toFileString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return Ui.EVENT_FILE + Ui.VERTICAL_BAR
                + super.getName() + Ui.VERTICAL_BAR
                + (isDone() ? Ui.TRUE : Ui.FALSE) + Ui.VERTICAL_BAR
                + from.format(formatter) + Ui.VERTICAL_BAR
                + to.format(formatter);
    }
}
