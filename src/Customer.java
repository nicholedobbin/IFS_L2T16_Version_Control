/* ============================= L2T11 Capstone Project: Refactoring Customer.java =================================

    Please see L2T11_Project_Description.README for descriptions of this program's features and functionality.
    Please see 'L2T11_References.txt' for the list of references I used in this task.

    Refactoring/changes made to this class:
    Style & Formatting:
        -   Fixed code indentation and formatting to adhere to Google Java Style Guide (i.e. Nonempty blocks:
            K & R style, Empty blocks: may be concise).
        -   Formatted methods to have consistent line wrapping style.

=================================================================================================================== */

public class Customer
{
    // ======================================= VARIABLES ===========================================================

    //Declare instance variables for Customer Constructor and 'getDetails' methods.
    int orderNumber = 1001;
    String customerName;
    String customerEmail;
    String customerContactNumber;
    String customerStreetAddress;
    String customerSuburbAddress;
    String customerLocation;

    // ======================================= METHODS ===========================================================

    // ----------------------------- Customer Constructor method -----------------------------------------------
    public Customer(String customerName, String customerEmail, String customerContactNumber,
                    String customerStreetAddress, String customerSuburbAddress, String customerLocation) {
        orderNumber++;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerContactNumber = customerContactNumber;
        this.customerStreetAddress = customerStreetAddress;
        this.customerSuburbAddress = customerSuburbAddress;
        this.customerLocation = customerLocation;
    }

    // ------------------------ 'getCustomerDetailsForInvoiceTop' method --------------------------------------
    // Returns customer details for top section of invoice.
    public String getCustomerDetailsForInvoiceTop() {
        return "Order Number: " + orderNumber
                + "\nCustomer: " + customerName
                + "\nEmail: " + customerEmail
                + "\nPhone number: " + customerContactNumber
                + "\nLocation: " + customerLocation + "\n ";
    }

    // ----------------------------- 'getCustomerDetailsForInvoiceTBottom' method ----------------------------------
    // Returns customer details for bottom section of invoice.
    public String getCustomerDetailsForInvoiceBottom() {
        return ("\n" + customerStreetAddress + "\n" + customerSuburbAddress + "\n");
    }
}

