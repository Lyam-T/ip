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
     * @param taskNumber the task number as shown in the list command, starting from 1.
     */
    public void markDone(int taskNumber) {
        tasks.get(taskNumber - 1).markDone();
    }

    /**
     * Marks a task as undone.
     * @param taskNumber the task number as shown in the list command, starting from 1.
     */
    public void markUndone(int taskNumber) {
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

    /**
     * Prints the task info.
     * @param taskNumber the task number as shown in the list command, starting from 1.
     */
    public void printTask(int taskNumber) {
        System.out.println(tasks.get(taskNumber - 1));
    }
}
