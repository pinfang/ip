package duke.tasks;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Event extends Task {
    private String date = "";
    private String time = "";

    public Event(String description, String at) {
        super(description);
        String[] timings = at.trim().split("\\s");
        date = timings[0];
        time = timings[1];
    }

    @Override
    public String toString() {
        return " [E]" + super.toString() + "(at:" + date() + time() + ")";
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
