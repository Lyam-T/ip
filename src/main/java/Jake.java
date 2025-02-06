import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Jake {
    private static final TaskPool taskPool = new TaskPool();
    private static final String lineSeparator = "  -----------------------------------------------------------------";
    
    private static void printWelcomingMsg() {
        System.out.println(lineSeparator);
        System.out.println("  Hello! My name is Jake... Why am I here again?");
        System.out.println("  Anyway, what can I do for you this time?");
        System.out.println(lineSeparator);
    }


    private static void printByeMsg() {
        System.out.println(lineSeparator);
        System.out.println("  Bye! Don't find me again, do it yourself!");
        System.out.println(lineSeparator);
    }

    private static void printAddTaskMsg() {
        System.out.println("  Got it. I've added this task:");
        System.out.print("    ");
        taskPool.printTask(taskPool.getTaskCount());
        System.out.println("  Now you have " + taskPool.getTaskCount() + " tasks in the list. More, MoRe, MORE!!!");
    }

    private static void printMarkTaskMsg() {
        System.out.println("  Nice! I've marked this task as done:");
        System.out.print("    ");
        taskPool.printTask(taskPool.getTaskCount());
    }

    private static void printUnmarkTaskMsg() {
        System.out.println("  Nice! I've unmarked this task:");
        System.out.print("    ");
        taskPool.printTask(taskPool.getTaskCount());
    }

    private static void readAndHandleInput() {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        while (!"bye".equalsIgnoreCase(input)) {
            handleInput(input);
            input = in.nextLine();
        }
    }

    /**
     * Parse the input string into command and arguments.
     * @param input the input string from the user.
     * @return an array of strings containing the command and arguments.
     */
    private static String[] parseInput(String input) {
        List<String> result = new ArrayList<String>();
        String[] commandAndArgs = input.split("\\s", 2);
        String[] args = commandAndArgs.length > 1 ? commandAndArgs[1].split("(?i)/by|/from|/to") : null;

        result.add(commandAndArgs[0]);
        if (args == null) {
            return result.toArray(new String[0]);
        }
        for (String arg : args) {
            result.add(arg.trim());
        }

        return result.toArray(new String[0]);
    }

    /**
     * Parse the input and execute the command.
     * @param input the input string from the user.
     */
    private static void handleInput(String input) {
        String[] commandAndArgs = parseInput(input);

        System.out.println(lineSeparator);
        switch(commandAndArgs[0].toLowerCase()) {
            case "list" -> {
                System.out.println("  Here are the tasks in your list:");
                taskPool.printTasks();
            }
            case "mark" -> {
                int taskNumber = Integer.parseInt(commandAndArgs[1]);
                taskPool.markDone(taskNumber);
                printMarkTaskMsg();
            }
            case "unmark" -> {
                int taskNumber = Integer.parseInt(commandAndArgs[1]);
                taskPool.markUndone(taskNumber);
                printUnmarkTaskMsg();
            }
            case "todo" -> {
                taskPool.addToDo(commandAndArgs[1]);
                printAddTaskMsg();
            }
            case "deadline" -> {
                taskPool.addDeadline(commandAndArgs[1], commandAndArgs[2]);
                printAddTaskMsg();
            }
            case "event" -> {
                taskPool.addEvent(commandAndArgs[1], commandAndArgs[2], commandAndArgs[3]);
                printAddTaskMsg();
            }
            default -> {
                System.out.println("  I'm sorry, but I don't know what that means :-(");
            }
        }
        System.out.println(lineSeparator);
    }

    public static void main(String[] args) {
        printWelcomingMsg();
        readAndHandleInput();
        printByeMsg();
    }
}
