package duke;

import duke.commands.*;

/**
 * Deals with making sense of the user command
 */
public class Parser {
    private static final String BYE = "bye";
    private static final String LIST = "list";
    private static final String DONE = "done\\s\\d*";
    private static final String FIND = "find\\s(.*)";
    private static final String DELETE = "delete\\s\\d*";
    private static final String TODO = "todo\\s.*";
    private static final String DEADLINE = "deadline\\s(.*)/by\\s(\\d{4}(-\\d{2}){2})\\s(\\d){4}";
    private static final String EVENT = "event\\s(.*)/at(.*)\\s(\\d{4}(-\\d{2}){2})\\s(\\d){4}\\sto\\s(\\d){4}";

    /**
     * This method is used to determine type of command that needs to be executed
     * @param command This is the parameter that contains user command
     * @return This returns the command that shall be executed
     */
    public static Command parse(String command) {
        if (command.matches(BYE)) {
            return new Exit();
        } else if (command.matches(LIST)) {
            return new PrintList();
        } else if (command.matches(DONE)) {
            return new DoneTask(command.substring(5));
        } else if (command.matches(DELETE)) {
            return new DeleteTask(command.substring(7));
        } else if (command.matches(FIND)) {
            return new Find(command.substring(5));
        } else if (command.matches(TODO)) {
            return new AddTodo(command.substring(5));
        } else if (command.matches(DEADLINE)) {
            return new AddDeadline(command.substring(9));
        } else if (command.matches(EVENT)) {
            return new AddEvent(command.substring(6));
        } else {
            return new ErrorCommand(command);
        }
    }
}
