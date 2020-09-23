package duke.commands;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

/**
 * Marks a task as done.
 */
public class DoneTask extends Command {
    private int index;

    public DoneTask(String index) {
        this.index = Integer.parseInt(index) - 1;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        if (index > tasks.getSize() - 1) {
            ui.showError("No such task.\n");
        } else {
            tasks.done(index);
            ui.showDone(tasks.getTaskList().get(index));
            storage.editFileContent(tasks.getTaskList());
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
