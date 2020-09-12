package duke;

import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.Task;
import duke.tasks.Todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

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

    public static void readFile(List<Task> taskList) {
        File file = new File(fileName);

        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNext()) {
                String content = scan.nextLine();
                String[] taskTypes = content.split(" \\| ", 3);

                switch (taskTypes[0]) {
                case "T":
                    Task t = new Todo(taskTypes[2]);
                    if (taskTypes[1].equals("\u2713")) {
                        t.isDone = true;
                    }
                    taskList.add(t);
                    break;
                case "D":
                    String[] message = taskTypes[2].split("\\|", 2);
                    Task d = new Deadline(message[0], message[1]);
                    if (taskTypes[1].equals("\u2713")) {
                        d.isDone = true;
                    }
                    taskList.add(d);
                    break;
                case "E":
                    message = taskTypes[2].split("\\|", 2);
                    Task e = new Event(message[0], message[1]);
                    if (taskTypes[1].equals("\u2713")) {
                        e.isDone = true;
                    }
                    taskList.add(e);
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void writeFile(String content) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        fw.write(content + System.lineSeparator());
        fw.close();
    }

    private static void appendFile(String content) throws IOException {
        FileWriter fw = new FileWriter(fileName, true);
        fw.write(content + System.lineSeparator());
        fw.close();
    }

    public static void addFileContent(String taskType, String detail) {
        try {
            appendFile(taskType + " | " + "\u2718" + " | " + detail);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void addFileContent(String taskType, String detail, String time) {
        try {
            appendFile(taskType + " | " + "\u2718" + " | " + detail + "|" + time);
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
