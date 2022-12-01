//package com.carstore.mojo;
//
//public class Car {
//
//}
package com.carstore.mojo;

public class Car
{
	private int car_id;
	private String customer_name;
	private double custom_price ;
	
	//To Create Empty book Object
	public Car() {
	}
	// To Create Book with Name and Price only not id
	public Car(String customer_name, double custom_price) {
		super();
		this.customer_name = customer_name;
		this.custom_price = custom_price;
	}
	// To Create Book with all details like ID Name and Price.
	public Car(int car_id, String customer_name, double custom_price) {
		super();
		this.car_id = car_id;
		this.customer_name = customer_name;
		this.custom_price = custom_price;
	}
	//To Access the private variables outside the class we use 
	// Getters and Setters
		
	public int getCarId() {
		return car_id;
	}
	public void setCarId(int car_id) {
		this.car_id = car_id;
	}
	public String getCarName() {
		return customer_name;
	}
	public void setCarName(String customer_name) {
		this.customer_name = customer_name;
	}
	public double getCarPrice() {
		return custom_price;
	}
	public void setCarPrice(double custom_price) {
		this.custom_price = custom_price;
	}
	// To Print object data in String Format we use toString method.
	@Override
	public String toString() {
		return "Book [bookId=" + car_id + ", bookName=" + customer_name + ", bookPrice=" + custom_price + "]";
	}
	
	

	public static void main(String[] args) 
	{
		Car b1 = new Car();
		// We create empty book object.
		Car b2 = new Car("Core Java",450.65);
		// We create book object with Name and Price 
		Car b3 = new Car(101,"Advance Java",555.55);
		// We create book object with All Details like Id, Name, Price 

		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
	}

	
}
