import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Bryson Crader
 * 11/25/23
 */
public class CustomerOrder {
    /**
     * @apiNote Will Print Out The Drinks Available On The Menu
     *          (From The URL Diagram, The Drink Class Will Store The Drink Types And Their Ingredients)
     */
    private static void printMenu() {
        System.out.println(" -- Menu -- ");
        for (int i = 0; i < Drink.getTotalMenuItems(); i++) {
            // Prints Drink Name
            System.out.printf("%d - %s\n", i+1, Drink.getDrinkOptions()[i]);
            // Prints All Ingredients In The Drink
            for (String ingredients : Drink.getDrinkIngredients()[i]) {
                System.out.printf("\t- %s\n", ingredients);
            }
        }
    }


    public static void main(String[] args) {
        // Scanner Will Read The User Input From The Command Line
        Scanner scnr = new Scanner(System.in);

        // Prompt User To Enter Name And Set The Result In A Variable
        // Use `.nextLine()` Just In Case User Wants To Enter A Full Name
        System.out.println("Please Enter Name To Start Your Order!");
        String userName = scnr.nextLine();

        // Create A Customer Object With The Customer's Name
        // The Constructor Will Automatically Get The User's Local Time Of The Order
        Customer customer = new Customer(userName);

        printMenu();

        // Prompt User To Select A Menu Item
        System.out.println("Please Select A Item From The Menu");

        int menuSelection;
        // This Will Get The `menuSelection` Option As An Integer,
        // The Condition Checks If The User Chose A Number Below 1 Or A Number Greater Than The Amount Of Menu Items
        do {
            menuSelection = scnr.nextInt();
            if (menuSelection < 1 || menuSelection > Drink.getTotalMenuItems()) {
                System.out.printf("%d Is Not A Valid Item On The Menu!\n", menuSelection);
            }
        } while(menuSelection < 1 || menuSelection > Drink.getTotalMenuItems());

        // For The `menuSelection` Variable, Subtract 1 To Get The Index For An Array
        // The User Will A Number Starting At 1 Because That Is How The Menu Is Set Up
        Drink customerDrink = new Drink(menuSelection-1);

        // Prompt User To Select A Size
        System.out.println("Please Select A Size");
        System.out.println("1 - Small");
        System.out.println("2 - Medium");
        System.out.println("3 - Large");

        int sizeSelection;
        // This Loop Makes Sure That The Answer Is Valid
        do {
            sizeSelection = scnr.nextInt();
            if (sizeSelection < 1 || sizeSelection > 3) {
                System.out.printf("%d Is Not A Valid Size\n", sizeSelection);
            }
        } while(sizeSelection < 1 || sizeSelection > 3);

        customerDrink.setDrinkSize(sizeSelection-1);

        // This Part Will Prompt The User To Add Extra Ingredients If They'd Like
        System.out.print("Would You Like To Add Extra Ingredients To Your Drink?\n");

        // While User Selection Is Not 0 Or Invalid, Keep Asking For Extra Ingredients
        int ingSelection;
        do {
            // Ask Every Time If User Would Like To Add An Ingredient
            // Print All Extra Ingredients
            System.out.print("0 - No Extras\n");
            for (int i = 0; i < Drink.getingSelections().length; i++) {
                System.out.printf("%d - %s\n", i+1, Drink.getingSelections()[i]);
            }
            ingSelection = scnr.nextInt();
            if (ingSelection == 0) {
                break;
            } else if (ingSelection != 0 && (ingSelection < 0 || ingSelection > Drink.getingSelections().length)) {
                System.out.printf("%d Is Not A Valid Ingredient\n", ingSelection);
            } else {
                System.out.printf("Adding %s To Your Drink, Anything Else?\n", Drink.getingSelections()[ingSelection-1]);
                customerDrink.addIngredients(Drink.getingSelections()[ingSelection-1]);
            }
        } while(ingSelection != 0);


        // We Set The User's Drink In The Customer Class
        customer.setCustomerDrink(customerDrink);
        // Then We Print The Drink, This Calls `Drink.printDrink()`, With Some Added Info
        customer.printOrder();
    }
}
