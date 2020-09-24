package duke;

import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.Task;
import duke.tasks.Todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Deals with loading tasks from the file and saving tasks in the file.
 * The main operations are read file, append file and edit file.
 */
public class Storage {
    private static String fileName = "data/tasks.txt";

    /**
     * This constructor will create a new file path is the path does not exist.
     * @param filePath This is the file directory that will be created.
     */
    public Storage(String filePath) {
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

    /**
     * This method is to write new contents to the file.
     * @param content This is the content that will be written.
     * @throws IOException If the writing of file content fails.
     */
    private void writeFile(String content) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        fw.write(content + System.lineSeparator());
        fw.close();
    }

    /**
     * This method is to append file content.
     * @param content This is the content added to the file.
     * @throws IOException If the appending of file content fails.
     */
    private void appendFile(String content) throws IOException {
        FileWriter fw = new FileWriter(fileName, true);
        fw.write(content + System.lineSeparator());
        fw.close();
    }

    /**
     * This method is to add a todo task to the file.
     * @param taskType This is the type of the task added.
     * @param detail This is the description of the task.
     */
    public void addFileContent(String taskType, String detail) {
        try {
            appendFile(taskType + " | " + "\u2718" + " | " + detail);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * This method is to add a deadline / event to the file.
     * @param taskType This is the type of task added.
     * @param detail This is the description of the task.
     * @param time This is the deadline / event date of the task.
     */
    public void addFileContent(String taskType, String detail, String time) {
        try {
            appendFile(taskType + " | " + "\u2718" + " | " + detail + "|" + time);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * This method will load the file content when the program starts.
     * @return This returns a list of tasks that was saved in the file.
     * @throws DukeException If file fails to load.
     */
    public List<Task> load() throws DukeException {
        File file = new File(fileName);
        List<Task> taskList = new ArrayList<>();

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
                default:
                    throw new DukeException("loading error");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return taskList;
    }

    /**
     * This method will edit the current file content when a task is marked as done or deleted.
     * @param tasks This is the list of the updated tasks that is to be saved in the file.
     */
    public void editFileContent(List<Task> tasks) {
        for (Task task: tasks) {
            String description = task.toString();
            String content = description.substring(8);
            char taskType = description.charAt(2);
            char taskStatus = description.charAt(5);

            if (description.contains("(by")) {
                content = content.substring(0, content.length() - 1);
                String[] dateTimes = content.split("\\(by:\\s", 2);
                LocalDateTime time = LocalDateTime.parse(dateTimes[1], DateTimeFormatter
                        .ofPattern("MMM d yyyy, h.mm a").withLocale(Locale.ENGLISH));
                dateTimes[1] = time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm"));
                content = dateTimes[0] + "| " + dateTimes[1];
            } else if (description.contains("(at")) {
                content = content.substring(0, content.length() - 1);
                String[] dateTimes = content.split("\\(at:\\s", 2);
                String[] fromTo = dateTimes[1].split("\\sto\\s", 2);

                LocalDateTime from = LocalDateTime.parse(fromTo[0], DateTimeFormatter
                        .ofPattern("MMM d yyyy, h.mm a").withLocale(Locale.ENGLISH));
                fromTo[0] = from.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm"));

                LocalTime to = LocalTime.parse(fromTo[1], DateTimeFormatter
                        .ofPattern("h.mm a").withLocale(Locale.ENGLISH));
                fromTo[1] = to.format(DateTimeFormatter.ofPattern("HHmm"));

                dateTimes[1] = fromTo[0] + " to " + fromTo[1];
                content = dateTimes[0] + "| " + dateTimes[1];
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
