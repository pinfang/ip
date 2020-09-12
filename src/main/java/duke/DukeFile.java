package duke;

import duke.tasks.Task;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DukeFile {
    private static String filePath = "data";
    private static String fileName = "data/duke.txt";

    public static void createFile() {
        try {
            File directory = new File(filePath);
            boolean isDirectory = directory.mkdir();
            if (isDirectory) {
                System.out.println("directory is created");
            } else {
                System.out.println("directory exists");
            }

            File file = new File(fileName);
            boolean isCreated = file.createNewFile();
            if (isCreated) {
                System.out.println("file is created");
            } else {
                System.out.println("file exists");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void writeFile(String content) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        fw.write(content + System.lineSeparator());
        fw.close();
    }

    public static void appendFile(String content) throws IOException {
        FileWriter fw = new FileWriter(fileName, true);
        fw.write(content + System.lineSeparator());
        fw.close();
    }

    public static void addFileContent(int numOfTask, String taskType, String detail) {
        try {
            if (numOfTask == 1) {
                writeFile(taskType + " | " + "X" + " | " + detail);
            } else {
                appendFile(taskType + " | " + "X" + " | " + detail);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void addFileContent(int numOfTask, String taskType, String detail, String time) {
        try {
            if (numOfTask == 1) {
                writeFile(taskType + " | " + "X" + " | " + detail + "|" + time);
            } else {
                appendFile(taskType + " | " + "X" + " | " + detail + "|" + time);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void editFileContent(List<Task> tasks) {
        for (Task task: tasks) {
            String description = task.toString();
            String content = description.substring(8);
            char taskType = description.charAt(2);
            char taskStatus = description.charAt(5);
            if (content.contains("(by")) {
                content = content.replace("(by:", "|");
                content = content.substring(0, content.length() - 1);
            } else if (description.contains("(at")) {
                content = content.replace("(at:", "|");
                content = content.substring(0, content.length() - 1);
            }
            try {
                if (task == tasks.get(0)) {
                    writeFile(taskType + " | " + taskStatus + " | " + content);
                } else {
                    appendFile(taskType + " | " + taskStatus + " | " + content);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
