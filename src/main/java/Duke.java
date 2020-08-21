package main.java;
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

    public static void echo() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            String command = scan.nextLine();
            if (command.equals("bye")) {
                exit();
                break;
            } else {
                System.out.println("_________________________________________");
                System.out.println(command);
                System.out.println("_________________________________________");
            }
        }
    }

    public static void main(String[] args) {
        greet();
        echo();
    }
}
