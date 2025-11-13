package packageName;

import java.io.IOException;

public class VenueRunner {

	public static void main(String[] args) throws IOException {
		System.out.println("Create new venue with 20 rows of 50 columns with default price of 50.00.");  
        Venue venue = new Venue(20, 50, 50.0);  
  
        System.out.println("Set first 4 rows to premium with price 100.00.");  
        int row = 0;  
        while(row < 5){  
            venue.setPremium(row, 100.00);  
            row++;  
        }  
  
        System.out.println("Set center 9 seats in rows 5 through 10 as premium with price 75.00.");  
        row = 5;  
        while(row < 11){  
            venue.setPremium(row, 20, 29, 75.00);  
            row ++;  
        }  
  
        System.out.println("Set last 5 rows to general admission with price 25.00.");  
        row = 14;  
        while(row < 20){  
            venue.setGA(row, 25.00);  
            row++;  
        }  
  
        if(venue.importTickets("sold.txt")){  
            System.out.println("\nTotal Revenue: " + venue.totalRevenue()); // 8650.0  
            System.out.println("Total Revenue, Column 27: " + venue.totalRevenue(27)); // 225.0  
  
            System.out.println("\nTotal Sold: " + venue.totalSold()); // 150  
            System.out.println("Total Sold, Row 10: " + venue.totalSold(10)); // 9  
  
            System.out.println("\nMax Ticket Price, Row 0-19, Column 0-49: " + venue.maxPrice(0,19,0,29)); // 100.0  
            System.out.println("Max Ticket Price, Row 5-16, Column 20-27: " + venue.maxPrice(5,16,20,27)); // 75.0  
  
            System.out.println("\nContains GA, Row 7: " + venue.containsGA(7)); // false  
            System.out.println("Contains GA, Row 18: " + venue.containsGA(18)); // true  
  
            System.out.println("\nAll are Premium, Col 24: " + venue.allPremium(24)); // false  
        }  
  
  
        //venue.printVenue();  
        //venue.printVenueType();  
        //venue.printVenuePrice();  


	}

}
