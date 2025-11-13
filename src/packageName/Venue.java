package packageName;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class Venue {

	private Seat[][] seats;
	
	public Venue(int row, int col, double price) {
		seats = new Seat[row][col];
		
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length; j++) {
				seats[i][j] = new Seat(false, "R", price);
			}
		}
	}
	
	
	public boolean buyTicket(int row, int col) {
		Seat seat = seats[row][col];
		if (seat.getSold()) {
			return false;
		} else {
			seats[row][col].setSold(true);
			return true;
		}
	}
	
	
	public boolean isAvailable(int row, int col) {
		return seats[row][col].getSold();
	}
	
	public void setPremium(int row, double price) {
		for (int i = 0; i < seats[row].length; i++) {
			seats[row][i].setPrice(price);
			seats[row][i].setType("P");
		}
	}
	
	public void setPremium (int row, int colStart, int colEnd, double price) {
		for (int i = colStart; i < colEnd; i++) {
			seats[row][i].setPrice(price);
			seats[row][i].setType("P");
		}
	}
	
	public void setGA(int row, double price) {
		for (int i = 0; i < seats[row].length; i++) {
			seats[row][i].setPrice(price);
			seats[row][i].setType("G");
		}
	}
	
	public boolean importTickets(String filename) throws IOException {
		File file = new File(filename);
		Scanner sc = new Scanner(file);
		
		while (sc.hasNextLine()) {
			String[] coords = sc.nextLine().split(",");
			int x = Integer.parseInt(coords[0]);
			int y = Integer.parseInt(coords[1]);
			seats[x][y].setSold(true);
		}
		sc.close();
		
		return true;
	}
	
	public double totalRevenue() {
		double total = 0;
		for (Seat[] row : seats) {
			for (Seat seat : row) {
				if (seat.getSold()) {
					total += seat.getPrice();
				}
			}
		}
		return total;
	}
	
	public double totalRevenue(int col) {
		double total = 0;
		for (Seat[] row : seats) {
			if (row[col].getSold()) {
				total += row[col].getPrice();
			}
		}
		return total;
	}
	
	public int totalSold() {
		int total = 0;
		for (Seat[] row : seats) {
			for (Seat seat : row) {
				if (seat.getSold()) {
					total++;
				}
			}
		}
		return total;
	}
	
	public int totalSold(int row) {
		int total = 0;
		for (Seat seat : seats[row]) {
			if (seat.getSold()) {
				total++;
			}
		}
		return total;
	}
	
	public void printVenue() {
		for (Seat[] row : seats) {
			for (Seat seat : row) {
				if (seat.getSold()) {
					System.out.print("[X] ");
				} else {
					System.out.print("[ ] ");
				}
			}
			System.out.print("\n");
		}
	}
	
	public void printVenueType() {
		for (Seat[] row : seats) {
			for (Seat seat : row) {
				System.out.print("[" + seat.getType() + "] ");
			}
			System.out.print("\n");
		}
	}
	
	public void printVenuePrice() {
		for (Seat[] row : seats) {
			for (Seat seat : row) {
				System.out.print("[" + seat.getPrice() + "] ");
			}
			System.out.print("\n");
		}
	}
	
	public double maxPrice(int rowStart, int rowEnd, int colStart, int colEnd) {
		double max = 0;
		for (int x = rowStart; x <= rowEnd; x++) {
			for (int y = colStart; y <= colEnd; y++) {
				if (seats[x][y].getPrice() > max) {
					max = seats[x][y].getPrice();
				}
			}
		}
		return max;
	}
	
	public boolean containsGA(int row) {
		for (Seat seat : seats[row]) {
			if (seat.getType().equals("G")) {
				return true;
			}
		}
		return false;
	}
	
	public boolean allPremium(int col) {
		for (Seat[] row : seats) {
			if (!row[col].getType().equals("P")) {
				return false;
			}
		}
		return true;
	}
}
