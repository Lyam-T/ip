package Jake.TaskManagement;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import Jake.Ui;
import Jake.Execution.Parser;

/**
 * Class that contains and manage the tasks.
 */
public class TaskPool {
    private final List<Task> tasks = new ArrayList<>();
    private final Parser parser = new Parser();

    /**
     * Adds a new todo task to the task list.
     * @param name the name of the task.
     */
    public void addToDo(String name) {
        tasks.add(new ToDo(name));
    }

    /**
     * Adds a new deadline task to the task list.
     * @param name the name of the task.
     * @param by the deadline of the task.
     * @format by should be in the format "yyyy-MM-dd HH:mm".
     */
    public void addDeadline(String name, String by) {
        tasks.add(new Deadline(name, parser.parseDateTime(by)));
    }

    /**
     * Adds a new event task to the task list.
     * @param name the name of the task.
     * @param from the start time of the event.
     * @param to the end time of the event.
     * @format from and to should be in the format "yyyy-MM-dd HH:mm".
     */
    public void addEvent(String name, String from, String to) {
        tasks.add(new Event(name, parser.parseDateTime(from), parser.parseDateTime(to)));
    }

    /**
     * Deletes a task from the task list.
     * @param taskNumber the task number as shown in the list command, starting from 1.
     */
    public void deleteTask(int taskNumber) {
        tasks.remove(taskNumber - 1);
    }

    /**
     * Marks a task as done.
     * @param taskNumber the task number as shown in the list command, starting from 1.
     * @return true if the task is successfully marked as done else false.
     */
    public Boolean markTaskAsDone(int taskNumber) {
        return tasks.get(taskNumber - 1).markDone();
    }

    /**
     * Marks a task as undone.
     * @param taskNumber the task number as shown in the list command, starting from 1.
     */
    public Boolean markTaskAsUndone(int taskNumber) {
        return tasks.get(taskNumber - 1).markUndone();
    }

    /**
     * Prints all the tasks in the task list.
     */
    public void printTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + tasks.get(i));
        }
    }

    /**
     * Gets the number of tasks in the task list.
     * @return the number of tasks in the task list.
     */
    public Integer getTaskCount() {
        return tasks.size();
    }

    /**
     * Adds a task to the file input.
     * @param taskInfo [0] the type of task,
     *                 [1] the name of the task,
     *                 [2] the status of the task,
     *                 [...] the other task specific details of the task.
     */
    public void addTaskFromFileString(String[] taskInfo) {
        switch (taskInfo[0]) {
            case Ui.TODO_FILE -> {
                tasks.add(new ToDo(taskInfo[1], Ui.TRUE.equals(taskInfo[2])));
            }
            case Ui.DEADLINE_FILE -> {
                tasks.add(new Deadline(taskInfo[1], Ui.TRUE.equals(taskInfo[2]), parser.parseDateTime(taskInfo[3])));
            }
            case Ui.EVENT_FILE -> {
                tasks.add(new Event(taskInfo[1], Ui.TRUE.equals(taskInfo[2]), parser.parseDateTime(taskInfo[3]), parser.parseDateTime(taskInfo[4])));
            }
            default -> {
                System.out.println(Ui.INVALID_TASK_TYPE);
            }
        }
    }

    /**
     * Finds tasks that contain the keyword.
     * @param keyword
     * @return a list of tasks that contain the keyword.
     */
    public ArrayList<Task> findTask(String keyword) {
        ArrayList<Task> foundTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getName().contains(keyword)) {
                foundTasks.add(task);
            }
        }
        return foundTasks;
    }

    /**
     * Converts the task to a string to be written to the file.
     * @param i the actual index of the task in the task list, starting from 0.
     * @return the task as a string to be written to the file.
     */
    public String toFileString(int i) {
        return tasks.get(i).toFileString();
    }

    /**
     * Prints the task info.
     * @param taskNumber the task number as shown in the list command, starting from 1.
     */
    public void printTask(int taskNumber) {
        System.out.println(Ui.INDENT + tasks.get(taskNumber - 1));
    }
}
