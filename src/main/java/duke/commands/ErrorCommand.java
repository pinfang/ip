package duke.commands;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;

public class ErrorCommand extends Command {
    private String content;

    public ErrorCommand(String content) {
        this.content = content;
    }
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        throw new DukeException(content);
    }

    public boolean isExit() {
        return false;
    }
}
