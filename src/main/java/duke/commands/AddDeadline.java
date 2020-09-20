package duke.commands;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

public class AddDeadline extends Command {
    private String[]  content;

    public AddDeadline(String content) {
        this.content = content.split("/by",2);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.addDeadline(content[0], content[1]);
        ui.showAdded(tasks.getTask(), tasks.getSize());
        storage.addFileContent("D", content[0], content[1]);
    }

    public boolean isExit() {
        return false;
    }
}
