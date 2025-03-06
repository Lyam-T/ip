package Jake.IOManagement;

import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import Jake.TaskManagement.TaskPool;
import java.io.IOException;

public class IOManager {
    private static final String FILE_PATH = "./data/tasks.txt";
    private static final File file = new File(FILE_PATH);
    private final TaskPool taskPool;

    public IOManager(TaskPool taskPool) {
        this.taskPool = taskPool;
    }

    public void readTasksFromFile() {
        try {
            if (!file.exists()) {
                return;
            }

            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                taskPool.addTaskFromFileString(line.split("\\|"));
            }
            fileScanner.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading from file: " + e.getMessage());
        }
    }

    public void writeTasksToFile() {
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                boolean created = file.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(file);
            for (int i = 0; i < taskPool.getTaskCount(); i++) {
                fileWriter.write(taskPool.toFileString(i) + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file: " + e.getMessage());
        }
    }
}
