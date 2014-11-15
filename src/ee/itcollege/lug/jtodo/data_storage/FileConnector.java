package ee.itcollege.lug.jtodo.data_storage;

import java.util.*;
import java.io.*;

public class FileConnector {

    /**
     * Only one FileConnector item allowed at once, if true, Constructor fails
     */
    private static boolean isOpen = false;
    /**
     * Path to the text file used as Deadline objects data storage
     */
    private String deadLPath;
    /**
     * Path to the text file used as AnEvent objects data storage
     */
    private String eventPath;

    /**
     * <p>
     * This is a small utility function. It takes in a longer String and splits it from the character splitter points
     * </p>
     *
     * @param word      A longer string, should contain 2-3 splitter characters
     * @param splitter  The character that designates a break point
     * @return          An array of Strings of length 3
     */
    public String[] nSplit(String word, char splitter) {
        String[] arr = new String[3];
        int oldIndx = 0;
        int indx = 0;
        int arrIndx = 0;

        for(char c : word.toCharArray()) {
            indx++;
            if (c == splitter) {
                arr[arrIndx] = word.substring(oldIndx, indx - 1);
                oldIndx = indx;
                arrIndx++;
            }
        }
        return arr;
    }

    /**
     * FileConnector constructor
     * <p>
     * Finds the path to both Event and Deadline data files.
     * Raises AssertionError if an instance of this class already exists.
     * </p>
     */
    public FileConnector() {
        try {
            assert (isOpen == false);
        } catch (AssertionError a) {
            System.out.println("Only one instance of FileConnector allowed!");
        }
        isOpen = true;
        //ToDo Search for files
        deadLPath = "/home/kristo/IdeaProjects/OOP/src/ee/itcollege/lug/jtodo/data_storage/DeadlineData";
        eventPath = "/home/kristo/IdeaProjects/OOP/src/ee/itcollege/lug/jtodo/data_storage/EventData";
    }

