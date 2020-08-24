package main.java;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

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
            System.out.println(i + "." + "[" + list.get(i-1).getStatusIcon()
                    + "] " + list.get(i-1).description);
        }
        System.out.println("_________________________________________");
    }

    public static void done(int num, List<Task> list) {
        System.out.println("_________________________________________");
        System.out.println("Nice! I've marked this task as done: ");
        System.out.println(" " + "[" + list.get(num-1).getStatusIcon()
                + "] " + list.get(num-1).description);
        System.out.println("_________________________________________");
    }

    public static void main(String[] args) {
        greet();

        Scanner scan = new Scanner(System.in);
        List<Task> list = new ArrayList<>();

        while (true) {
            String command = scan.nextLine();
            if (command.equals("bye")) {
                exit();
                break;
            } else if (command.equals("list")) {
                printList(list);
            } else if (command.matches("done\\s(\\d*)")) {
                command = command.substring(5);
                int num = Integer.parseInt(command);
                list.get(num - 1).isDone = true;
                done(num, list);
            } else {
                Task t = new Task(command);
                list.add(t);

                System.out.println("_________________________________________");
                System.out.println("added: " + command);
                System.out.println("_________________________________________");
            }
        }
    }
}
