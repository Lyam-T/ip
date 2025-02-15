package Jake.TaskManagement;

import java.util.ArrayList;
import java.util.List;

public class TaskPool {
    private final List<Task> tasks = new ArrayList<>();

    public void addToDo(String name) {
        tasks.add(new ToDo(name));
    }

    public void addDeadline(String name, String by) {
        tasks.add(new Deadline(name, by));
    }

    public void addEvent(String name, String from, String to) {
        tasks.add(new Event(name, from, to));
    }

    /**
     * Marks a task as done.
     *
     * @param taskNumber the task number as shown in the list command, starting from 1.
     */
    public void markTaskAsDone(int taskNumber) {
        tasks.get(taskNumber - 1).markDone();
    }

    /**
     * Marks a task as undone.
     *
     * @param taskNumber the task number as shown in the list command, starting from 1.
     */
    public void markTaskAsUndone(int taskNumber) {
        tasks.get(taskNumber - 1).markUndone();
    }

    public void printTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + tasks.get(i));
        }
    }

    public Integer getTaskCount() {
        return tasks.size();
    }

    public void addTaskFromFileString(String[] taskInfo) {
        switch (taskInfo[0]) {
            case "T" -> {
                tasks.add(new ToDo(taskInfo[1], taskInfo[2].equals("1")));
            }
            case "D" -> {
                tasks.add(new Deadline(taskInfo[1], taskInfo[2].equals("1"), taskInfo[3]));
            }
            case "E" -> {
                tasks.add(new Event(taskInfo[1], taskInfo[2].equals("1"), taskInfo[3], taskInfo[4]));
            }
            default -> {
                System.out.println("Invalid task type in file.");
            }
        }
    }

    public String toFileString(int i) {
        return tasks.get(i).toFileString();
    }

    /**
     * Prints the task info.
     *
     * @param taskNumber the task number as shown in the list command, starting from 1.
     */
    public void printTask(int taskNumber) {
        System.out.println(tasks.get(taskNumber - 1));
    }
}
