package Jake;

import Jake.Execution.Executor;
import Jake.Execution.Parser;
import Jake.IOManagement.IOManager;
import Jake.TaskManagement.TaskPool;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jake {
    private static final TaskPool taskPool = new TaskPool();
    private static final Executor executor = new Executor(taskPool);
    private static final Ui ui = new Ui();

    public static void main(String[] args) {
        ui.printWelcomingMsg();
        IOManager.readTasksFromFile(taskPool);
        executor.readAndHandleInput();
        IOManager.writeTasksToFile(taskPool);
        ui.printByeMsg();
    }
}
