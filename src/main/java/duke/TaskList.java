package duke;

import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.Task;
import duke.tasks.Todo;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains the task list.
 * It has the operations to add/delete/find tasks.
 * It can show the size of the task list or the last task in the list
 */
public class TaskList {
    private List<Task> taskList;

    public TaskList() {
        taskList = new ArrayList<>();
    }

    /**
     * This constructor will load the task list that was stored in the task.txt.
     * It will create a new task list from the task.txt.
     * @param taskList This is the parameter that contains the task list stored in the task.txt
     */
    public TaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    /**
     * This method will add a todo task into the task list.
     * @param task This is the description of the task added.
     */
    public void addTodo(String task) {
        Task todo = new Todo(task);
        taskList.add(todo);
    }

    /**
     * This method will add a deadline task into the task list.
     * @param task This is the description of the task.
     * @param time This is the deadline of the task.
     * @throws DukeException If the format of the deadline task is wrong.
     */
    public void addDeadline(String task, String time) throws DukeException {
        Task deadline = new Deadline(task, time);
        taskList.add(deadline);
    }

    /**
     * This method will add a event task into the task list.
     * @param task This is the description of the task.
     * @param time This is the date / time of the event.
     * @throws DukeException If the format of the event task is wrong.
     */
    public void addEvent(String task, String time) throws DukeException {
        Task event = new Event(task, time);
        taskList.add(event);
    }

    /**
     * This method will mark the task as done
     * @param index This is the index of the task that should be marked as done.
     */
    public void done(int index) {
        taskList.get(index).isDone = true;
    }

    /**
     * This method will delete a task from the task list.
     * @param taskNumber This is the index of the task that should be deleted.
     */
    public void delete(int taskNumber) {
        taskList.remove(taskNumber);
    }

    /**
     * This method gives users a way to find a task by searching for a keyword.
     * @param keyword This is the keyword to be searched.
     * @return This returns a list of tasks that contains the keyword.
     */
    public List<Task> findTask(String keyword) {
        List<Task> resultList = new ArrayList<>();
        for (Task t: taskList) {
            if (t.toString().contains(keyword)) {
                resultList.add(t);
            }
        }
        return resultList;
    }

    /**
     * This method gets the latest task added into the task list.
     * @return This returns the last task in the list.
     */
    public Task getTask() {
        return taskList.get(taskList.size() - 1);
    }

    /**
     * This method gives the total number of tasks in the task list.
     * @return This returns the size of task list.
     */
    public int getSize() {
        return taskList.size();
    }

    /**
     * This method is to get the current task list.
     * @return This returns a task list.
     */
    public List<Task> getTaskList() {
        return taskList;
    }
}
