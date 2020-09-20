package duke.commands;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

public class PrintList extends Command {
    public PrintList() {

    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        if (tasks.getSize() > 0) {
            ui.showTaskList(tasks.getTaskList());
        } else {
            ui.showEmptyList();
        }
    }

    public boolean isExit() {
        return false;
    }
}
