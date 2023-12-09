import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author Bryson Crader
 * 11/25/23
 */
public class Customer {
    private String customerName;
    //  I Changed `orderTime` To LocalTime, This Gets The User's System's Local Time,
    //      Because It's Stored As A LocalTime, You Should Call `getTimeOfOrder`
    //      To Get A Printable String In a Non-Military Time Format
    private LocalTime orderTime;

    private Drink customerDrink;

    // The Constructor
    Customer(String customerName) {
        orderTime = LocalTime.now(ZoneId.systemDefault());
        System.out.printf("Time: %s\n", getTimeOfOrder());

        this.customerName = customerName;
    }

    /**
     * @apiNote No `setName` Is Available Because Just Like Real Life The Retail Worker Could Not Care More About You
     * @return Customer's Name
     */
    public String getName() {
        return customerName;
    }

    /**
     * @apiNote Convert's `orderTime` Into A Non-Military Time String,
     *          `orderTime` Is Set In The Constructor
     * @return The User's System's Local Time (Which Was Set In The Constructor)
     */
    public String getTimeOfOrder() {
        return orderTime.format(DateTimeFormatter.ofPattern("h:mm:ss"));
    }

    /**
     * @param drink Currently Un-Implemented
     * @apiNote The `Drink` Still Needs To Be Given Functionality
     */
    public void setCustomerDrink(Drink drink) {
        customerDrink = drink;
    }

    /**
     * @apiNote Prints Out The Users Time Of Order, Thanks The Customer By Name, Then Prints The Drink's Information
     */
    public void printOrder() {
        System.out.printf("Order Placed At %s\n", getTimeOfOrder());
        System.out.print("Thank You For Coming In! Here Is Your ");
        customerDrink.printDrink();
        System.out.printf(" For %s\n", getName());
    }
}
