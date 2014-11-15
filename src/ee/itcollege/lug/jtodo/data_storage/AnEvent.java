package ee.itcollege.lug.jtodo.data_storage;

public class AnEvent extends Deadline {

    /**
     * Time represented in format "hh:mm" 24 hour time
     */
    protected String time;

    /**
     * Constructor for an event, specifies when it takes place
     *
     * @param d a date in the format "dd.mm.yy"
     * @param t a time in the format "hh.mm"
     * @param n a Name for the event
     */

    public AnEvent(String n, String t, String d) {
        super(n, d);
        time = t;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return name + "|" + time + "|" + date + "|\n";
    }
}
