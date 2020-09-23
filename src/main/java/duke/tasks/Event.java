package duke.tasks;

import duke.DukeException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Create an Event task.
 */
public class Event extends Task {
    private String time;

    /**
     * This constructor creates an event.
     *
     * @param description This is the description of the task.
     * @param at This is the deadline of the task.
     * @throws DukeException If the date / time format is wrong.
     */
    public Event(String description, String at) throws DukeException {
        super(description);
        time = at.trim();
        if (description.trim().isEmpty()) {
            throw new DukeException("deadline");
        }
    }

    @Override
    public String toString() {
        return " [E]" + super.toString() + "(at: " + timeFormat() + ")";
    }

    private String timeFormat() {
        String newTimeFormat;
        LocalDateTime time = LocalDateTime
                .parse(this.time, DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm"));
        newTimeFormat = time.format(DateTimeFormatter
                .ofPattern("MMM d yyyy, h.mm a").withLocale(Locale.ENGLISH));
        return newTimeFormat;
    }
}
