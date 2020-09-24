package duke.commands;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;

import java.time.format.DateTimeParseException;

/**
 * Adds an event.
 */
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
            // storage.addFileContent("E", content[0], content[1]);
        } catch (DateTimeParseException e) {
            ui.showError("please enter in \"yyyy-MM-dd HHmm to HHmm\" format\n");
        }
        storage.addFileContent("E", content[0], content[1]);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
