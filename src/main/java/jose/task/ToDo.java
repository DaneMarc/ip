package jose.task;

/**
 * A class representing the todo task.
 */
public class ToDo extends Task {
    /**
     * Constructor that sets isDone to false.
     *
     * @param description Task description.
     */
    public ToDo(String description) {
        super(description);
    }

    /**
     * Constructor that sets all variables.
     *
     * @param description Task description.
     * @param isDone Task status.
     * @param priority Task priority.
     */
    public ToDo(String description, boolean isDone, Priority priority) {
        super(description, isDone, priority);
    }

    /**
     * Returns a formatted representation of a task that will be saved to the data file.
     *
     * @return A formatted string to be saved to the data file.
     */
    public String formatData() {
        return "T|" + super.formatData();
    }

    /**
     * Returns a string representation of a task.
     *
     * @return A string representation of a task.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
