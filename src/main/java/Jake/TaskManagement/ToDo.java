package Jake.TaskManagement;

import Jake.Message;

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
        return Message.TODO + super.toString();
    }

    @Override
    public String toFileString() {
        return Message.TODO_FILE + Message.VERTICAL_BAR
                + super.getName() + Message.VERTICAL_BAR
                + (isDone() ? Message.TRUE : Message.FALSE);
    }
}
