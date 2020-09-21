package duke;

import duke.tasks.Task;

import java.util.List;
import java.util.Scanner;

import static duke.Messages.*;

public class Ui {
    private Scanner scan;

    public Ui() {
    }

    public void showWelcome() {
        System.out.print(DIVIDER_LINE + WELCOME + DIVIDER_LINE);
    }

    public void showExit() {
        System.out.print(DIVIDER_LINE + BYE + DIVIDER_LINE);
    }

    public String readCommand() {
        scan = new Scanner(System.in);
        return scan.nextLine().trim();
    }

    public void showAdded(Task t, int numberOfTasks) {
        System.out.println(DIVIDER_LINE + ADD + " " + t);
        System.out.printf("Now you have %d tasks in the list.\n", numberOfTasks);
        System.out.print(DIVIDER_LINE);
    }

    public void showTaskList(List<Task> taskList) {
        System.out.print(DIVIDER_LINE + LIST_TASK);
        for (int i = 1; i <= taskList.size(); i++) {
            System.out.println(i + "." + taskList.get(i - 1));
        }
        System.out.print(DIVIDER_LINE);
    }

    public void showEmptyList() {
        System.out.print(LIST_IS_EMPTY);
    }

    public void showDone(Task t) {
        System.out.print(DIVIDER_LINE + MARK_AS_DONE + " " + t + "\n" + DIVIDER_LINE);
    }

    public void showDeleted(Task t, int numberOfTasks) {
        System.out.println(DIVIDER_LINE + DELETE_TASK + " " + t);
        System.out.printf("Now you have %d tasks in the list.\n", numberOfTasks);
        System.out.print(DIVIDER_LINE);
    }

    public void showFindResults(List<Task> results) {
        System.out.print(DIVIDER_LINE + FINDING_RESULTS);
        for (int i = 1; i <= results.size(); i++) {
            System.out.println(i + "." + results.get(i - 1));
        }
        System.out.print(DIVIDER_LINE);
    }

    public void showError(String errorMessage) {
        System.out.print(errorMessage);
        System.out.print(TRY_AGAIN);
    }

    public void showLoadingError() {
        System.out.print(LOADING_ERROR);
    }
}
