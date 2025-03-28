package Jake.Execution;

import Jake.Ui;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import Jake.Ui;

public class Parser {
    /**
     * Parse the input string into command and arguments.
     *
     * @param input the input string from the user.
     * @return an array of strings containing the command and arguments.
     */
    public String[] parseInput(String input) {
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
     * Parse the date and time string into a LocalDateTime object.
     *
     * @param dateTime
     * @return LocalDateTime object
     * @throws DateTimeParseException
     */
    public LocalDateTime parseDateTime(String dateTime) {
        DateTimeFormatter formatter;
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(dateTime, formatter);
    }
}
