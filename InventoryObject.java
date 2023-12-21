// MustafaTajammul, Abdurrahim Rana, Shui
// Inventory and Funds Management System
import java.util.*;

public class InventoryObject{
    private String name;
    private int wishlistCount;
    private double price;
    private int purchasedCount;
    // the above variables are all attributes for the InventoryObject objects

    private static int count=0;
    // counts the number of objects on wishlist

    public static ArrayList<InventoryObject> items = new ArrayList<InventoryObject>();
    // an arraylist to keep track of all of the current objects on wishlist

    public Funds account;

    public InventoryObject(String name, int wishlistCount, double price, Funds account){
        //making sure pre-reqs are met
        if (wishlistCount > 0 && price > 0){
            
            this.name = name;
            this.wishlistCount= wishlistCount;
            this.price = price;
            this.purchasedCount = 0;
            this.account = account;
            count++;
            //setting all the variables equal to what parameters have shown them to be passed

            account.appendToWishlistCost(price * wishlistCount);
            //adding this to wishlist cost 

            addObjectToList();
            //adding to the arraylist of InventoryObject objects
            }
        
        else{
            throw new ArithmeticException("Invalid Inputs, please enter valid inputs."); 
            //error message           
        }
    }

    public InventoryObject(String name, double price, Funds account){
        //making sure pre-reqs are met
        if (price> 0){
            this.name = name;
            this.wishlistCount= 0;
            this.price = price;
            this.purchasedCount = 0;
            this.account = account;
            count++;
            //same thign as in the original constuctor but changed to have 0 as automatic wishlist count

            account.appendToWishlistCost(price * wishlistCount);
            addObjectToList();
            //same as original constructor
        }

        else{
            throw new ArithmeticException("Invalid Inputs, please enter valid inputs.");            
        }
    }
    

    public void setWishlistCount(int newWishlistCount) {
        //make sure the new amount is positive
        if(newWishlistCount> 0 ){
            //we are adding the new difference in cost to the wishlist cost
            account.appendToWishlistCost(this.price * (newWishlistCount-this.wishlistCount));
            
            //updating the wishlistCount to the new one
            this.wishlistCount = newWishlistCount;
        }
        else{
            //error message
            throw new ArithmeticException("Invalid Inputs, please enter valid inputs.");            
        }
    }

    public void addObjectToList(){
        items.add(this);
        //adds this object tot he arraylist
    }

    public void purchase(int buyAmount){
        if (buyAmount > 0){
            if (buyAmount <= this.wishlistCount){
                if (account.getCurrentFunds() >= (buyAmount * this.price)){
                    //all the if statments are for prereqs
                    double totalCost = buyAmount * this.price;
                    //adds the amount we will use to the variable that tracks the amount of funds used
                    account.addToFundsUsed(totalCost);
                    account.appendToWishlistCost(-1*totalCost);
                    //updates the purchasedCount varaibel so that it is accurate on the number of items purchased of this type
                    this.purchasedCount+=buyAmount;

                    //updates the wishlistCount and subtracts it by the number of items bought
                    this.wishlistCount-=buyAmount;
                }

                else{
                    throw new ArithmeticException("Insufficient funds.");            
                }
            }

            else{
                throw new ArithmeticException("Invalid, attempting to buy more than there is in wishlist.");            
            }
        }
        
        else{
            throw new ArithmeticException("Invalid Inputs, please enter valid inputs.");            
        }
    }
    //uses a tostring to output the result
    public String toString(){
        String output = " "+this.name+"\nAccount: "+this.account.getTeamName()+" account\nThis item costs $" + this.price + "\nWishlist amount: " + this.wishlistCount + "\nAmount previously bought: " + purchasedCount;
        return output;
    }
    // a list of getters
    public static String getObjectWishlist(InventoryObject object){
        String output = "$"+(object.price * object.wishlistCount) + "\t (" + object.wishlistCount +") "+object.name;
        return output;
    }
        
    public static int getCount(){
        return count;
    }

    public static ArrayList getItemList(){
        return items;
    }
}
