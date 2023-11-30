import java.util.*;
public class Driver}{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    
    System.out.println("Welcome to the Inventory and Funds Management System for FRC Teams.\nWhat is your team name?");
    String name = scan.nextLine();
    Funds fundsAccount = new Funds(name);

    System.out.println("\nHow much money does your team currently have?");
    int startAmount = scan.nextInt();
    fundsAccount.setCurrentFunds(startAmount);

    System.out.println("\nThis Management system has a very user-friendly system. Let's add some items to your wishlist!");
    boolean canContinue = true;
    if (canContinue){
      System.out.println("What is the name of your item?");
      String name = scan.nextLine();
      System.out.println("How many do you want to add to your wishlist?");
      int addAmount = scan.nextInt();
      System.out.println("How much does this item cost?");
      int itemCost = scan.nextInt();
    }
    
    System.out.println("There are several different things you can do.\n - Put an item on your wishlist\n - Edit the item on your wishlist\n - ");

    
  }
}
