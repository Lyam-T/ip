import java.util.Scanner;

public class Jake {
    public static void echo(String input) {
        System.out.println("  " + input);
    }

    public static void main(String[] args) {
        String name = "Jake";
        String lineSeparator = "-----------------------------------------------------------------";
        Scanner in = new Scanner(System.in);
        String input;

        System.out.println(lineSeparator);
        System.out.println("Hello! My name is "
                            + name
                            + "... Why I am here again?");
        System.out.println("Anyway, what can I do for you this time?");
        System.out.println(lineSeparator);

        input = in.nextLine();
        while (!"bye".equalsIgnoreCase(input)) {
            System.out.println("  " + lineSeparator.substring(2));
            echo(input);
            System.out.println("  " + lineSeparator.substring(2));
            input = in.nextLine();
        }

        System.out.println("Bye! Don't find me again, do it yourself!");
        System.out.println(lineSeparator);
    }
}
