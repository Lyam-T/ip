package Jake.TaskManagement;

import Jake.Ui;

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
        return Ui.TODO + super.toString();
    }

    @Override
    public String toFileString() {
        return Ui.TODO_FILE + Ui.VERTICAL_BAR
                + super.getName() + Ui.VERTICAL_BAR
                + (isDone() ? Ui.TRUE : Ui.FALSE);
    }
}
