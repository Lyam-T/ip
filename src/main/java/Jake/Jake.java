package Jake;

import Jake.IOManagement.IOManager;
import Jake.TaskManagement.TaskPool;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jake {
    private static final TaskPool taskPool = new TaskPool();
    private static final Ui ui = new Ui();

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

        System.out.println(Ui.LINE_SEPARATOR);
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
        System.out.println(Ui.LINE_SEPARATOR);
    }

    private static void handleDefault() {
        System.out.println(Ui.UNKNOWN_COMMAND);
    }

    private static void handleDelete(String[] commandAndArgs) {
       try {
           int taskNumber = Integer.parseInt(commandAndArgs[1]);
           taskPool.deleteTask(taskNumber);
           ui.printDeleteTaskMsg(taskPool);
       } catch(NumberFormatException e) {
           System.out.println(commandAndArgs[0] + Ui.INVALID_PARAMS);
       } catch (IndexOutOfBoundsException e) {
           System.out.println(commandAndArgs[0] + Ui.INVALID_PARAMS + "\n" + Ui.CHECK_CUR_TASKS);
           taskPool.printTasks();
       }
    }

    private static void handleEvent(String[] commandAndArgs) {
        try {
            taskPool.addEvent(commandAndArgs[1], commandAndArgs[2], commandAndArgs[3]);
            ui.printAddTaskMsg(taskPool);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(commandAndArgs[0] + Ui.MISSING_PARAMS);
        }
    }

    private static void handleDeadline(String[] commandAndArgs) {
        try {
            taskPool.addDeadline(commandAndArgs[1], commandAndArgs[2]);
            ui.printAddTaskMsg(taskPool);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(commandAndArgs[0] + Ui.MISSING_PARAMS);
        }
    }

    private static void handleTodo(String[] commandAndArgs) {
        try {
            taskPool.addToDo(commandAndArgs[1]);
            ui.printAddTaskMsg(taskPool);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(commandAndArgs[0] + Ui.MISSING_PARAMS);
        }
    }

    private static void handleUnmark(String[] commandAndArgs) {
        try {
            int taskNumber = Integer.parseInt(commandAndArgs[1]);
            taskPool.markTaskAsUndone(taskNumber);
            ui.printUnmarkTaskMsg(taskPool);
        } catch (NumberFormatException e) {
            System.out.println(commandAndArgs[0] + Ui.INVALID_PARAMS);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(commandAndArgs[0] + Ui.MISSING_PARAMS);
            taskPool.printTasks();
        }
    }

    private static void handleList() {
        System.out.println(Ui.LIST_TASKS);
        taskPool.printTasks();
    }

    private static void handleMark(String[] commandAndArgs) {
        try {
            int taskNumber = Integer.parseInt(commandAndArgs[1]);
            taskPool.markTaskAsDone(taskNumber);
            ui.printMarkTaskMsg(taskPool);
        } catch (NumberFormatException e) {
            System.out.println(commandAndArgs[0] + Ui.INVALID_PARAMS);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(commandAndArgs[0] + Ui.MISSING_PARAMS);
            taskPool.printTasks();
        }
    }

    public static void main(String[] args) {
        ui.printWelcomingMsg();
        IOManager.readTasksFromFile(taskPool);
        readAndHandleInput();
        IOManager.writeTasksToFile(taskPool);
        ui.printByeMsg();
    }
}
