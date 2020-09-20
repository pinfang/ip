package duke.tasks;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Deadline extends Task {
    private String date = "";
    private String time = "";

    public Deadline(String description, String by) {
        super(description);
        String[] timings = by.trim().split("\\s");
        this.date = timings[0];
        this.time = timings[1];
    }

    @Override
    public String toString() {
        return " [D]" + super.toString() + "(by: " + date() + time() + ")";
    }

    private String date() {
        LocalDate date = LocalDate.parse(this.date.trim());
        String newDate = date.format(DateTimeFormatter
                .ofPattern("MMM d yyyy").withLocale(Locale.ENGLISH));
        return newDate;
    }

    private String time() {
        LocalTime time = LocalTime.parse(this.time.trim(), DateTimeFormatter.ofPattern("HHmm"));
        String newTime = time.format(DateTimeFormatter
                .ofPattern("h.mm a").withLocale(Locale.ENGLISH));
        return ", " + newTime;
    }
}
