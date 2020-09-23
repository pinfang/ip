package duke.commands;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

/**
 * Prints out the task list.
 */
public class PrintList extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        if (tasks.getSize() > 0) {
            ui.showTaskList(tasks.getTaskList());
        } else {
            ui.showEmptyList();
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
