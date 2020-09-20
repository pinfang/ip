package duke.commands;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;

public class Find extends Command {
    private String content;

    public Find(String content) {
        this.content = content;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showFindResults(tasks.findTask(content));
    }
    public boolean isExit() {
        return false;
    }
}
