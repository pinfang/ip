package duke;

import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.Task;
import duke.tasks.Todo;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> taskList;

    public TaskList() {
        taskList = new ArrayList<>();
    }

    public TaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public void addTodo(String task) {
        Task todo = new Todo(task);
        taskList.add(todo);
    }

    public void addDeadline(String task, String time) throws DukeException{
        Task deadline = new Deadline(task, time);
        taskList.add(deadline);
    }

    public void addEvent(String task, String time) throws DukeException {
        Task event = new Event(task, time);
        taskList.add(event);
    }

    public void done(int index) {
        taskList.get(index).isDone = true;
    }

    public void delete(int taskNumber) {
        taskList.remove(taskNumber);
    }

    public Task getTask() {
        return taskList.get(taskList.size() - 1);
    }

    public int getSize() {
        return taskList.size();
    }

    public List<Task> getTaskList() {
        return taskList;
    }
}
