package Jake.Execution;

import Jake.Command;
import Jake.TaskManagement.Task;
import Jake.TaskManagement.TaskPool;
import Jake.Ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Executor {
    private final Parser parser = new Parser();
    private final TaskPool taskPool;
    private final Ui ui = new Ui();

    public Executor(TaskPool taskPool) {
        this.taskPool = taskPool;
    }

    public void readAndHandleInput() {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        while (!"bye".equalsIgnoreCase(input)) {
            handleInput(input);
            input = in.nextLine();
        }
    }

    public String[] parseInput(String input) {
        return parser.parseInput(input);
    }

    public void handleInput(String input) {
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
                case FIND -> {
                    handleFind(commandAndArgs);
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

    private void handleDelete(String[] commandAndArgs) {
        try {
            int taskNumber = Integer.parseInt(commandAndArgs[1]);
            taskPool.deleteTask(taskNumber);
            ui.printDeleteTaskMsg(taskPool);
        } catch (NumberFormatException e) {
            System.out.println(commandAndArgs[0] + Ui.INVALID_PARAMS);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(commandAndArgs[0] + Ui.INVALID_PARAMS + "\n" + Ui.CHECK_CUR_TASKS);
            taskPool.printTasks();
        }
    }

    private void handleEvent(String[] commandAndArgs) {
        try {
            taskPool.addEvent(commandAndArgs[1], commandAndArgs[2], commandAndArgs[3]);
            ui.printAddTaskMsg(taskPool);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(commandAndArgs[0] + Ui.MISSING_PARAMS);
        }
    }

    private void handleDeadline(String[] commandAndArgs) {
        try {
            taskPool.addDeadline(commandAndArgs[1], commandAndArgs[2]);
            ui.printAddTaskMsg(taskPool);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(commandAndArgs[0] + Ui.MISSING_PARAMS);
        }
    }

    private void handleTodo(String[] commandAndArgs) {
        try {
            taskPool.addToDo(commandAndArgs[1]);
            ui.printAddTaskMsg(taskPool);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(commandAndArgs[0] + Ui.MISSING_PARAMS);
        }
    }

    private void handleUnmark(String[] commandAndArgs) {
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

    private void handleList() {
        System.out.println(Ui.LIST_TASKS);
        taskPool.printTasks();
    }

    private void handleMark(String[] commandAndArgs) {
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

    private void handleFind(String[] commandAndArgs) {
        try {
            List<Task> foundTasks = taskPool.findTask(commandAndArgs[1]);
            if (foundTasks.isEmpty()) {
                System.out.println(Ui.NO_TASKS_FOUND);
            } else {
                System.out.println(Ui.FOUND_TASK);
                for (int i = 0; i < foundTasks.size(); i++) {
                    System.out.println("  " + (i + 1) + ". " + foundTasks.get(i));
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(commandAndArgs[0] + Ui.MISSING_PARAMS);
        }
    }
}
