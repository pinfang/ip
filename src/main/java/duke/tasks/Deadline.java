package duke.tasks;

import duke.DukeException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Creates a Deadline task.
 */
public class Deadline extends Task {
    private String date;
    private String time;

    /**
     * This constructor creates a deadline.
     * @param description This is the description of the task.
     * @param by This is the deadline of the task.
     * @throws DukeException If the date / time format is wrong.
     */
    public Deadline(String description, String by) throws DukeException {
        super(description);
        by = by.trim();
        if (by.matches("(.*)\\s(.*)")) {
            String[] timings = by.split("\\s", 2);
            this.date = timings[0];
            this.time = timings[1];
        } else {
            throw new DukeException("deadline");
        }
    }

    @Override
    public String toString() {
        return " [D]" + super.toString() + "(by: " + date() + time() + ")";
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
