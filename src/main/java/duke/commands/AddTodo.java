package duke.commands;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

/**
 * Adds a todo.
 */
public class AddTodo extends Command {
    private String content;

    public AddTodo(String content) {
        this.content = content;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.addTodo(content);
        ui.showAdded(tasks.getTask(), tasks.getSize());
        storage.addFileContent("T", content);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
