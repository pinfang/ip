public class DukeException extends Exception {
    private String command;

    public DukeException(String command) {
        this.command = command;
    }

    private String error() {
        return "☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n";
    }

    private String inCompleteMessage() {
        return "☹ OOPS!!! The description of a " + command + " cannot be empty.\n";
    }

    public String toString() {
        String message;
        if (command.equals("todo") || command.equals("deadline")
                || command.equals("event") || command.equals("done")) {
            message = inCompleteMessage();
        } else {
            message = error();
        }
        return message;
    }
}
