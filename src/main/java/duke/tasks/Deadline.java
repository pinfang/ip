package duke.tasks;

import duke.DukeException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Creates a Deadline task.
 */
public class Deadline extends Task {
    private String time;
    private String newTimeFormat;

    /**
     * This constructor creates a deadline.
     *
     * @param description This is the description of the task.
     * @param by This is the deadline of the task.
     * @throws DukeException If the date / time format is wrong.
     */
    public Deadline(String description, String by) throws DukeException {
        super(description);
        this.time = by.trim();
        if (description.trim().isEmpty()) {
            throw new DukeException("deadline");
        }
        timeFormat();
    }

    @Override
    public String toString() {
        return " [D]" + super.toString() + "(by: " + newTimeFormat + ")";
    }

    private void timeFormat() {
        LocalDateTime time = LocalDateTime
                .parse(this.time, DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm"));
        newTimeFormat = time.format(DateTimeFormatter
                .ofPattern("MMM d yyyy, h.mm a").withLocale(Locale.ENGLISH));
    }
}