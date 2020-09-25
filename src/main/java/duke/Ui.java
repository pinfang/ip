package duke;

import duke.tasks.Task;

import java.util.List;
import java.util.Scanner;

import static duke.Messages.*;

/**
 * Deals with interactions with the user
 */
public class Ui {

    public Ui() {
    }

    /**
     * This method is to show welcome message by duke.
     */
    public void showWelcome() {
        System.out.print(DIVIDER_LINE + WELCOME + DIVIDER_LINE);
    }

    /**
     * This method is to show exit message by duke.
     */
    public void showExit() {
        System.out.print(DIVIDER_LINE + BYE + DIVIDER_LINE);
    }

    /**
     * This method is to read the user command.
     * @return This returns a string of command entered by the user.
     */
    public String readCommand() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine().trim();
    }

    /**
     * This method is to show a message that a task is added successfully.
     * It also shows the updates of the new number of tasks in the task list.
     * @param t This is the task that is added.
     * @param numberOfTasks This is the total number of tasks in the task list after added.
     */
    public void showAdded(Task t, int numberOfTasks) {
        System.out.println(DIVIDER_LINE + ADD + " " + t);
        System.out.printf("Now you have %d tasks in the list.\n", numberOfTasks);
        System.out.print(DIVIDER_LINE);
    }

    /**
     * This method shows each description of the task in the task list.
     * @param taskList This is the list of tasks that is to be shown.
     */
    public void showTaskList(List<Task> taskList) {
        System.out.print(DIVIDER_LINE + LIST_TASK);
        for (int i = 1; i <= taskList.size(); i++) {
            System.out.println(i + "." + taskList.get(i - 1));
        }
        System.out.print(DIVIDER_LINE);
    }

    /**
     * This shows a message that the task list is currently empty.
     */
    public void showEmptyList() {
        System.out.print(LIST_IS_EMPTY);
    }

    /**
     * This method shows a message that a task is marked as done.
     * @param t This is the task that is marked as done.
     */
    public void showDone(Task t) {
        System.out.print(DIVIDER_LINE + MARK_AS_DONE + " " + t + "\n" + DIVIDER_LINE);
    }

    /**
     * This method shows a message that a task is deleted successfully.
     * It also updates the number of tasks currently in the task list.
     * @param t This is the task that is deleted.
     * @param numberOfTasks This is the new number of tasks in the task list.
     */
    public void showDeleted(Task t, int numberOfTasks) {
        System.out.println(DIVIDER_LINE + DELETE_TASK + " " + t);
        System.out.printf("Now you have %d tasks in the list.\n", numberOfTasks);
        System.out.print(DIVIDER_LINE);
    }

    /**
     * This method shows a list of tasks that matches the user's search.
     * @param results This is the list of searched results.
     */
    public void showFindResults(List<Task> results) {
        System.out.print(DIVIDER_LINE + FINDING_RESULTS);
        for (int i = 1; i <= results.size(); i++) {
            System.out.println(i + "." + results.get(i - 1));
        }
        System.out.print(DIVIDER_LINE);
    }

    /**
     * This method shows a error message when the user enter the wrong command.
     * @param errorMessage This is the message that is to be shown.
     */
    public void showError(String errorMessage) {
        System.out.print(errorMessage);
        System.out.print(TRY_AGAIN);
    }

    /**
     * This method shows an error when the file could not be loaded.
     */
    public void showLoadingError() {
        System.out.print(LOADING_ERROR);
    }
}
