package refactoring.dto;

import java.util.ArrayList;
import java.util.List;

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
	
	public String statement(){
		//대여료와  적립포인트 출력
		
		StringBuilder sb = new StringBuilder();
		sb.append(getName() + "고객님의 대여기록\n");
		for(Rental each : rentals){
			
			sb.append(String.format("\t%s \t %s%n", each.getMovie().getTitle(), each.getCharge()));
			
			
		}//for loop
		
		sb.append(String.format("누적대여료 : %s%n적립 포인트 : %s%n", getTotalCharge(), getTotalfrequentRanterPoints()));
		
		return sb.toString();

	}

	private int getTotalfrequentRanterPoints() {
		// TODO Auto-generated method stub
		int result=0;
		for(Rental each : rentals){
			result +=each.getFrequentRentalPoints();
		}
		return result;
		
	}

	private double getTotalCharge() {
		// TODO Auto-generated method stub
		double result=0.0;
		for(Rental each : rentals){
			result +=each.getCharge();
		}
		return result;
	}

	

	
}
