/* =============================== L2T11 Capstone Project: Refactoring Driver.java =================================

    Please see L2T11_Project_Description.README for descriptions of this program's features and functionality.
    Please see 'L2T11_References.txt' for the list of references I used in this task.

    Refactoring/changes made to this class:
    Classes:
        -   Created separate Driver class for Driver objects and methods (to be called in Main, making program
            more modular and object-oriented).

    Style & Formatting:
        -   Fixed code indentation and formatting to adhere to Google Java Style Guide (i.e. Nonempty blocks:
            K & R style, Empty blocks: may be concise).

    Imports:
        -   Imported Java packages for File, Scanner, FileNotFoundException and ArrayList.

    Variables:
        -   Declared variables required for Driver methods.

    Methods:
        -   Created Constructor method for Driver instances.
        -   Created 'getDetailsFromTextFile' method that uses 'try-catch' block to get and save information
            from text file to a 2D Array, handling errors and exceptions for reading the text file.
        -   Created 'createArrayOfDriversObjects' method that initialises ArrayList to store Driver instances,
            creates new driver instance for each element of driverDetails2DArray and adds each instance to
            'arrayOfDriversObjects'

=================================================================================================================== */

// Import Java packages.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    // ========================================= VARIABLES =======================================================

    // Declare variables required for Driver Constructor method.
    public String driverName;
    public String driverLocation;
    public int driverLoad;

    // Declare and initialise variable for driverDetails2DArray (calling 'getDetailsFromTextFile' method).
    static String[][] driverDetails2DArray = getDetailsFromTextFile();

    //=========================================== METHODS ======================================================

    // ------------------------- Constructor Method for Driver instances -------------------------------------
    public Driver(String driverName, String driverLocation, int driverLoad)
    {
        this.driverName = driverName;
        this.driverLocation = driverLocation;
        this.driverLoad = driverLoad;
    }

    // ---------------------------- 'getDetailsFromTextFile' Method  -----------------------------------------
    // Uses 'try-catch' block to get and save information from text file to a 2D Array, handling errors and
    // exceptions for reading the text file.
    private static String[][] getDetailsFromTextFile() {
        // Declare and initialise variables.
        String driverDetailsString = "";
        String[] driverDetailsArray;

        try {
            // Get info from text file and save to driverDetailsString.
            File driverTxtFile = new File("drivers.txt");
            Scanner txtScanner = new Scanner(driverTxtFile);
            while (txtScanner.hasNextLine()) {
                driverDetailsString += txtScanner.nextLine() + "\n";
            }
            txtScanner.close();

            // Split driverDetailsString at new line and store in driverDetailsArray.
            driverDetailsArray = driverDetailsString.split("\n");

            // Initialise 2D driverDetails2DArray with size of driverDetailsArray and 3 columns.
            driverDetails2DArray = new String[driverDetailsArray.length][3];

            for (int i = 0; i < driverDetails2DArray.length; i++) {
                // Split each driverDetailsArray element and store in driverDetails2DArray[i].
                driverDetails2DArray[i] = driverDetailsArray[i].split(", ");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
        return driverDetails2DArray;
    }

    // ---------------------------- 'createArrayOfDriversObjects' Method  -----------------------------------------
    // Initialise ArrayList to store Driver instances, create new driver instance for each element of
    // driverDetails2DArray and add each instance to 'arrayOfDriversObjects'.
    public static ArrayList<Driver> createArrayOfDriversObjects() {
        ArrayList<Driver> arrayOfDriversObjects = new ArrayList<Driver>();

        for (int i=0; i<driverDetails2DArray.length; i++) {
            Driver newDriverObject = new Driver(
                    driverDetails2DArray[i][0],
                    driverDetails2DArray[i][1],
                    Integer.parseInt(driverDetails2DArray[0][2])
            );
            arrayOfDriversObjects.add(newDriverObject);
        }
        return arrayOfDriversObjects;
    }
}

