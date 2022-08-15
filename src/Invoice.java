/* =============================== L2T11 Capstone Project: Refactoring Invoice.java =================================

    Please see L2T11_Project_Description.README for descriptions of this program's features and functionality.
    Please see 'L2T11_References.txt' for the list of references I used in this task.

    Refactoring/changes made to this class:
    Classes:
        -   Created separate Invoice class for Invoice objects and methods (to be called in Main, making program
            more modular and object-oriented).

    Style & Formatting:
        -   Fixed code indentation and formatting to adhere to Google Java Style Guide (i.e. Nonempty blocks:
            K & R style, Empty blocks: may be concise).

    Imports:
        -   Imported Java packages for Formatter, FileNotFoundException and ArrayList.

    Variables:
        -   Declared variables required for Invoice methods.

    Methods:
        -   Created Constructor method for Invoice instances.
        -   Created 'printInvoice' method that uses 'try-catch' block to handle errors and exceptions for
            file formatting.

    Bug Fixes (Instructions Specifications Typo):
        -   The Task Instructions only specified "he" in the invoice output message, and the drivers.txt file
            does not specify driver gender, so if the selected driver is female it will still print "he".
            I've edited it to contain the words "s/he" to be more accurate.

=================================================================================================================== */

// Import Java packages.
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;

public class Invoice {
    // ========================================= VARIABLES =======================================================

    // Declare variables required for Invoice Constructor and 'printInvoice' methods (i.e. Customer,
    // Restaurant and Driver information).
    String customerDetailsTop;
    String restaurantDetailsTop;
    String customerDetailsBottom;
    String restaurantDetailsBottom;
    ArrayList<Driver> driverObjectsArray;
    String restaurantLocation;
    String driverName;

    //=========================================== METHODS ======================================================

    // ------------------------- Constructor Method for Invoice instances -------------------------------------
    public Invoice(String customerDetailsTop, String restaurantDetailsTop, String customerDetailsBottom,
                   String restaurantDetailsBottom, ArrayList<Driver> driverObjectsArray, String restaurantLocation) {
        this.customerDetailsTop = customerDetailsTop;
        this.restaurantDetailsTop = restaurantDetailsTop;
        this.customerDetailsBottom = customerDetailsBottom;
        this.restaurantDetailsBottom = restaurantDetailsBottom;
        this.driverObjectsArray = driverObjectsArray;
        this.restaurantLocation = restaurantLocation;
    }

    // ----------------------------------- 'printInvoice' Method  ---------------------------------------------
    // Compares Driver instances in 'driverObjectsArray' with 'restaurantLocation'. If they match, format and
    // print the invoice with order information. If they do not match, format and print the invoice with a
    // message that the delivery cannot be made. Uses 'try-catch' block to handle errors and exceptions for
    // file formatting.
    public void printInvoice() {
        for (int i = 0; i < driverObjectsArray.size(); i++) {
            if (driverObjectsArray.get(i).driverLocation.equalsIgnoreCase(restaurantLocation)) {
                driverName = driverObjectsArray.get(i).driverName;
                try {
                    Formatter customerInvoice = new Formatter("invoice.txt");
                    customerInvoice.format("%s", customerDetailsTop);
                    customerInvoice.format("%s", restaurantDetailsTop);
                    customerInvoice.format("%s", "\n" + driverName + " is nearest to the restaurant and so " +
                            "s/he will be delivering your order to you at: \n");
                    customerInvoice.format("%s", customerDetailsBottom);
                    customerInvoice.format("%s", restaurantDetailsBottom);
                    customerInvoice.close();
                } catch (Exception e) {
                    System.out.println("Error: file not formatted.");
                }
                break;
            } else {
                try {
                    Formatter customerInvoice = new Formatter("invoice.txt");
                    customerInvoice.format
                            ("%s", "\nSorry! Our drivers are too far away from you to " +
                                    "be able to deliver to your location.");
                    customerInvoice.close();
                } catch (FileNotFoundException e) {
                    System.out.println("Error: file not formatted.");
                }
            }
        }
    }
}

