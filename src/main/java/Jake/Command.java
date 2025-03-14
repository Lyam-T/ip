package Jake;

public enum Command {
    LIST("[LIST]"),
    MARK("[MARK]"),
    UNMARK("[UNMARK]"),
    TODO("[TODO]"),
    DEADLINE("[DEADLINE]"),
    EVENT("[EVENT]"),
    DELETE("[DELETE]"),
    FIND("[FIND]");

    private final String command;

    Command(String command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return this.command;
    }
}
