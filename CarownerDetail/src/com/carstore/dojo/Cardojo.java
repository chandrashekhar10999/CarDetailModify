
package com.carstore.dojo;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

 import com.carstore.mojo.Car;

public class Cardojo 
{
	// To Communicate with Database we use at-least 3 Interface of JDBC API.
	Connection con = null;  // It connection between Java Application and Database.
	Statement stmt = null;  // it Used to Execute SQL Statement on database.
	PreparedStatement ps = null;
	/*
	 	PreparedStatement is Child interface of Statement interface.
	 	It used perform dynamic SQL Queries on database
	 */
	
	ResultSet rs = null;   // It used to store the data of database retrieve by SQL Query. 
	
	
	
	/*
	  		As you All to Connect with database initial 3 step are commons
	  		so don't write steps again and again wo that's why we create a seprated method 
	  		for that.
	 */
	
	public Connection getCon()
	{
		try
		{
			//JDBC step-2 Register the JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// JDBC Step-3 Establish the Connection with Database.
			
			String URL="jdbc:mysql://localhost:3306/jdbc";
			String user="root";
			String password="";
			Connection con = DriverManager.getConnection(URL,user,password);
			
			return con;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; // if Connections is not establish then it returns Null.
	}
	
	
	
	// We create this method to add book in database.
	public void addCar(Car car)
	{
		// Write the logic to add book detail in database.
		con = getCon();
		// here we execute Dynamic SQL Query 
		try
		{
			ps  = con.prepareStatement("insert into custom_car(customer_name,custom_price) values (?,?)");
			// here ? are the placeholder for the Book name and price respectively.
			//
			
			// Now we set the ? with thier values .
			ps.setString(1,car.getCarName());
			ps.setDouble(2,car.getCarPrice());
			
			int row = ps.executeUpdate();
			
			System.out.println(row+" Inserted...");
			
			ps.close();
			con.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
	}
	
	public List<Car> getAllCars()
	{
		List<Car> booklist = new ArrayList<Car>();
		
		// here you have to create a logic to get book details from 
		// database.
		try 
		{
			con = getCon();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * From Custom_car");
			
			// Now we add rs data into booklist in book object from.
			
			while(rs.next()) // check that rs have any row or not
			{
				// if there is row in row then we create a object of that row 
				Car car = new Car(rs.getInt(1), rs.getString(2), rs.getDouble(3));
				// here we add that object into booklist
				booklist.add(car);		
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return booklist;
	}
	
	 public boolean deleteCar(int car_id)
	{
		con = getCon();
		try 
		{
			ps = con.prepareStatement("delete from Custom_car where car_id=?");
			
			ps.setInt(1, car_id); // here we set the value to the ? of query.
			
			int row = ps.executeUpdate();
			
			if(row>0)
			{
				return true;
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}// end delete method.
	
	public  boolean updateCar(int car_id,Car car)
	{
		con = getCon();
		try 
		{
			ps = con.prepareStatement("update book set customer_name=?,custom_price=? where car_id=?");
			ps.setString(1, car.getCarName());
			ps.setDouble(2,car.getCarPrice());
			ps.setInt(3, car_id);
			
			int row = ps.executeUpdate();
			
			if(row>0)
			{
				return true;
			}
			ps.close();
			con.close();
		} 
		catch (SQLException e) 
		{	
			e.printStackTrace();
		}
		return false; // by default returns false.
	}
	
	public  boolean updateCar(int car_id,String customer_name)
	{
		con = getCon();
		try 
		{
			ps = con.prepareStatement("update book set customer_name=? where car_id=?");
			ps.setString(1, customer_name);
			ps.setInt(2, car_id);
			
			int row = ps.executeUpdate();
			
			if(row>0)
			{
				return true;
			}
			ps.close();
			con.close();
		} 
		catch (SQLException e) 
		{	
			e.printStackTrace();
		}
		return false; // by default returns false.
	}
	

 
	 
	 
	

// Main method only for the testing nothing else.	
	public static void main(String[] args) 
	{
		Car b1 = new Car("Angular-10", 745.65);
		
		Cardojo cardo = new Cardojo();
		cardo.addCar(b1);
		
		List<Car> blist = cardo.getAllCars(); 
		//System.out.println(blist);   // to print all book on one line only.
		
		for(Car b:blist) 
		{
			System.out.println(b);
		}
		
		// Testing Connection method.
		Connection con =  cardo.getCon();
		System.out.println(con!=null);
	}
}