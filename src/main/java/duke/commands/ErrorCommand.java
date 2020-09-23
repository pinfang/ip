package duke.commands;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;

/**
 * Handles an error command.
 */
public class ErrorCommand extends Command {
    private String content;

    public ErrorCommand(String content) {
        this.content = content;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        throw new DukeException(content);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
