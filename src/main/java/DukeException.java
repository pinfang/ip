public class DukeException extends Exception {
    private String command;

    public DukeException(String command) {
        this.command = command;
    }

    public String error() {
        return "_________________________________________\n"
                + "☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n"
                + "_________________________________________\n";
    }

    public String inCompleteMessage() {
        return"_________________________________________\n"
                + "☹ OOPS!!! The description of a " + command + " cannot be empty.\n"
                + "_________________________________________\n";
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
