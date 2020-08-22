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

    public static void printList(List<String> list) {
        System.out.println("_________________________________________");
        for (int i = 1; i <= list.size(); i++) {
            System.out.println(i + ". " + list.get(i-1));
        }
        System.out.println("_________________________________________");
    }

    public static void addTask() {
        Scanner scan = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        while (true) {
            String command = scan.nextLine();
            if (command.equals("bye")) {
                exit();
                break;
            } else if (command.equals("list")) {
                printList(list);
            } else {
                list.add(command);
                System.out.println("_________________________________________");
                System.out.println("added: " + command);
                System.out.println("_________________________________________");
            }
        }
    }

    public static void main(String[] args) {
        greet();
        addTask();
    }
}
