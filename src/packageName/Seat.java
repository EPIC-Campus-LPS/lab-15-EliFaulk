package packageName;

public class Seat {
	
	private boolean sold;
	private String type;
	private double price;
	
	public Seat(boolean s, String t, double p) {
		sold = s;
		type = t;
		price = p;
	}
	
	//Getters
	public boolean getSold() {
		return sold;
	}
	
	public String getType() {
		return type;
	}
	
	public double getPrice() {
		return price;
	}
	
	
	//Setters
	public void setSold(boolean s) {
		sold = s;
	}
	
	public void setType(String t) {
		type = t;
	}
	
	public void setPrice(double p) {
		price = p;
	}
}
