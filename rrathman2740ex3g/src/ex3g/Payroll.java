package ex3g;

import java.text.DecimalFormat;


public class Payroll {
	
	private int id;
	private String name;
	private Double payRate;
	private double hours;
	
	
	public Payroll(int id, String name, Double payRate) {
		super();
		this.id = id;
		this.name = name;
		this.payRate = payRate;
		this.hours = 0;
	}


	public int getId() {
		return this.id;
	}


	public boolean setId(int id) {
		if (id > 100) {
			this.id = id;
			return true;
		}
		else {
			return false;
		}
	}


	public String getName() {
		return this.name;
	}


	public boolean setName(String name){ 
		 if (name.isEmpty()) return false; 
		 else { 
			 this.name = name; 
			 return true; 
		 } 
	} 



	public Double getPayRate() {
		return this.payRate;
	}


	public boolean setPayRate(double payRate) { 
		 if (payRate >= 7.25 && payRate <= 100.00) { 
			 this.payRate = payRate; 
			 return true; 
		 } 
		 else return false; 
		 } 


	public double getHours() {
		return this.hours;
	}


	public void setHours(double hours) {
		this.hours = hours;
	}


	@Override
	public String toString() {
		return id + " " + name + ", payRate = " + payRate;
	}

	public double calcGrossPay() {	 
		 
		//Gross pay with any overtime
		
		double grossPay; //Gross pay
		double overtimePay; //Overtime pay
		
		//Determine if emp worked over 40 hours or not
		
		if (this.hours > 40){
			
			//Calculate first 40 hours
			
			grossPay = 40 * this.payRate;
			
			//Calculate overtime at 1.5 times regular pay rate
			
			overtimePay = (this.hours - 40) * (this.payRate * 1.5);
			
			//Add overtime to regular pay
			
			grossPay += overtimePay;
			
		}
		
		else{
			
			//no overtime worked
			
			grossPay = this.payRate * this.hours;
			
		}
		
		return grossPay;
		
	}	 
	
	public boolean addHours(double hours) { 
		 if (hours >= 0.1 && hours <=20) { 
			 this.hours += hours; 
			 return true; 
		 }
		 
		 else return false; 
		 		 
	} 


/*
	public boolean setId(int id) {
		if (id > 100) {
			this.id = id;
			return true;
		}
		else {
			return false;
		}
	}
 */

}