    /**
     * Write a String to a text file specified by path.
     * <p>
     * The String is a representation of either an AnEvent or Deadline object.
     * The String is in the format specified by {@link AnEvent)} and {@link Deadline} toString() methods.
     * Will be written on a new line.
     * </p>
     *
     * @param strRep the data representation
     * @param path   the path to a text file
     */
    private void writeToFile(String strRep, String path) {
        FileOutputStream fos = null;
        File file;

        try {
            //Get all current text into temp
            String temp = "";
            Scanner sc = new Scanner(new File(path));
            while(sc.hasNextLine()) {
                temp += sc.nextLine() + '\n';
            }
            sc.close();

            file = new File(path);
            fos = new FileOutputStream(file);

            //Todo new file creation
            // if file does not exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            // get the content in bytes
            temp = temp + strRep;
            byte[] contentInBytes = temp.getBytes();

            fos.write(contentInBytes);
            fos.flush();
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Remove a line with the specified String in it from a text file specified by path.
     * <p>
     * The name of either an AnEvent or Deadline object.
     * The data is actually stored in a temporary storage, all except for the specified line and then
     * rewritten to the same file
     * </p>
     *
     * @param name  the name of an AnEvent or Deadline object
     * @param path  the path to a text file
     */
    private void removeFromFile(String name, String path) {
        String temp = "";
        String line;
        boolean found = false;

        try {

            Scanner reader = new Scanner(new File(path));
            // Store all data except specified line in temp
            while (reader.hasNextLine()) {
                line = reader.nextLine();
                // If the name line does not contain the name, it is appended with a newline character
                if (!line.contains(name)) {
                    temp += line + "\n";
                } else {
                    //If it is found at all
                    found = true;
                }
            }
            reader.close();

            //Empty out file beforehand
            try {
                PrintWriter writer = new PrintWriter(new File(path));
                writer.print("");
                writer.close();
            } catch(FileNotFoundException e) {
                System.out.println("File not found!");
            }

            writeToFile(temp, path);

            if(!found) {
                System.out.println("Such an item does not exist!");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method creates Event objects based on the information in
     * the text file located at {@link #eventPath}.
     *
     * @return an ArrayList of Event objects
     */
    public ArrayList<AnEvent> getEvents() {
        ArrayList<AnEvent> events = new ArrayList<AnEvent>();
        //An AnEvent object takes three arguments, they will be collected in here
        String[] parameters = new String[3];
        try {

            Scanner reader = new Scanner(new File(eventPath));

            while (reader.hasNextLine()) {
                parameters = nSplit(reader.nextLine(), '|');
                events.add(new AnEvent(parameters[0], parameters[1], parameters[2]));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return events;
    }

    /**
     * This method creates Deadline objects based on the information in
     * the text file located at {@link #deadLPath}
     *
     * @return an ArrayList of Deadline objects
     */
    public ArrayList<Deadline> getDeadlines() {
        ArrayList<Deadline> deadlines = new ArrayList<Deadline>();
        //A Deadline object takes two arguments, they will be collected in here
        String[] parameters = new String[3];

        try {

            Scanner reader = new Scanner(new File(deadLPath));

            while (reader.hasNextLine()) {
                parameters = nSplit(reader.nextLine(), '|');
                deadlines.add(new Deadline(parameters[0], parameters[1]));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return deadlines;
    }

    /**
     * Writes a representation of a Deadline or AnEvent object to deadLPath or eventPath respectively
     * <p>
     * The format of the data reflects Deadline or AnEvent class constructor arguments separated
     * by whitespaces and arranged in order of the constructor arguments.
     * </p>
     *
     * @param someOccasion a Deadline or Event object
     */
    public void storeData(AnEvent someOccasion) {
        String path;
        String stringRep;
        //ToDo Inheritance?
        if (someOccasion.getClass() == AnEvent.class) {
            stringRep = someOccasion.toString();
            path = eventPath;
        } else {
            stringRep = someOccasion.toString();
            path = deadLPath;
        }
        writeToFile(stringRep, path);
    }

    /**
     * Writes a representation of a Deadline or AnEvent object to deadLPath or eventPath respectively
     * <p>
     * The format of the data reflects Deadline or AnEvent class constructor arguments separated
     * by whitespaces and arranged in order of the constructor arguments.
     * </p>
     *
     * @param someOccasion a Deadline or Event object
     */
    public void storeData(Deadline someOccasion) {
        String path;
        String stringRep;
        //ToDo Inheritance?
        if (someOccasion.getClass() == AnEvent.class) {
            stringRep = someOccasion.toString();
            path = eventPath;
        } else {
            stringRep = someOccasion.toString();
            path = deadLPath;
        }
        writeToFile(stringRep, path);
    }

    /**
     * This method gets all the Data that is represented in both {@link #deadLPath} and
     * {@link #eventPath} files.
     * <p>
     * The data in the files is used to create objects and add them
     * to an ArrayList. These lists are both returned in an array of length 2.
     * </p>
     *
     * @return an array of length 2 that contains ArrayLists, first element is Deadlines and second Events.
     */
    public ArrayList[] getAllData() {
        ArrayList[] data = new ArrayList[2];
        data[0] = getDeadlines();
        data[1] = getEvents();
        return data;
    }

    /**
     * This method removes an AnEvent or Deadline from data storage
     * <p>
     * If such a name is not found in data storage,
     * issues a warning and does nothing.
     * </p>
     *
     * @param name The name of an event or deadline
     * @param type The type of object, either "deadline" or "event"
     */
    public void removeData(String name, String type) {
        if (type.equals("deadline")) {
            removeFromFile(name, deadLPath);
        }
        else if (type.equals("event")) {
            removeFromFile(name, eventPath);
        }
    }

    public void removeAll() {
        try {
            PrintWriter writer = new PrintWriter(new File(eventPath));
            writer.print("");
            writer.close();
            writer = new PrintWriter(new File(deadLPath));
            writer.print("");
            writer.close();
        } catch(FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    /**
     * Destructor method.
     * <p>
     * Sets {@link #isOpen} to false, thus allowing a new instance of this class to be created
     * </p>
     */
    public static void Destructor() {
        isOpen = false;
    }
}
