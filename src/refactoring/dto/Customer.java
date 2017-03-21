package refactoring.dto;

import java.util.ArrayList;
import java.util.List;

import refactoring.statement.HtmlStatement;
import refactoring.statement.Statement;
import refactoring.statement.TextStatement;

public class Customer {
	private String name;
	private List<Rental> rentals;
	
	
	

	public Customer(String name) {
		super();
		this.name = name;
		this.rentals = new ArrayList<>();
	}

	public String getName() {
		return name;
	}
	
	public void addRental(Rental aRental){
		this.rentals.add(aRental);
	}
	
	
	
	public List<Rental> getRentals() {
		return rentals;
	}

	public String statement(){
		Statement stmt = new TextStatement();
		return  stmt.value(this);
	}
	
	public String htmlStatement(){
		Statement stmt = new HtmlStatement();
		return stmt.value(this);
	}

	public int getTotalfrequentRanterPoints() {
		// TODO Auto-generated method stub
		int result=0;
		for(Rental each : rentals){
			result +=each.getFrequentRentalPoints();
		}
		return result;
		
	}

	public double getTotalCharge() {
		// TODO Auto-generated method stub
		double result=0.0;
		for(Rental each : rentals){
			result +=each.getCharge();
		}
		return result;
	}

	

	
}
