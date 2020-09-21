package duke.commands;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

public class Exit extends Command {
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showExit();
    }

    public boolean isExit() {
        return true;
    }
}
