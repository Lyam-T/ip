package Jake;

import Jake.IOManagement.IOManager;
import Jake.TaskManagement.TaskPool;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jake {
    private static final TaskPool taskPool = new TaskPool();

    private static void printWelcomingMsg() {
        System.out.println(Message.LINE_SEPARATOR);
        System.out.println(Message.WELCOME);
        System.out.println(Message.LINE_SEPARATOR);
    }


    private static void printByeMsg() {
        System.out.println(Message.LINE_SEPARATOR);
        System.out.println(Message.BYE);
        System.out.println(Message.LINE_SEPARATOR);
    }

    private static void printAddTaskMsg() {
        System.out.println(Message.ADD_TASK);
        System.out.print(Message.INDENT);
        taskPool.printTask(taskPool.getTaskCount());
        System.out.println(String.format(Message.NUM_TASKS, taskPool.getTaskCount()) + Message.MORE);
    }

    private static void printDeleteTaskMsg() {
        System.out.println(Message.DELETE_TASK);
        taskPool.printTask(taskPool.getTaskCount());
        System.out.println(String.format(Message.NUM_TASKS, taskPool.getTaskCount()) + Message.BAD);
    }

    private static void printMarkTaskMsg() {
        System.out.println(Message.MARK_TASK + Message.INDENT);
        taskPool.printTask(taskPool.getTaskCount());
    }

    private static void printUnmarkTaskMsg() {
        System.out.println(Message.UNMARK_TASK + Message.INDENT);
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

        System.out.println(Message.LINE_SEPARATOR);
        try {
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
                case DELETE -> {
                    handleDelete(commandAndArgs);
                }
            }
        } catch (IllegalArgumentException e) {
           handleDefault();
        }
        System.out.println(Message.LINE_SEPARATOR);
    }

    private static void handleDefault() {
        System.out.println(Message.UNKNOWN_COMMAND);
    }

    private static void handleDelete(String[] commandAndArgs) {
       try {
           int taskNumber = Integer.parseInt(commandAndArgs[1]);
           taskPool.deleteTask(taskNumber);
           printDeleteTaskMsg();
       } catch(NumberFormatException e) {
           System.out.println(commandAndArgs[0] + Message.INVALID_PARAMS);
       } catch (IndexOutOfBoundsException e) {
           System.out.println(commandAndArgs[0] + Message.INVALID_PARAMS + "\n" + Message.CHECK_CUR_TASKS);
           taskPool.printTasks();
       }
    }

    private static void handleEvent(String[] commandAndArgs) {
        try {
            taskPool.addEvent(commandAndArgs[1], commandAndArgs[2], commandAndArgs[3]);
            printAddTaskMsg();
        } catch (IndexOutOfBoundsException e) {
            System.out.println(commandAndArgs[0] + Message.MISSING_PARAMS);
        }
    }

    private static void handleDeadline(String[] commandAndArgs) {
        try {
            taskPool.addDeadline(commandAndArgs[1], commandAndArgs[2]);
            printAddTaskMsg();
        } catch (IndexOutOfBoundsException e) {
            System.out.println(commandAndArgs[0] + Message.MISSING_PARAMS);
        }
    }

    private static void handleTodo(String[] commandAndArgs) {
        try {
            taskPool.addToDo(commandAndArgs[1]);
            printAddTaskMsg();
        } catch (IndexOutOfBoundsException e) {
            System.out.println(commandAndArgs[0] + Message.MISSING_PARAMS);
        }
    }

    private static void handleUnmark(String[] commandAndArgs) {
        try {
            int taskNumber = Integer.parseInt(commandAndArgs[1]);
            taskPool.markTaskAsUndone(taskNumber);
            printUnmarkTaskMsg();
        } catch (NumberFormatException e) {
            System.out.println(commandAndArgs[0] + Message.INVALID_PARAMS);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(commandAndArgs[0] + Message.MISSING_PARAMS);
            taskPool.printTasks();
        }
    }

    private static void handleList() {
        System.out.println(Message.LIST_TASKS);
        taskPool.printTasks();
    }

    private static void handleMark(String[] commandAndArgs) {
        try {
            int taskNumber = Integer.parseInt(commandAndArgs[1]);
            taskPool.markTaskAsDone(taskNumber);
            printMarkTaskMsg();
        } catch (NumberFormatException e) {
            System.out.println(commandAndArgs[0] + Message.INVALID_PARAMS);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(commandAndArgs[0] + Message.MISSING_PARAMS);
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
