// MustafaTajammul, Abdurrahim Rana, Shui
// Inventory and Funds Management System
class Funds{
    public appendToWishlistCost(int a){

    }
}

class InventoryObject extends Funds{
    private String name;
    private int wishlistCount;
    private double price;
    private int purchasedCount;
    // the above variables are all attributes for the InventoryObject objects

    private static int count=0;
    // counts the number of objects on wishlist

    ArrayList<InventoryObject> items = new ArrayList<InventoryObject>;
    // an arraylist to keep track of all of the current objects on wishlist

    public InventoryObject(String name, int WishlistCount, double price){
        //making sure pre-reqs are met
        if (wishlistCount > 0 && price > 0){
            
            this.name = name;
            this.wishlistCount= wishlistCount;
            this.price = price;
            this.purchasedCount = 0;
            count++;
            //setting all the variables equal to what parameters have shown them to be passed

            appendToWishlistCost(price * wishlistCount);
            //adding this to wishlist cost 

            addObjectToList();
            //adding to the arraylist of InventoryObject objects
            }
        
        else{
            System.out.print("Invalid Inputs, please enter valid inputs."); 
            //error message           
        }
    }

    public InventoryObject(String name, double price){
        //making sure pre-reqs are met
        if (price> 0){
            this(name, 0, price);
            this.purchasedCount = 0;
            count++;
            //same thign as in the original constuctor

            appendToWishlistCost(price * wishlistCount);
            addObjectToList();
            //same as original constructor
        }

        else{
            System.out.print("Invalid Inputs, please enter valid inputs.");            
        }
    }
    

    public void setWishlistCount(int newWishlistCount) {
        //make sure the new amount is positive
        if(newWishlistCount> 0 ){
            //we are adding the new difference in cost to the wishlist cost
            appendToWishlistCost(this.price * (newWishlistCount-this.wishlistCount))
            
            //updating the wishlistCount to the new one
            this.wishlistCount = newWishlistCount;
        }
        else{
            //error message
            System.out.print("Invalid Inputs, please enter valid inputs.");            
        }
    }

    public void addObjectToList(){
        items.add(this);
        //adds this object tot he arraylist
    }

    public void purchase(int buyAmount){
        if (buyAmount > 0){
            if (buyAmount <= this.wishlistCount){
                if (Funds.getCurrentFunds() >= this.buyAmount * this.price){
                    //all the if statments are for prereqs
                    
                    //adds the amount we will use to the variable that tracks the amount of funds used
                    addToFundsUsed(buyAmount * this.price);

                    //updates the purchasedCount varaibel so that it is accurate on the number of items purchased of this type
                    this.purchasedCount+=buyAmount;

                    //updates the wishlistCount and subtracts it by the number of items bought
                    this.wishlistCount-=buyAmount;
                }

                else{
                System.out.print("Invalid funds.");            
                }
            }

            else{
            System.out.print("Invalid, attempting to buy more than there is in wishlist.");            
            }
        }
        
        else{
            System.out.print("Invalid Inputs, please enter valid inputs.");            
        }
    }

    public String toString(){
        String output = this.name": \nThis item costs $" + this.price + "\nWishlist amount: " + this.wishlistCount + "\nAmount previously bought: " + purchasedCount;
        return output;
    }

    public static int getCount(){
        return count;
    }
}

class countFRC extends InventoryObject{
    
}
