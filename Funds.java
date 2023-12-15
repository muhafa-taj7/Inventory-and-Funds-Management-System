public class Funds{
    private String teamName;
    private double totalRaisedFunds;
    private double currentFunds;
    private double fundsUsed; 
    private double wishlistCost; 
    //these are all the instance variables for the methods used below   /*shui*/

    
    //constructor for the Funds object  /*rana*/
    public Funds(String teamName) {
        this.teamName = teamName;
        totalRaisedFunds = 0;
        currentFunds = 0;
        fundsUsed = 0;
        wishlistCost = 0;
    }
    
    //totalRaisedFunds methods  /*rana*/

    // method to return teamName /*rana */
    public String getTeamName() {
        return teamName;
    }
    // Gets the total number of raised funds 
    public double getTotalRaisedFunds() {
        return totalRaisedFunds;
    }
    // Adds more funds to the totalRaisedFunds variable, must be positive
    public void addToTotalRaisedFunds(double addamount) {
        if (addamount > 0) {
            totalRaisedFunds += addamount;
            currentFunds += addamount; 
        }
        else {
            // Displays an error if the value is negative
            throw new ArithmeticException("Error: Invalid Input. Amount added must be greater than 0!");
        }
    }

    //currentFunds methods /*rana*/
    
    // Gets the current amount of funds in the account
    public double getCurrentFunds() {
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

    //wishlistCost methods  /*shui*/
    
    public double getWishlistCost() { 
        return this.wishlistCost;  
    }
    public void appendToWishlistCost(double money) { //this method updates the new wishlist amount 
       wishlistCost += money;
    }

    //fundsUsed methods  /*shui*/
    
    public double getFundsUsed(){ //allows for the fundsUsed variable to be used outside of this class
        return this.fundsUsed;  
    }
    public void addToFundsUsed(double amount){
        if (amount <= 0){
            throw new ArithmeticException("Error: Invalid Input. Amount added must be greater than 0!"); //the throw method here gives an error message if the value entered is negative. 
        }
        else{
        	fundsUsed += amount; 
            currentFunds-=amount;
        }
    }

    
    public void printList(){
        // prints the entire wishlist out  /*taj*/
        System.out.println("-----"+this.getTeamName()+"'s Wishlist------");
        for(InventoryObject e: InventoryObject.items){
            System.out.println(InventoryObject.getObjectWishlist(e));
        }
        System.out.println("    ------Total Cost----------\n"+this.getWishlistCost());
    }

    //used to show the user the financial history of the account /*shui */
    public void printFinancialSummary(){
        System.out.println("-----" + this.getTeamName() + "'s Financial Summary------");
        System.out.println("Total Funds Raised: " + this.getTotalRaisedFunds());
        System.out.println("Total Funds Used: " + this.getFundsUsed());
        System.out.println("Current funds: " + this.getCurrentFunds());
    }
}
