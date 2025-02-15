package Jake;

import Jake.IOManagement.IOManager;
import Jake.TaskManagement.TaskPool;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        switch (Command.valueOf(commandAndArgs[0].toUpperCase())) {
            case LIST -> {
                handleList();
            }
            case MARK -> {
                handleMark(commandAndArgs);
            }
            case UNMARK -> {
                handleUnmark(commandAndArgs);
            }
            case TODO -> {
                handleTodo(commandAndArgs);
            }
            case DEADLINE -> {
                handleDeadline(commandAndArgs);
            }
            case EVENT -> {
                handleEvent(commandAndArgs);
            }
            default -> {
                handleDefault();
            }
        }
        System.out.println(lineSeparator);
    }

    private static void handleDefault() {
        System.out.println("  I'm sorry, but I don't know what that means :-(");
    }

    private static void handleEvent(String[] commandAndArgs) {
        try {
            taskPool.addEvent(commandAndArgs[1], commandAndArgs[2], commandAndArgs[3]);
            printAddTaskMsg();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("  [event] cannot be processed. Please enter a task name, a start time and an end time.");
        }
    }

    private static void handleDeadline(String[] commandAndArgs) {
        try {
            taskPool.addDeadline(commandAndArgs[1], commandAndArgs[2]);
            printAddTaskMsg();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("  [deadline] cannot be processed. Please enter a task name and a deadline.");
        }
    }

    private static void handleTodo(String[] commandAndArgs) {
        try {
            taskPool.addToDo(commandAndArgs[1]);
            printAddTaskMsg();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("  [todo] cannot be processed. Please enter a task name.");
        }
    }

    private static void handleUnmark(String[] commandAndArgs) {
        try {
            int taskNumber = Integer.parseInt(commandAndArgs[1]);
            taskPool.markTaskAsUndone(taskNumber);
            printUnmarkTaskMsg();
        } catch (NumberFormatException e) {
            System.out.println("  [unmark] cannot be processed. Please enter a number instead of anything else... don't give me addition workload :<");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("  [unmark] cannot be processed. Please enter a valid task number. Check the list to see the task number.");
            taskPool.printTasks();
        }
    }

    private static void handleList() {
        System.out.println("  Here are the tasks in your list:");
        taskPool.printTasks();
    }

    private static void handleMark(String[] commandAndArgs) {
        try {
            int taskNumber = Integer.parseInt(commandAndArgs[1]);
            taskPool.markTaskAsDone(taskNumber);
            printMarkTaskMsg();
        } catch (NumberFormatException e) {
            System.out.println("  [mark] cannot be processed. Please enter a number instead of anything else... don't give me addition workload :<");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("  [mark] cannot be processed. Please enter a valid task number. Check the list to see the task number.");
            taskPool.printTasks();
        }
    }

    public static void main(String[] args) {
        printWelcomingMsg();
        IOManager.readTasksFromFile(taskPool);
        readAndHandleInput();
        IOManager.writeTasksToFile(taskPool);
        printByeMsg();
    }

}
