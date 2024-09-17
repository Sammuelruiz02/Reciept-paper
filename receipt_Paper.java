package assignment1;

import java.util.Random;
import java.util.Scanner;

public class Ruiz_Sammuel {

   //This is the private class for the random receipt number
    private static void printreceipt(){

        int receipt = (int) (Math.random() * 1000) + 1000;
        System.out.println(receipt);

    }
    // This is the private class for the random date generator
    private static void printdate(){

        Random random = new Random();
        int year = 1900 + random.nextInt(2100-1900);

        int day = 1 + random.nextInt(28);

        int month = 1 + random.nextInt(12);

        System.out.println(" " + getMonthName(month) + " " + day + " " + year);
    }
    //This is to convert the month numv
    private static String getMonthName(int month) {
        String[] months = { "January", "February", "March", "April", "May", "June", 
                            "July", "August", "September", "October", "November", "December" };
        return months[month - 1];  // Array is 0-indexed, so subtract 1
    }

   

    private static final String ANSI_BLUE = "\033[34m";  // Ansi code in order to have blue text of user input
    private static final String ANSI_RESET = "\033[0m"; // reset back to white text 
    private static final String ANSI_CURSOR_UP = "\033[A"; // Move cursor up
    private static final String ANSI_CLEAR_LINE = "\033[K";  // deletes the previous line





    public static void main(String[] args){

      
    

        

        //This prints out the top of the receipt
     System.out.println("\n\n ******************************\n" + 
     " ****** S store ***************\n " +
     "******************************  ") ;
     
     System.out.print(" receipt number" + "      "); printreceipt();
     printdate();
     
     // calling in the scanner which is the user input
     Scanner scanner = new Scanner(System.in);
     
     // declaring the item number, item count, initial tax rate, and total sum used to add up all the items on the receipt
     int itemNum = 1;
     int itemCount = 0;
     double taxRate = 0.0; 
     double totalsum = 0.0;


        //while loop to keep asking the user if they have any more items to list
     while (true){ 

        // ask the user of the items name
        System.out.print(" Write item name " );
        String item_Name = scanner.nextLine();

        // if statement just in case user inputs DONE and then prints the item count and the total of the receipt including the bottom portion of the receipt
        if (item_Name.equalsIgnoreCase("DONE")) {
            System.out.println(" " + itemCount + " items      " + totalsum + "\n ******************************\n" + //
                                " ******************************\n" + //
                                " ******************************\n" + //
                                "");
            scanner.close(); // Closes the scanner before exiting
            System.exit(0); // Exit the program
        }
            


        System.out.print(ANSI_CURSOR_UP); 
        System.out.print(ANSI_CLEAR_LINE); 
        System.out.println(" Write item name " + ANSI_BLUE  + item_Name + ANSI_RESET);
            
        if (item_Name.equalsIgnoreCase("Food")) {
            taxRate = 0.0; // Set tax to 0% for food items
        } else {
            taxRate = 0.30; // Set tax to 30% for non-food items
        }

        System.out.print(" Write Price ");





        Double price = scanner.nextDouble();
        scanner.nextLine();

        double totalPrice = price + (price * taxRate);
        totalPrice = Math.round(totalPrice); // Round to the nearest ones place
        long roundtotal = Math.round(totalPrice); 
        totalsum += roundtotal;

        System.out.print(ANSI_CURSOR_UP); 
        System.out.print(ANSI_CLEAR_LINE); 
        System.out.println(" Write Price " + ANSI_BLUE  + price + ANSI_RESET);
            

       
        System.out.printf(" item number %d: %s Total: %.1f\n", itemNum, item_Name, totalPrice);
        
        itemNum++; // increments the amount of every item on the recceipt
        itemCount++; // counts how many items are in total on the receipt
        

      }



    }

    
}


