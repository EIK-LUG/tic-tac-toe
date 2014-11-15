package ee.itcollege.lug.jtodo.UI;



import ee.itcollege.lug.jtodo.data_storage.AnEvent;
import ee.itcollege.lug.jtodo.data_storage.Deadline;
import ee.itcollege.lug.jtodo.data_storage.FileConnector;
import ee.itcollege.lug.jtodo.interfaces.DisplayInterface;
import ee.itcollege.lug.jtodo.interfaces.EditInterface;

import java.util.ArrayList;
import java.util.Scanner;

public class TextBased implements DisplayInterface, EditInterface {
    /**
     * {@inheritDoc}
     */
    public void greetUser() {
        try {
            System.out.print("\n\n\n\n\n           Welcome to jToDo!\n          ");
            for (int i = 0; i < 19; i++) {
                Thread.sleep(50);
                System.out.print('.');
            }
        } catch (InterruptedException e) {
        }
        System.out.println("\n\n\n\n\n\n\n");
    }

    /**
     * This is essentially the screen
     */
    ArrayList<String> screen = new ArrayList<String>();

    /**
     * Deals with data transfer
     */
    FileConnector fileCon = new FileConnector();

    /**
     * This is the main user interface for the text based version.
     * <p>
     * The output is essentially an ArrayList of Strings printed element by element on new lines.
     * There is a certain list of commands that can be entered to choose what to do in the program.
     * A command is composed of a 'what to do' statement and a 'what to do it to'.
     * ex: -v all (View all), -r event (Remove an event)
     * </p>
     * <p>
     * There are 8 constant lines (Instructions + 1 line heading).
     * </p>
     */
    public void displayMain() {
        greetUser();
        //Entry of constant menu items begins..
        screen.add("\n               jToDo\n\n");
        screen.add("Commands   : -v : view, -a : add, -r : remove\n\n");
        screen.add("Parameters : all, deadline, event\n\n");
        screen.add("Example    : \'-v all\' to view all.\n\n");
        screen.add("Quit: -q\n\n");
        //And ends.
        // The Scanner.next method will supply both the command and parameter string
        Scanner input = new Scanner(System.in);
        String command;
        String param;
        while (true) {
            //Constant screen is printed
            for (String l : screen) {
                System.out.print(l);
            }
            System.out.print("$: ");
            command = input.next().toLowerCase();
            if(command.equals("-q")) {
                break;
            }
            param = input.next().toLowerCase();
            //If view command entered
            if (command.equals("-v")) {
                if (param.equals("all")) {
                    displayAll(fileCon.getAllData());
                }
                else if (param.equals("deadline")) {
                    displayDeadlines(fileCon.getDeadlines());
                }
                else if (param.equals("event")) {
                    displayEvents(fileCon.getEvents());
                }
                else try {
                        System.out.println("Invalid input!");
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                    }
            }
            //If add command used
            else if (command.equals("-a")) {
                if (param.equals("deadline")) {
                    fileCon.storeData(addNewDeadline());
                }
                else if (param.equals("event")) {
                    fileCon.storeData(addNewEvent());
                }
                else try {
                        System.out.println("Invalid input!");
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                    }
            }
            //If remove command used
            else if (command.equals("-r")) {
                if (param.equals("all")) {
                    fileCon.removeAll();
                }
                else if (param.equals("deadline")) {
                    removeDeadline();
                }
                else if (param.equals("event")) {
                    removeEvent();
                }
                else try {
                        System.out.println("Invalid input!");
                        Thread.sleep(750);
                    } catch (InterruptedException e) {
                }
            }
            else try {
                System.out.println("Invalid input!");
                Thread.sleep(750);
            } catch (InterruptedException e) {
            }
        }
        System.out.println("Have a good day!");
    }

    public void displayAll(ArrayList[] data) {
        ArrayList<Deadline> deadlines = data[0];
        ArrayList<AnEvent> events = data[1];

        System.out.println("Upcoming Events: \n");
        for (Deadline occ : events) {
            System.out.println(occ);
        }

        System.out.println("Upcoming Deadlines: \n");
        for (Deadline occ : deadlines) {
            System.out.println(occ);
        }
        System.out.print("Done viewing? (y)");
        while(!new Scanner(System.in).next().equals("y")) {
            System.out.print("Done viewing? (y)");
        }
    }

    public void displayEvents(ArrayList<AnEvent> data) {
        System.out.println("Upcoming Events: \n");
        for (AnEvent ev: data) {
            System.out.println(ev);
        }
        System.out.print("Done viewing? (y)");
        while(!new Scanner(System.in).next().equals("y")) {
            System.out.print("Done viewing? (y)");
        }
    }

    public void displayDeadlines(ArrayList<Deadline> data) {
        System.out.println("Upcoming Deadlines: \n");
        for (Deadline dl: data) {
            System.out.println(dl);
        }
        System.out.print("Done viewing? (y)");
        while(!new Scanner(System.in).next().equals("y")) {
            System.out.print("Done viewing? (y)");
        }
    }

    /**
     * Ask user to input information for the creation of a Deadline object
     *
     * @return a new Deadline object
     */
    public Deadline addNewDeadline() {
        String name;
        String date;

        System.out.print("Enter a name for a deadline: ");
        name = new Scanner(System.in).next();
        System.out.print("Enter a date (ex. 12.31.13): ");
        date = new Scanner(System.in).next();
        //ToDo Figure out a failsafe
        if(date.length() != 8) {
            return addNewDeadline();
        }
        return new Deadline(name, date);
    }

    /**
     * Ask user to input information for the creation of an AnEvent object
     *
     * @return a new AnEvent object
     */
    public AnEvent addNewEvent() {
        String name;
        String time;
        String date;
        //ToDo add a cancel possibility
        System.out.println("-Event creation-");
        System.out.print("Enter a name for the event : ");
        name = new Scanner(System.in).next();
        System.out.print("Enter a time (ex. 24:60)   : ");
        time = new Scanner(System.in).next();
        System.out.print("Enter a date (ex. 12.31.13): ");
        date = new Scanner(System.in).next();
        //ToDo Figure out a failsafe
        if(date.length() != 8 || time.length() != 5) {
            return addNewEvent();
        }
        return new AnEvent(name, time, date);
    }

    /**
     * This method asks the user to enter a String that should be the name of a Deadline object,
     * if it is found, will be removed.
     */
    public void removeDeadline() {
        String name;
        System.out.println("Enter the name of the deadline: ");
        name = new Scanner(System.in).next();
        fileCon.removeData(name, "deadline");
    }

    /**
     * This method asks the user to enter a String that should be the name of an AnEvent object,
     * if it is found, will be removed.
     */
    public void removeEvent() {
        String name;
        System.out.println("Enter the name of the event: ");
        name = new Scanner(System.in).next();
        fileCon.removeData(name, "event");
    }
}