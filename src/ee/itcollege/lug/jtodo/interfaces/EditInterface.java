package ee.itcollege.lug.jtodo.interfaces;

import ee.itcollege.lug.jtodo.data_storage.AnEvent;
import ee.itcollege.lug.jtodo.data_storage.Deadline;

public interface EditInterface {

    /**
     * Brings up the UI with witch a new Deadline instance can be created
     * @return a Deadline instance
     */
    public Deadline addNewDeadline();

    /**
     * Brings up the UI with witch a new AnEvent instance can be created
     * @return a AnEvent instance
     */
    public AnEvent addNewEvent();

    /**
     * Bring up the UI with witch an existing Deadline instance can be removed
     */
    public void removeDeadline();

    /**
     * Brings up the UI with witch an existing AnEvent instance can be removed
     */
    public void removeEvent();
}
