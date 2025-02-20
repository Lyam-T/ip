package Jake;

public class Message {
    static final String INDENT = "  ";
    static final String LINE_SEPARATOR = INDENT + "-----------------------------------------------------------------";

    static final String WELCOME = INDENT + "Hello! My name is Jake... Why am I here again?\n"
            + INDENT + "Anyway, what can I do for you this time?";
    static final String BYE = INDENT + "Bye! Don't find me again, do it yourself!";

    static final String ADD_TASK = INDENT + "Got it. I've added this task:";
    static final String NUM_TASKS = INDENT + "Now you have %d tasks in the list.";
    static final String MORE = "more, MoRe, MORE!!!";
    static final String BAD = "bad, BaD, BAD!!!";
    static final String MARK_TASK = INDENT + "Nice! I've marked this task as done:";
    static final String UNMARK_TASK = INDENT + "Nice! I've unmarked this task:";
    static final String UNKNOWN_COMMAND = INDENT + "I'm sorry, but I don't know what that means :-(";
    static final String LIST_TASKS = INDENT + "Here are the tasks in your list:";
    static final String DELETE_TASK = INDENT + "Noted. I've removed this task:";

    static final String CHECK_CUR_TASKS = INDENT + "Here are the tasks in your list:";

    static final String MISSING_PARAMS = "Missing parameters! Please check your input and try again.";
    static final String INVALID_PARAMS = "Invalid parameters! Please check your input and try again.";

}
