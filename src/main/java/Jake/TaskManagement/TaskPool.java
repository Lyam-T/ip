package Jake.TaskManagement;

import java.util.ArrayList;
import java.util.List;
import Jake.Message;

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

    public void deleteTask(int taskNumber) {
        tasks.remove(taskNumber - 1);
    }

    /**
     * Marks a task as done.
     * @param taskNumber the task number as shown in the list command, starting from 1.
     */
    public void markTaskAsDone(int taskNumber) {
        tasks.get(taskNumber - 1).markDone();
    }

    /**
     * Marks a task as undone.
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
            case Message.TODO_FILE -> {
                tasks.add(new ToDo(taskInfo[1], taskInfo[2].equals(Message.TRUE)));
            }
            case Message.DEADLINE_FILE -> {
                tasks.add(new Deadline(taskInfo[1], taskInfo[2]));
            }
            case Message.EVENT_FILE -> {
                tasks.add(new Event(taskInfo[1], taskInfo[2].equals(Message.TRUE), taskInfo[3], taskInfo[4]));
            }
            default -> {
                System.out.println(Message.INVALID_TASK_TYPE);
            }
        }
    }

    public String toFileString(int i) {
        return tasks.get(i).toFileString();
    }

    /**
     * Prints the task info.
     * @param taskNumber the task number as shown in the list command, starting from 1.
     */
    public void printTask(int taskNumber) {
        System.out.println(tasks.get(taskNumber - 1));
    }
}
