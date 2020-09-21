package duke.commands;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;

import java.time.format.DateTimeParseException;

public class AddEvent extends Command {
    private String[]  content;

    public AddEvent(String content) {
        this.content = content.split("/at",2);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        try {
            tasks.addEvent(content[0], content[1]);
            ui.showAdded(tasks.getTask(), tasks.getSize());
            storage.addFileContent("E", content[0], content[1]);
        } catch (DateTimeParseException e) {
            ui.showError("please enter in yyyy-mm-dd and HHmm format\n");
        }
    }

    public boolean isExit() {
        return false;
    }
}
