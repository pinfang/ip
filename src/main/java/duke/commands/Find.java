package duke.commands;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

/**
 * Finds tasks that contains the keyword entered by the user.
 */
public class Find extends Command {
    private String content;

    public Find(String content) {
        this.content = content.trim();
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showFindResults(tasks.findTask(content));
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
