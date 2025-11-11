package packageName;

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
		
	}
	
}
