/* ================================== L2T11 Capstone Project: Refactoring Main.java =================================

    Please see L2T11_Project_Description.README for descriptions of this program's features and functionality.
    Please see 'L2T11_References.txt' for the list of references I used in this task.

    Refactoring/changes made to this class:
    Classes & Methods:
        -   Created Drivers class for drivers objects and methods, to make program more modular and object-oriented.
        -   Created Invoice class for invoice objects and methods, to make program more modular and object-oriented.

    Style & Formatting:
        -   Fixed code indentation and formatting to adhere to Google Java Style Guide (i.e. Nonempty blocks:
            K & R style, Empty blocks: may be concise).

    Imports:
        -   Removed unused import statements for reading files and file exceptions (java.io.File &
            java.io.FileNotFoundException).

    Variables:
        -   Removed unused variables/initializers (e.g. moved 'driverName' and 'driverDetails' to Driver class).
        -   Removed redundant initializer from  'String specialInstructions = "";'.
        -   Replaced explicit type arguments with <> in mealsOrderedList, priceOfMealsList and
            mealAmountList declarations.

    Bug Fixes:
        -   Scanner originally required entering 'N' twice (from 'if..else if' statement in additional meals loop).
            Changed the 'else if' to 'else' and changed output instruction to "Enter Y to add a new meal or enter
            any other key to check out".

=================================================================================================================== */

// Import Java packages.
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        // ========================================= VARIABLES =======================================================

        // Declare variables for Customer input.
        String customerName;
        String customerEmail;
        String customerContactNumber;
        String customerStreetAddress;
        String customerSuburbAddress;
        String customerLocation;

        // Declare variables for Restaurant input.
        String restaurantName;
        String restaurantLocation;
        String restaurantContactNumber;
        String mealType;
        double mealPrice;
        int mealAmount;
        ArrayList<String> mealsOrderedList = new ArrayList<>();
        ArrayList<Double> priceOfMealsList = new ArrayList<>();
        ArrayList<Integer> mealAmountList = new ArrayList<>();
        String specialInstructions;

        // Declare and initialize driverObjectsArray by calling Driver.createArrayOfDriversObjects().
        ArrayList<Driver> driverObjectsArray = Driver.createArrayOfDriversObjects();

        //=========================== INPUT SCANNER: RESTAURANT & CUSTOMER INFO =====================================

        //Initialise scanner object.
        Scanner inputtedDetails = new Scanner(System.in);

        //------------------------------- Customer Information -----------------------------------------
        System.out.println("Enter your full name: ");
        customerName = inputtedDetails.nextLine();

        System.out.println("Enter your email address: ");
        customerEmail = inputtedDetails.nextLine();

        System.out.println("Enter your contact number: ");
        customerContactNumber = inputtedDetails.nextLine();

        System.out.println("Enter your street number and street name: ");
        customerStreetAddress = inputtedDetails.nextLine();

        System.out.println("Enter your suburb: ");
        customerSuburbAddress = inputtedDetails.nextLine();

        System.out.println("Enter your city: ");
        customerLocation = inputtedDetails.nextLine();

        //------------------------------- Restaurant Information -----------------------------------------
        System.out.println("\nEnter the restaurant name: ");
        restaurantName = inputtedDetails.nextLine();

        System.out.println("Enter the restaurant's city: ");
        restaurantLocation = inputtedDetails.nextLine();

        System.out.println("Enter the restaurant's contact number: ");
        restaurantContactNumber = inputtedDetails.nextLine();

        System.out.println("Enter the name of a meal you want to order: ");
        mealType = inputtedDetails.nextLine();
        mealsOrderedList.add(mealType);

        System.out.println("Enter the  price of this meal:  ");
        mealPrice = Double.parseDouble(inputtedDetails.next());
        priceOfMealsList.add(mealPrice);

        System.out.println("Enter how many of this meal you want to order: ");
        mealAmount = Integer.parseInt(inputtedDetails.next());
        mealAmountList.add(mealAmount);

        // Create loop for user to enter additional meals.
        while (true) {
            System.out.println
                    ("Would you like to order another meal? " +
                            "\nEnter Y to add a new meal or enter any other key to checkout: ");

            if ("Y".equalsIgnoreCase(inputtedDetails.next())) {
                Scanner newMealDetails = new Scanner(System.in);

                System.out.println("Enter the name of the next meal you want to order: ");
                String newMealType = newMealDetails.nextLine();
                mealsOrderedList.add(newMealType);

                System.out.println("Enter the  price of this meal:  ");
                Double newMealPrice = Double.parseDouble(newMealDetails.next());
                priceOfMealsList.add(newMealPrice);

                System.out.println("Enter how many of this meal you want to order: ");
                int newMealAmount = Integer.parseInt(newMealDetails.next());
                mealAmountList.add(newMealAmount);
            } else {
                break;
            }
        }

        //Create new scanner for special instructions (because break in loop closes scanners).
        Scanner specialInstructionsScanner = new Scanner(System.in);
        System.out.println("Enter special instructions or dietary requirements: ");
        specialInstructions = specialInstructionsScanner.nextLine();

        //============================== CREATE CUSTOMER & RESTAURANT INSTANCES =====================================

        // Create Customer & Restaurant instances by calling constructor method.
        Customer newCustomer = new Customer
                (customerName, customerEmail, customerContactNumber,
                        customerStreetAddress, customerSuburbAddress, customerLocation);

        Restaurant newRestaurant = new Restaurant
                (restaurantName, restaurantLocation, restaurantContactNumber,
                        mealsOrderedList, priceOfMealsList, mealAmountList, specialInstructions);

        // ======================= CALL METHODS ON CUSTOMER & RESTAURANT INSTANCES ==================================

        // Get details of customer and restaurant instances by calling 'get..DetailsFor..' methods on instances.
        String customerDetailsTop = newCustomer.getCustomerDetailsForInvoiceTop();
        String restaurantDetailsTop = newRestaurant.getRestaurantDetailsForInvoiceTop();
        String customerDetailsBottom = newCustomer.getCustomerDetailsForInvoiceBottom();
        String restaurantDetailsBottom = newRestaurant.getRestaurantDetailsForInvoiceBottom();

        // ================================== CREATE INVOICE INSTANCE ==============================================

        // Create Invoice instance by calling constructor method.
        Invoice newInvoice = new Invoice(customerDetailsTop, restaurantDetailsTop, customerDetailsBottom,
                restaurantDetailsBottom, driverObjectsArray, restaurantLocation);

        // ======================= CALL PRINT INVOICE METHOD ON INVOICE INSTANCE ===================================
        newInvoice.printInvoice();
    }
}


