package duke;

/**
 * Handles Exceptions.
 * E.g. wrong commands, missing description of tasks, no date / time for deadlines and event.
 */
public class DukeException extends Exception {
    private String command;
    private boolean hasTime;

    public DukeException(String command) {
        this.command = command;
        if (!command.contains("/at") || !command.contains("/by")) {
            hasTime = false;
        }
    }

    private String error() {
        return "☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n";
    }

    private String incompleteMessage() {
        return "☹ OOPS!!! The description of a " + command + " cannot be empty.\n";
    }

    private String noTimingDeadline() {
        return "☹ OOPS!!! Please specify a date and time (yyyy-MM-dd HHmm)\n";
    }

    private String noTimingEvent() {
        return "☹ OOPS!!! Please specify start and end time (yyyy-MM-dd HHmm to HHmm).\n";
    }

    @Override
    public String toString() {
        String message;
        if (command.equals("todo") || command.equals("done")
                || command.equals("deadline") || command.equals("event")) {
            message = incompleteMessage();
        } else if (command.startsWith("deadline")) {
            if (hasTime) {
                message = incompleteMessage();
            } else {
                message = noTimingDeadline();
            }
        } else if (command.startsWith("event")) {
            if (hasTime) {
                message = incompleteMessage();
            } else {
                message = noTimingEvent();
            }
        }

            else {
            message = error();
        }
        return message;
    }
}
