import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jake {
    public static TaskPool taskPool = new TaskPool();
    public static String lineSeparator = "  -----------------------------------------------------------------";

    public static void echo(String input) {
        System.out.println("  " + input);
    }

    public static void handleInput(String input) {
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
                System.out.println("  added: ");
                echo(input);
            }
        }
        System.out.println(lineSeparator);
    }

    public static void main(String[] args) {
        String name = "Jake";
        Scanner in = new Scanner(System.in);
        String input;

        System.out.println(lineSeparator);
        System.out.println("  Hello! My name is "
                            + name
                            + "... Why I am here again?");
        System.out.println("  Anyway, what can I do for you this time?");
        System.out.println(lineSeparator);

        input = in.nextLine();
        while (!"bye".equalsIgnoreCase(input)) {
            handleInput(input);
            input = in.nextLine();
        }

        System.out.println(lineSeparator);
        System.out.println("  Bye! Don't find me again, do it yourself!");
        System.out.println(lineSeparator);
    }
}
