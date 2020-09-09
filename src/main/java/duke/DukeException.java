package duke;

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

    private String inCompleteMessage() {
        return "☹ OOPS!!! The description of a " + command + " cannot be empty.\n";
    }

    private String noTiming() {
        return "☹ OOPS!!! Please specify a time / date.\n";
    }

    public String toString() {
        String message;
        if (command.equals("todo") || command.equals("done")) {
            message = inCompleteMessage();
        } else if (command.startsWith("deadline") || command.startsWith("event")) {
            if (hasTime) {
                message = inCompleteMessage();
            } else {
                message = noTiming();
            }
        } else {
            message = error();
        }
        return message;
    }
}
