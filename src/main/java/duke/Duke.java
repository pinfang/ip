package duke;

import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.Task;
import duke.tasks.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Duke {
    public static void greet() {
        System.out.println("_________________________________________");
        System.out.println("Hello! I'm duke.Duke");
        System.out.println("What can I do for you?");
        System.out.println("_________________________________________");
    }

    public static void exit() {
        System.out.println("_________________________________________");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("_________________________________________");
    }

    public static void printList(List<Task> list) {
        System.out.println("_________________________________________");
        if (list.size() > 0) {
            System.out.println("Here are the tasks in your list:");
            for (int i = 1; i <= list.size(); i++) {
                System.out.println(i + "." + list.get(i - 1));
            }
        } else {
            System.out.println("You have no task in the list.");
        }
        System.out.println("_________________________________________");
    }

    public static void addTask(Task t, List<Task> list) {
        list.add(t);
        System.out.println("_________________________________________");
        System.out.println("Got it. I've added this task:");
        System.out.println(" " + t);
        System.out.printf("Now you have %d tasks in the list.\n", list.size());
        System.out.println("_________________________________________");
    }

    public static void done(int index, List<Task> list) {
        if (index > list.size() - 1) {
            System.out.println("No such task!");
        } else {
            list.get(index).isDone = true;
            System.out.println("_________________________________________");
            System.out.println("Nice! I've marked this task as done:");
            System.out.println(" " + list.get(index));
            System.out.println("_________________________________________");
        }
        DukeFile.editFileContent(list);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Task> taskList = new ArrayList<>();

        greet();
        DukeFile.createFile();

        while (scan.hasNext()) {
            String command = scan.nextLine();
            command = command.trim();

            if (command.equals("bye")) {
                exit();
                break;
            } else if (command.equals("list")) {
                printList(taskList);
            } else if (command.matches("done\\s\\d*")) {
                command = command.substring(5);
                int index = Integer.parseInt(command) - 1;
                done(index, taskList);
            } else if (command.matches("todo\\s.*")) {
                command = command.substring(5);
                Task todo = new Todo(command);
                addTask(todo, taskList);
                DukeFile.addFileContent(taskList.size(),"T", command);
            } else if(command.matches("deadline\\s(.*)/by(.*)")) {
                command = command.substring(9);
                String[] commandWords = command.split("/by",2);
                Task deadline = new Deadline(commandWords[0], commandWords[1]);
                addTask(deadline, taskList);
                DukeFile.addFileContent(taskList.size(), "D", commandWords[0], commandWords[1]);
            } else if (command.matches("event\\s(.*)/at(.*)")) {
                command = command.substring(6);
                String[] commandWords = command.split("/at",2);
                Task event = new Event(commandWords[0], commandWords[1]);
                addTask(event, taskList);
                DukeFile.addFileContent(taskList.size(), "E", commandWords[0], commandWords[1]);
            } else {
                try {
                    throw new DukeException(command);
                } catch (DukeException error) {
                    System.out.print(error.toString());
                } finally {
                    System.out.println("Please enter your task again.");
                }
            }
        }
    }
}