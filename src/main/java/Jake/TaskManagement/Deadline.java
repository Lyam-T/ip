package Jake.TaskManagement;

import Jake.Ui;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    private final LocalDateTime by;

    public Deadline(String name, LocalDateTime by) {
        super(name);
        this.by = by;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm");
        return Ui.DEADLINE + super.toString() + Ui.INDENT +  String.format(Ui.GG, by.format(formatter));
    }

    @Override
    public String toFileString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return Ui.DEADLINE_FILE + Ui.VERTICAL_BAR
                + super.getName() + Ui.VERTICAL_BAR
                + (isDone() ? Ui.TRUE : Ui.FALSE) + Ui.VERTICAL_BAR
                + by.format(formatter);
    }
}
