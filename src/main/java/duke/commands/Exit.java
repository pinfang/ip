package duke.commands;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

/**
 * Exits the program.
 */
public class Exit extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showExit();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
