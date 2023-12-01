public class Funds{
    private String teamName;
    private double totalRaisedFunds;
    private double currentFunds;
    private double fundsUsed; 
    private double wishlistCost; 
    //these are all the instance variables for the methods used below 

    
    //constructor for the Funds object
    public Funds(String teamName) {
        this.teamName = teamName;
        totalRaisedFunds = 0;
        currentFunds = 0;
        fundsUsed = 0;
        wishlistCost = 0;
    }
    
    //totalRaisedFunds methods
    
    // Gets the total number of raised funds
    public String getTotalRaisedFunds() {
        return getTotalRaisedFunds;
    }
    // Adds more funds to the totalRaisedFunds variable, must be positive
    public void addToTotalRaisedFunds(double addamount) {
        if (addamount > 0) {
            totalRaisedFunds += addamount;
            currentFunds += currentFunds; 
        }
        else {
            // Displays an error if the value is negative
            throw new ArithmeticException("Error: Invalid Input. Amount added must be greater than 0!");
        }
    }

    //currentFunds methods
    
    // Gets the current amount of funds in the account
    public String getCurrentFunds() {
        return currentFunds;
    }
    // Must be positive, updates the current funds
    public void setCurrentFunds(double newcurrentfund) {
        if (newcurrentfund > 0) {
            this.currentFunds = newcurrentfund;
        }
        else {
            // Throws out an error if value is negative
            throw new ArithmeticException("Error: Invalid Input. Current funds must be greater than 0!");
        }
    }

    //wishlistCost methods
    
    public String getwishlistCost() { 
        return this.wishlistCost;  
    }
    private void appendToWishlistCost(double money) { //this method updates the new wishlist amount 
       wishlistCost += money;
    }

    //fundsUsed methods
    
    public String getFundsUsed(){ //allows for the fundsUsed variable to be used outside of this class
        return this.fundsUsed;  
    }
    private void addToFundsUsed(double amount){
        if (amount <= 0){
            throw new ArithmeticException("Error: Invalid Input. Amount added must be greater than 0!"); //the throw method here gives an error message if the value entered is negative. 
        }
        fundsUsed += amount; 
    }

    
    public void printList(){
        // prints the entire wishlist out
        System.out.println("-----Total Wishlist------");
        for(InventoryObject e: InventoryObject.items){
            System.out.println(printObjectWishlist(e));
        }
        System.out.println(------Total Cost----------\n"+wishlistCost);
    }
}
