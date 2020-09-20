package duke.commands;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

public class DeleteTask extends Command {
    private int index;

    public DeleteTask(String index) {
        this.index = Integer.parseInt(index) - 1;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        if (index > tasks.getSize() - 1) {
            ui.showError("No such task.\n");
        } else {
            ui.showDeleted(tasks.getTask(), tasks.getSize() - 1);
            tasks.delete(index);
            storage.editFileContent(tasks.getTaskList());
        }
    }

    public boolean isExit() {
        return false;
    }
}
