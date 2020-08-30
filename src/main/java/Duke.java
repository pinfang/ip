import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Duke {
    public static void greet() {
        System.out.println("_________________________________________");
        System.out.println("Hello! I'm Duke");
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
        for (int i = 1; i <= list.size(); i++) {
            System.out.println(i + "." + list.get(i-1));
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
        System.out.println("_________________________________________");
        System.out.println("Nice! I've marked this task as done: ");
        System.out.println(" " + "[" + list.get(index).getStatusIcon()
                + "] " + list.get(index).description);
        System.out.println("_________________________________________");
    }

    public static void main(String[] args) {
        greet();

        Scanner scan = new Scanner(System.in);
        List<Task> list = new ArrayList<>();

        while (scan.hasNext()) {
            String command = scan.nextLine();

            if (command.equals("bye")) {
                exit();
                break;
            } else if (command.equals("list")) {
                printList(list);
            } else if (command.matches("done\\s\\d*")) {
                command = command.substring(5);
                int index = Integer.parseInt(command) - 1;
                list.get(index).isDone = true;
                done(index, list);
            } else if (command.matches("todo\\s.*")) {
                command = command.substring(5);
                Task todo = new ToDo(command);
                addTask(todo, list);
            } else if(command.matches("deadline\\s.*")) {
                command = command.substring(9);
                String[] arr = command.split("/by",2);
                command = arr[0] + " (by:" + arr[1] + ")";
                Task deadline = new Deadline(command);
                addTask(deadline, list);
            } else if (command.matches("event\\s.*")) {
                command = command.substring(6);
                String[] arr = command.split("/at",2);
                command = arr[0] + " (at:" + arr[1] + ")";
                Task event = new Event(command);
                addTask(event, list);
            } else {
//                Task t = new Task(command);
//                addTask(t, list);
                System.out.println("_________________________________________\n"
                        + "No such command!\n"
                        + "_________________________________________");
            }
        }
    }
}