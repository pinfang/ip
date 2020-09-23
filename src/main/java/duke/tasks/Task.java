package duke.tasks;

/**
 * Creates a Task.
 */
public class Task {
    protected String description;
    public boolean isDone;

    public Task(String description) {
         this.description = description;
         this.isDone = false;
    }

    /**
     * This method shows the status of the task.
     * @return This returns tick or X symbols.
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    /**
     * This method shows the description of the task and the current status of the task.
     * @return This returns a string of the task description.
     */
    public String toString() {
        return "[" + getStatusIcon() + "] " + this.description;
    }
}
