package ee.itcollege.lug.jtodo.data_storage;

public class Deadline {
    /**
     * A String representation of a date, format "dd.mm.yy"
     */
    protected String date;
    /**
     * Name of object, no new line characters
     */
    protected String name;

    /**
     * Constructor for a deadline, specifies the day of the deadline and a name
     *
     * @param d a date, in format "dd.mm.yy"
     * @param n a Name for the event
     */

    public Deadline(String n, String d) {
        name = n;
        date = d;
    }

    /**
     * Override toString()
     * <p>
     * Calling this method will return the parameters used in the instances
     * constructor.
     * </p>
     *
     * @return instance constructor parameters separated by whitespace.
     */
    @Override
    public String toString() {
        return name + '|' + date + "|\n";
    }
}
