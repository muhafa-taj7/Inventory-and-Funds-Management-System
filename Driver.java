// MustafaTajammul, Abdurrahim Rana, Shui
// Driver
import java.util.*;
public class Driver{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    
    System.out.println("Welcome to the Inventory and Funds Management System for FRC Teams.\nWhat is your team name?");
    String name = scan.nextLine();
    Funds fundsAccount = new Funds(name);

    System.out.println("\nHow much money does your team currently have?");
    int startAmount = scan.nextInt();
    fundsAccount.setCurrentFunds(startAmount);

    System.out.println("\nThis Management system has a very user-friendly system. Let's add some items to your wishlist!");
   
    System.out.println("What is the name of your item?");
    String userName = scan.next();
    scan.nextLine();
    System.out.println("How many do you want to add to your wishlist?");
    int addAmount = scan.nextInt();
    System.out.println("How much does this item cost?");
    double itemCost = scan.nextDouble();
    InventoryObject usermade = new InventoryObject(userName,addAmount,itemCost,fundsAccount);
  
    System.out.println("You made the following object:" + usermade.toString());

    System.out.println("");
    
    System.out.println("Here are your current funds: $" + fundsAccount.getCurrentFunds());
    System.out.println("\nLet's add some funds! How much do you want to add?");
    int addamnt = scan.nextInt();
    fundsAccount.addToTotalRaisedFunds(addamnt);
    System.out.println("Here are your current funds now: $" + fundsAccount.getCurrentFunds());
    
    System.out.println("There are several different things you can do.\n - Put an item on your wishlist\n - Edit the item on your wishlist\n - Add a new item to your wishlist\n - Purchase an item off of the wishlit");
    System.out.println("\n");

    System.out.println("Lets add another object!");  
    System.out.println("What is the name of your item?");
    userName = scan.next();
    scan.nextLine();
    System.out.println("How many do you want to add to your wishlist?");
    addAmount = scan.nextInt();
    System.out.println("How much does this item cost?");
    itemCost = scan.nextDouble();
    InventoryObject usermade2 = new InventoryObject(userName,addAmount,itemCost,fundsAccount);

    System.out.println("\nYou made the following object:" + usermade2.toString());

    System.out.println("\nLet's buy some of these objects. How many do you want to buy?");
    int purchaseAmount = scan.nextInt();
    usermade2.purchase(purchaseAmount);

    System.out.println("Here is your object afterward: \n" + usermade2.toString());
    System.out.println("Here are your current funds now: $" + fundsAccount.getCurrentFunds());

    System.out.println("\nWe can also create an object without putting an amount on the wishlist. This will set wishlist value equal to 0.");
    System.out.println("What is the name of your item?");
    userName = scan.next();
    scan.nextLine();
    System.out.println("How much does this item cost?");
    itemCost = scan.nextDouble();
    InventoryObject usermade3 = new InventoryObject(userName,itemCost,fundsAccount);
    System.out.println("\nYou made the following object:"+usermade3+"\n");
    
    scan.next();
    //rana
    System.out.println("\nLet's look at our current wishlist");
    fundsAccount.printList();
    
    scan.next();
    
    //rana
    System.out.println("\nLet's look at our financial history");
    fundsAccount.printFinancialSummary();
    
    scan.next();

    System.out.println("Let's make another account for your FLL team!!\nWhat is your team name?");
    name = scan.next();
    Funds otherFundsAccount = new Funds(name);

    System.out.println("\nHow much money does your team currently have?");
    startAmount = scan.nextInt();
    otherFundsAccount.setCurrentFunds(startAmount);

    System.out.println("\nLets add another object!");  
    System.out.println("What is the name of your item?");
    userName = scan.next();
    scan.nextLine();
    System.out.println("\nHow many do you want to add to your wishlist?");
    addAmount = scan.nextInt();
    System.out.println("\nHow much does this item cost?");
    itemCost = scan.nextDouble();
    InventoryObject fllobject1 = new InventoryObject(userName,addAmount,itemCost,otherFundsAccount);

    System.out.println("\nYou made the following object:" + fllobject1.toString());

    //rana
    System.out.println("\nLet's look at our current wishlist");
    fundsAccount.printList();

    //rana
    System.out.println("\nLet's look at our financial history");
    fundsAccount.printFinancialSummary();

     //rana
    System.out.println("\nThank you for using the Account Funds Management System!");
    System.out.println("We hope to see you again soon!\n");
  }
}