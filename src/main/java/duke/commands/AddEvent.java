package duke.commands;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

public class AddEvent extends Command {
    private String[]  content;

    public AddEvent(String content) {
        this.content = content.split("/at",2);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.addEvent(content[0], content[1]);
        ui.showAdded(tasks.getTask(), tasks.getSize());
        storage.addFileContent("E", content[0], content[1]);
    }

    public boolean isExit() {
        return false;
    }
}
