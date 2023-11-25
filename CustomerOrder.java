import java.util.Scanner;

/**
 * @author Bryson Crader
 * 11/25/23
 */
public class CustomerOrder {
    // NOTE: REMOVE THE DRINK LIST!
    //       DRINK NAMES ARE GOING TO BE STORED IN THE DRINK CLASS
    //       IT IS IMPORTANT THAT THE DRINK INGREDIENTS AND NAMES LIST ARE STATIC!
    private static final String[] DRINK_NAMES_TEMPORARY = {
            "Cappuccino",
            "Latte",
            "Mocha",
            "Caramel Machiato",
            "Hot Chocolate"
    };
    // NOTE: THIS LIST ALSO NEEDS TO BE STORED IN THE DRINK CLASS AS A TEMPORARY VARIABLE
    //       THE LIST WILL MATCH UP INGREDIENTS WITH ITS DRINK NAME
    //       I.E. DRINK[0]'s INGREDIENTS WILL EQUAL DRINK[0]'s NAME
    private static final String[][] DRINK_INGREDIENTS_TEMPORARY = {
            {"Espresso", "Steamed Milk"},
            {"Espresso", "Steamed Milk"},
            {"Espresso", "Steamed Milk", "Chocolate Sauce"},
            {"Espresso", "Steamed Milk", "Caramel Sauce"},
            {"Steamed Milk", "Chocolate Sauce"},
    };
    // NOTE: TEMPORARY, DRINK SIZES SHOULD BE STORED IN THE DRINK CLASS AS A STATIC ARRAY OF STRINGS, INTEGERS, OR AN ENUM
    private static String[] DRINK_SIZES = {
        "Small",
        "Medium",
        "Large",
    };
    // The Above Arrays Need To Be Gotten From Drink Class:
    //      `Drink.getDrinkOptions` For Example (The Function Name Doesnt Have To Match Exactly)
    //      And `Drink.getMenuIngredients` For Example (The Function Name Doesnt Have To Match Exactly)

    /**
     * @apiNote Will Print Out The Drinks Available On The Menu
     *          (From The URL Diagram, The Drink Class Will Store The Drink Types And Their Ingredients)
     */
    private static void printMenu() {
        System.out.println(" -- Menu -- ");
        for (int i = 0; i < DRINK_NAMES_TEMPORARY.length; i++) {
            // Prints Drink Name
            System.out.printf("%d - %s\n", i+1, DRINK_NAMES_TEMPORARY[i]);
            // Prints All Ingredients In The Drink
            for (String ingredients : DRINK_INGREDIENTS_TEMPORARY[i]) {
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
        // FIXME: `TOTAL_MENU_ITEM_COUNT` Should Be Gathered From `Drink.getTotalMenuItems`, This Allows The Menu To Be Updated And The Program Shouldn't Break
        // For Now It Is Hard Coded To 5
        final int TOTAL_MENU_ITEM_COUNT = 5;
        // This Is Set To -1, It Should Be Overwritten Immediately In The `do-while` Loop
        int menuSelection = -1;
        // This Will Get The `menuSelection` Option As An Integer,
        // The Condition Checks If The User Chose A Number Below 1 Or A Number Greater Than The Amount Of Menu Items
        do {
            menuSelection = scnr.nextInt();
            if (menuSelection < 1 || menuSelection > TOTAL_MENU_ITEM_COUNT) {
                System.out.printf("%d Is Not A Valid Item On The Menu!\n", menuSelection);
            }
        } while(menuSelection < 1 || menuSelection > TOTAL_MENU_ITEM_COUNT);

        // For The `menuSelection` Variable, Subtract 1 To Get The Index For An Array
        // The User Will A Number Starting At 1 Because That Is How The Menu Is Set Up
        Drink customerDrink = new Drink(menuSelection-1);

        // Prompt User To Select A Size
        // (I Suggest Using An Enum For The Sizes, But An Integer/String Would Also Work)
        System.out.println("Please Select A Size");
        System.out.println("1 - Small");
        System.out.println("2 - Medium");
        System.out.println("3 - Large");

        int sizeSelection;
        do {
            sizeSelection = scnr.nextInt();
            if (sizeSelection < 1 || sizeSelection > 3) {
                System.out.printf("%d Is Not A Valid Size\n", sizeSelection);
            }
        } while(sizeSelection < 1 || sizeSelection > 3);


        // NOTE: THIS PART IS TEMPORARY, THE PRINTING DRINK FUNCTIONALITY SHOULD BE MOVED TO THE `Drink` CLASS: `Drink.printDrink()`
        // This Just Prints The Users Options
        // Again, To Get The Index Of Any Menu Item/Size Just Subtract 1 From The Selection
        System.out.printf("%s's Drink: A %s %s\n", userName, DRINK_SIZES[sizeSelection-1], DRINK_NAMES_TEMPORARY[menuSelection-1]);
    }
}
