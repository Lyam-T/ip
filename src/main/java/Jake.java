import java.util.Scanner;

public class Jake {
    public static String[] tasks = new String[100];
    public static int taskCount = 0;
    public static String lineSeparator = "  -----------------------------------------------------------------";

    public static void echo(String input) {
        System.out.println("  " + input);
    }

    public static void addTask(String task) {
       tasks[taskCount++] = task;
       System.out.print("added: ");
    }

    public static void printTasks() {
        for (int i = 0; i < taskCount; i++) {
            System.out.println("  " + (i + 1) + ". " + tasks[i]);
        }
    }

    public static void handleInput(String input) {
        System.out.println(lineSeparator);
        switch(input.toLowerCase()) {
            case "list" -> {
                printTasks();
            }
            default -> {
                addTask(input);
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
