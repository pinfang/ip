package duke;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class DukeFile {
    String filePath = "data/duke.txt";

    public void createFile() {
        // Path filePath = Paths.get(".", "data", "duke.txt");
        boolean directoryExists = new File(filePath).exists();

        if (directoryExists) {

        } else {

        }
    }

    public void writeFile(String task) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        fw.write(task);
        fw.close();
    }

    public void readFile() throws FileNotFoundException {
        
    }
}
