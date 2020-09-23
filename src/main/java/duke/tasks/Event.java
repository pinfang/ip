package duke.tasks;

import duke.DukeException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Create an Event task.
 */
public class Event extends Task {
    private String date;
    private String time;

    /**
     * This constructor creates an event.
     * @param description This is the description of the task.
     * @param at This is the deadline of the task.
     * @throws DukeException If the date / time format is wrong.
     */
    public Event(String description, String at) throws DukeException {
        super(description);
        at = at.trim();
        if (at.matches("(.*)\\s(.*)")) {
            String[] timings = at.split("\\s", 2);
            this.date = timings[0];
            this.time = timings[1];
        } else {
            throw new DukeException("event");
        }
    }

    @Override
    public String toString() {
        return " [E]" + super.toString() + "(at: " + date() + time() + ")";
    }

    private String date() {
        String newDate;
        LocalDate date = LocalDate.parse(this.date);
        newDate = date.format(DateTimeFormatter
                .ofPattern("MMM d yyyy").withLocale(Locale.ENGLISH));
        return newDate;
    }

    private String time() {
        String newTime;
        LocalTime time = LocalTime
                .parse(this.time, DateTimeFormatter.ofPattern("HHmm"));
        newTime = time.format(DateTimeFormatter
                .ofPattern("h.mm a").withLocale(Locale.ENGLISH));
        return ", " + newTime;
    }
}
