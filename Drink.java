import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Joshua Crumpton
 * 11/27/23
 */
public class Drink
{
    //array of drink names to be used in creating DRINK object
    private static final String[] DRINK_NAMES = {
            "Cappuccino",
            "Latte",
            "Mocha",
            "Caramel Machiato",
            "Hot Chocolate"
    };
        
    //array of drink ingredient arrays to be used in creating DRINK object
    private static final String[][] DRINK_INGREDIENTS = {
            {"Espresso", "Steamed Milk"},
            {"Espresso", "Steamed Milk"},
            {"Espresso", "Steamed Milk", "Chocolate Sauce"},
            {"Espresso", "Steamed Milk", "Caramel Sauce"},
            {"Steamed Milk", "Chocolate Sauce"},
    };
    
    //array of sizes used to set the DRINK object size
    private static final String[] DRINK_SIZES = {
        "Small",
        "Medium",
        "Large",
    };
    
    //array of drink prices to be used in creating DRINK object
    private static final double[] PRICES = {
        5.00,
        5.00,
        5.50,
        5.50,
        5.00
    };
    
    //array of extra ingredients to be used in printing menus
    private static final String[] EXTRA_INGREDIENTS = {
            "Extra Espresso Shot",
            "Sub Almond Milk",
            "Chocolate Sauce",
            "Caramel Sauce",
            "Vanilla Syrup",
            "Sugar Free Syrup",
            "Make it Iced",
    };
    
    private String drinkSize;
    private String drinkName;
    private double drinkPrice;
    private ArrayList<String> currentIng; //ArrayList is used to make it easy to modify the drink ingredients
    private int a;
    
    
    //Constructor method to create the DRINK object
    public Drink(int selection){
        drinkName = DRINK_NAMES[selection];
        drinkSize = "small";
        drinkPrice = PRICES[selection];
        currentIng = new ArrayList<>(Arrays.asList(DRINK_INGREDIENTS[selection]));
    }
    
    //Method to set the drink size and add cost for different sizes
    public void setDrinkSize(int selection){
        drinkSize = DRINK_SIZES[selection];
        switch (selection){
            case 0:
                break;
            case 1:
                drinkPrice += 0.75;
                break;
            case 2:
                drinkPrice += 1.50;
                break;
        }
    }
    
    //method for adding extra ingredients that are sent from the main and then increase price
    public void addIngredients(String extraIng){
        currentIng.add(extraIng);
        drinkPrice += 0.50;
    }
    
    //method to print the current DRINK object
    public void printDrink(){
        System.out.println(drinkSize + " " + drinkName + " with:");
        
        for (a = 0; a < currentIng.size(); ++a) {
            System.out.println(" - " + currentIng.get(a));
        }
        System.out.println();
        System.out.printf("Total: %.2f\n", drinkPrice);
    }
    
    //method to get drink names for printing menus
    static public String[] getDrinkOptions() {
        return DRINK_NAMES;
    }
    
    //method to get drink ingredients for printing menus
    static public String[][] getDrinkIngredients(){
        return DRINK_INGREDIENTS;
    }
    
    //method to get drink sizes for printing menus
    static public String[] getDrinkSizes(){
        return DRINK_SIZES;
    }

    //method to get drink sizes for printing menus
    static public String[] getingSelections(){
        return EXTRA_INGREDIENTS;
    }
    
    //method to return total menu item count
    static public int getTotalMenuItems(){
        return DRINK_NAMES.length;
    }
    
}
