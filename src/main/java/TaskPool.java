import java.util.ArrayList;
import java.util.List;

public class TaskPool {
    private final List<String> tasks = new ArrayList<>();
    private final List<Boolean> isDone = new ArrayList<>();

    public void addTask(String task) {
        tasks.add(task);
        isDone.add(false);
    }

    /**
     * Marks a task as done.
     * @param taskNumber the task number as shown in the list command, starting from 1.
     */
    public void markDone(int taskNumber) {
        isDone.set(taskNumber - 1, true);
    }

    /**
     * Marks a task as undone.
     * @param taskNumber the task number as shown in the list command, starting from 1.
     */
    public void markUndone(int taskNumber) {
        isDone.set(taskNumber - 1, false);
    }
    public void printTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            if (isDone.get(i)) {
                System.out.println("  " + (i + 1) + ". [X] " + tasks.get(i));
            } else {
                System.out.println("  " + (i + 1) + ". [ ] " + tasks.get(i));
            }
        }
    }
}
