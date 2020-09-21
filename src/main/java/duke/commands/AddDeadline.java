package duke.commands;

import duke.*;

import java.time.format.DateTimeParseException;

public class AddDeadline extends Command {
    private String[]  content;

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
            ui.showError("please enter in yyyy-mm-dd and HHmm format\n");
        }
    }

    public boolean isExit() {
        return false;
    }
}
