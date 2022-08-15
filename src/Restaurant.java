/* =========================== L2T11 Capstone Project: Refactoring Restaurant.java =================================

    Please see L2T11_Project_Description.README for descriptions of this program's features and functionality.
    Please see 'L2T11_References.txt' for the list of references I used in this task.

    Refactoring/changes made to this class:
    Style & Formatting:
        -   Fixed code indentation and formatting to adhere to Google Java Style Guide (i.e. Nonempty blocks:
            K & R style, Empty blocks: may be concise).
        -   Formatted methods to have consistent line wrapping style.

    Variables:
        -   Removed redundant '= new ArrayList<Double/Integer>()' initializers from 'priceOfMealsList'
            and 'mealAmountList'.
        -   Replaced redundant '= new String();' in 'totalMealsString' to empty string ("").

    Bug fixes:
        -   Total price output was showing varied decimal spaces depending on amount. Fixed bug with
            'Math.round(totalPrice * 100.0)/100.0'.

=================================================================================================================== */

// Import Java packages.
import java.util.ArrayList;

public class Restaurant
{
    // =================================== VARIABLES ===============================================================

    //Declare instance variables for Restaurant Constructor method.
    String restaurantName;
    String restaurantLocation;
    String restaurantContactNumber;
    String specialInstructions;
    ArrayList<String> mealsOrderedList;
    ArrayList<Double> priceOfMealsList;
    ArrayList<Integer> mealAmountList;

    // Declare variables for 'getTotalMealsList' method.
    String totalMealsString = "";

    // Declare variables for 'calculateTotalPrice' method.
    private String[][] finalMealsList;
    private double totalPrice;

    // ====================================== METHODS ============================================================

    // ----------------------------- Restaurant Constructor method -----------------------------------------
    public Restaurant(String restaurantName, String restaurantLocation, String restaurantContactNumber,
                      ArrayList<String> mealsOrderedList, ArrayList<Double> priceOfMealsList,
                      ArrayList<Integer> mealAmountList, String specialInstructions) {
        this.restaurantName = restaurantName;
        this.restaurantLocation = restaurantLocation;
        this.restaurantContactNumber = restaurantContactNumber;
        this.mealsOrderedList = mealsOrderedList;
        this.priceOfMealsList = priceOfMealsList;
        this.mealAmountList = mealAmountList;
        this.specialInstructions = specialInstructions;

        // Call methods to get list of total meals and calculate total price.
        getTotalMealsList();
        calculateTotalPrice();
    }

    // -------------------- 'getTotalMealsList' method (called in Constructor) -----------------------------
    private void getTotalMealsList() {
        // Create and initialise 2D Array with row size of 'mealsOrderedList' and 3 columns.
        String[][] totalMealsList = new String[mealsOrderedList.size()][3];

        // Add values from 'mealsOrderedList', 'priceOfMealsList' and 'mealAmountList' to
        // 'totalMealsList' and 'totalMealsString'.
        for (int i = 0; i < totalMealsList.length; i++ ) {
            totalMealsList[i][0] = String.valueOf(mealAmountList.get(i));
            totalMealsString += totalMealsList[i][0] + " x ";
            totalMealsList[i][1] = mealsOrderedList.get(i);
            totalMealsString += totalMealsList[i][1] + " ";
            totalMealsList[i][2] = String.valueOf(priceOfMealsList.get(i));
            totalMealsString += "(R" + totalMealsList[i][2] + ") \n";
        }

        // Add totalMealsList values to finalMealsList (to access values outside this method).
        finalMealsList = totalMealsList;
    }

    // ------------------ 'calculateTotalPrice' method (called in Constructor) ----------------------------
    private void calculateTotalPrice() {
        for (int i = 0; i<finalMealsList.length; i++) {
            double mealPrice =
                    (Double.parseDouble(finalMealsList[i][0])) * (Double.parseDouble(finalMealsList[i][2]));
            totalPrice += mealPrice;
        }
    }

    // ---------------------- 'getRestaurantDetailsForInvoiceTop' method ----------------------------------
    // Returns restaurant details for top section of invoice.
    public String getRestaurantDetailsForInvoiceTop() {
        return "\nYou have ordered the following from " + restaurantName + " in "
                + restaurantLocation + ": \n"
                + "\n" + totalMealsString
                + "\nSpecial Instructions: " + specialInstructions + "\n"
                + "\nTotal: R" + Math.round(totalPrice * 100.0)/100.0 + "\n";
    }

    // ---------------------- 'getRestaurantDetailsForInvoiceBottom' method -------------------------------
    // Returns restaurant details for bottom section of invoice.
    public String getRestaurantDetailsForInvoiceBottom() {
        return "\nIf you need to contact the restaurant, their number is "
                + restaurantContactNumber + ".";
    }
}

