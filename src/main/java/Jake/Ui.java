package Jake;

import Jake.TaskManagement.TaskPool;

public class Ui {
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
    static public final String NO_TASKS_FOUND = INDENT + "There is no such task in your list, hmmm... weird.";
    static public final String FOUND_TASK = INDENT + "Here is the matching task in your list:";

    static public final String CHECK_CUR_TASKS = INDENT + "Here are the tasks in your list:";

    static public final String MISSING_PARAMS = "Missing parameters! Please check your input and try again.";
    static public final String INVALID_PARAMS = "Invalid parameters! Please check your input and try again.";
    static public final String INVALID_TASK_TYPE = "Invalid task type! Please check your input and try again.";

    public void printWelcomingMsg() {
        System.out.println(LINE_SEPARATOR);
        System.out.println(WELCOME);
        System.out.println(LINE_SEPARATOR);
    }


    public void printByeMsg() {
        System.out.println(LINE_SEPARATOR);
        System.out.println(BYE);
        System.out.println(LINE_SEPARATOR);
    }

    public void printAddTaskMsg(TaskPool taskPool) {
        System.out.println(ADD_TASK);
        System.out.print(INDENT);
        taskPool.printTask(taskPool.getTaskCount());
        System.out.println(String.format(NUM_TASKS, taskPool.getTaskCount()) + MORE);
    }

    public void printDeleteTaskMsg(TaskPool taskPool) {
        System.out.println(DELETE_TASK);
        taskPool.printTask(taskPool.getTaskCount());
        System.out.println(String.format(NUM_TASKS, taskPool.getTaskCount()) + BAD);
    }

    public void printMarkTaskMsg(TaskPool taskPool) {
        System.out.println(MARK_TASK + INDENT);
        taskPool.printTask(taskPool.getTaskCount());
    }

    public void printUnmarkTaskMsg(TaskPool taskPool) {
        System.out.println(UNMARK_TASK + INDENT);
        taskPool.printTask(taskPool.getTaskCount());
    }
}
