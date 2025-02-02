import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jake {
    private static final TaskPool taskPool = new TaskPool();
    private static final String lineSeparator = "  -----------------------------------------------------------------";
    
    private static void printWelcomingMessage() {
        System.out.println(lineSeparator);
        System.out.println("  Hello! My name is "
                + "Jake"
                + "... Why I am here again?");
        System.out.println("  Anyway, what can I do for you this time?");
        System.out.println(lineSeparator);
    }


    private static void printByeMessage() {
        System.out.println(lineSeparator);
        System.out.println("  Bye! Don't find me again, do it yourself!");
        System.out.println(lineSeparator);
    }

    private static void readAndHandleInput() {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        while (!"bye".equalsIgnoreCase(input)) {
            handleInput(input);
            input = in.nextLine();
        }
    }

    private static void handleInput(String input) {
        String[] parts = input.split("\\s");

        System.out.println(lineSeparator);
        switch(parts[0].toLowerCase()) {
            case "list" -> {
                System.out.println("  Here are the tasks in your list:");
                taskPool.printTasks();
            }
            case "mark" -> {
                int taskNumber = Integer.parseInt(parts[1]);
                System.out.println("  Nice! I've marked this task as done:");
                taskPool.markDone(taskNumber);
            }
            case "unmark" -> {
                int taskNumber = Integer.parseInt(parts[1]);
                System.out.println("  Nice! I've unmarked this task:");
                taskPool.markUndone(taskNumber);
            }
            default -> {
                taskPool.addTask(input);
                System.out.println("  added: " + input);
            }
        }
        System.out.println(lineSeparator);
    }

    public static void main(String[] args) {
        printWelcomingMessage();
        readAndHandleInput();
        printByeMessage();
    }
}
