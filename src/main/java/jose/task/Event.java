package jose.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import jose.DukeException;

/**
 * A class representing an event task.
 */
public class Event extends Task {
    protected LocalDateTime at;

    /**
     * Constructor that sets isDone to false.
     *
     * @param description Task description.
     * @param at Event timing.
     * @throws DukeException If date and time are in the wrong format.
     */
    public Event(String description, String at) throws DukeException {
        super(description);
        try {
            this.at = LocalDateTime.parse(at, DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm"));
        } catch (DateTimeParseException e) {
            throw new DukeException("Incorrecto date/time format. Use yyyy-MM-dd HHmm eg. 2022-12-31 2359");
        }
    }

    /**
     * Constructor that sets all variables.
     *
     * @param description Task description
     * @param isDone Task status.
     * @param at Event timing.
     * @param priority Task priority.
     */
    public Event(String description, boolean isDone, String at, Priority priority) {
        super(description, isDone, priority);
        this.at = LocalDateTime.parse(at);
    }

    /**
     * Returns a formatted representation of a task that will be saved to the data file.
     *
     * @return A formatted string to be saved to the data file.
     */
    public String formatData() {
        return "E|" + super.formatData() + "|" + at.toString();
    }

    /**
     * Returns a string representation of a task.
     *
     * @return A string representation of a task.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at.format(DateTimeFormatter.ofPattern("MMM dd yyyy, h:mma")) + ")";
    }
}
