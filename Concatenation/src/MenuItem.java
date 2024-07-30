/** Use this class for THOROUGH testing! It can be messed up... but still run.
 * MenuItem class represents a food item in a menu.
 * It contains information such as name, price, and toppings.
 *
 * @author 25 Patton
 * @version 0.1
 */
//TESTTTTTTTT
public class MenuItem{
    protected String name;
    protected double price; //2ND TESTTTT
    protected StringBuilder topping;

    /**
     * Constructs a MenuItem object with default values.
     */
    public MenuItem(){
        name = "";
        price = 0.0;
        topping = new StringBuilder();
    }

    /**
     * Constructs a MenuItem object with specified values.
     *
     * @param nameIn The name of the menu item
     * @param priceIn The price of the menu item
     * @param toppingIn The initial toppings for the menu item
     */
    public MenuItem(String nameIn, double priceIn, StringBuilder toppingIn){
        name = nameIn;
        price = priceIn;
        topping = toppingIn;
    }

    /**
     * Sets the name of the menu item.
     *
     * @param nameIn The name to set for the menu item
     */
    public void setName(String nameIn){name = nameIn;}

    /**
     * Sets the price of the menu item.
     *
     * @param priceIn The price to set for the menu item
     */
    public void setPrice(double priceIn){price = priceIn;}

    /**
     * Sets the toppings for the menu item.
     *
     * @param toppingIn The toppings to set for the menu item
     */
    public void setTopping(StringBuilder toppingIn){topping = toppingIn;}

    /**
     * Gets the name of the menu item.
     *
     * @return The name of the menu item
     */
    public String getName(){return name;}

    /**
     * Gets the price of the menu item.
     *
     * @return The price of the menu item
     */
    public double getPrice(){return price;}

    /**
     * Gets the toppings of the menu item.
     *
     * @return The toppings of the menu item
     */
    public StringBuilder getTopping(){return topping;}

    /**
     * Adds a topping to the menu item.
     * Increases the price accordingly.
     *
     * @param topping The topping to add to the menu item
     */
    public void addTopping(String topping){
        // DEBUGGING: Test for regular comment
        if (this.topping.length() > 0){
            this.topping.append(", ").append(topping);
            price += 0.49;
        } else {
            this.topping.append(topping);
        }
    }

    public String toString(){
        String s = ""; // empty "string"
        s += "\"MenuItem\" //: "; // class "name"
        s += "name //:\\" + name;  //" name
        String s2 = ", topping //: " + topping + ", price //: " + price; // this is a real comment :)
        return s + "" + s2; // just to be "difficult"
    }
}
