package duke;

import duke.tasks.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class DukeFile {
    private static String filePath = "./data/duke.txt";

    public static void createFile() {
        try {
            File f = new File(filePath);
            boolean isCreated = f.createNewFile();

            if (isCreated) {
                System.out.println("file is created");
            } else {
                System.out.println("file is not created");
            }
        } catch (IOException e) {
            System.out.println("An exception has occurred");
        }
    }

    public static void writeFile(Task task) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        fw.write(task + System.lineSeparator());
        fw.close();
    }

    public void readFile() throws FileNotFoundException {
        
    }
}
