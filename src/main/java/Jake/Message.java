package Jake;

public class Message {
    static public final String INDENT = "  ";
    static public final String LINE_SEPARATOR = INDENT + "-----------------------------------------------------------------";
    static public final String VERTICAL_BAR = "|";
    static public final String TRUE = "1";
    static public final String FALSE = "0";

    static public final String TODO = "[T]";
    static public final String TODO_FILE = "T";
    static public final String DEADLINE = "[D]";
    static public final String DEADLINE_FILE = "D";
    static public final String EVENT = "[E]";
    static public final String EVENT_FILE = "E";

    static public final String DONE_SYMBOL = "[X]";
    static public final String NOT_DONE_SYMBOL = "[ ]";

    static public final String WELCOME = INDENT + "Hello! My name is Jake... Why am I here again?\n"
            + INDENT + "Anyway, what can I do for you this time?";
    static public final String BYE = INDENT + "Bye! Don't find me again, do it yourself!";

    static public final String ADD_TASK = INDENT + "Got it. I've added this task:";
    static public final String NUM_TASKS = INDENT + "Now you have %d tasks in the list.";
    static public final String MORE = "more, MoRe, MORE!!!";
    static public final String BAD = "bad, BaD, BAD!!!";
    static public final String MARK_TASK = INDENT + "Nice! I've marked this task as done:";
    static public final String UNMARK_TASK = INDENT + "Nice! I've unmarked this task:";
    static public final String UNKNOWN_COMMAND = INDENT + "I'm sorry, but I don't know what that means :-(";
    static public final String LIST_TASKS = INDENT + "Here are the tasks in your list:";
    static public final String DELETE_TASK = INDENT + "Noted. I've removed this task:";
    static public final String DONE_ALREADY = INDENT + "Task is already done! Don't need to mark it done again.";
    static public final String UNDONE_ALREADY = INDENT + "Task is already undone! Don't need to mark it undone again.";
    static public final String GG = "(gg by: %s)";
    static public final String DURATION = "(%s -> %s)";

    static public final String CHECK_CUR_TASKS = INDENT + "Here are the tasks in your list:";

    static public final String MISSING_PARAMS = "Missing parameters! Please check your input and try again.";
    static public final String INVALID_PARAMS = "Invalid parameters! Please check your input and try again.";
    static public final String INVALID_TASK_TYPE = "Invalid task type! Please check your input and try again.";

}
