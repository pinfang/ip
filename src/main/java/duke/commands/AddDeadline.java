package duke.commands;

import duke.*;

import java.time.format.DateTimeParseException;

/**
 * Adds a deadline.
 */
public class AddDeadline extends Command {
    private String[] content;

    public AddDeadline(String content) {
        this.content = content.split("/by",2);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        try {
            tasks.addDeadline(content[0], content[1]);
            ui.showAdded(tasks.getTask(), tasks.getSize());
            storage.addFileContent("D", content[0], content[1]);
        } catch (DateTimeParseException e) {
            ui.showError("please enter in correct \"yyyy-MM-dd HHmm\" format\n");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
