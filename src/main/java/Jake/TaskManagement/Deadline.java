package Jake.TaskManagement;

import Jake.Ui;

public class Deadline extends Task {
    private final String by;

    public Deadline(String name, String by) {
        super(name);
        this.by = by;
    }

    @Override
    public String toString() {
        return Ui.DEADLINE + super.toString() + Ui.INDENT +  String.format(Ui.GG, by);
    }

    @Override
    public String toFileString() {
        return Ui.DEADLINE_FILE + Ui.VERTICAL_BAR
                + super.getName() + Ui.VERTICAL_BAR
                + (isDone() ? Ui.TRUE : Ui.FALSE) + Ui.VERTICAL_BAR
                + by;
    }
}
