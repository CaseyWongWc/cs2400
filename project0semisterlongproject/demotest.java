package project0semisterlongproject;
import java.time.LocalDate;    

public class demotest 
{
    /*public static void main(String[] args) 
    {
        
    }
    
    // Pseudo-Code for logging visitors
    public void logVisitors(int numberOfVisitors, LocalDate visitDate) {
        // Generate a unique ID for the group
        // Store numberOfVisitors, visitDate, and the unique ID
    }

    // Pseudo-Code for tracking donations
    public void addDonation(DonationType type, int quantity) {
        // DonationType could be MONEY, CLOTHING, CROPS
        // Add the donation to the Bag data structure
    }

    // Pseudo-Code for saving data to a CSV
    public void saveToCSV() {
        // Open or create a CSV file
        // For each logged visitor and donation entry, convert to CSV format
        // Write to the file
    }*/

    public static void main(String[] args) 
    {    
        LocalDate date = LocalDate.now();    
        LocalDate yesterday = date.minusDays(1);    
        LocalDate tomorrow = yesterday.plusDays(2);    
        System.out.println("Today date: "+date);    
        System.out.println("Yesterday date: "+yesterday);    
        System.out.println("Tomorrow date: "+tomorrow);  
        //https://www.javatpoint.com/java-localdate
        //https://www.geeksforgeeks.org/object-class-in-java/  
        
      }    
    

}
