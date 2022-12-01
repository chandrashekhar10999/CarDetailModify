//package com.carstore.dojo;
//
//public class I_CarDojo {
//
//}

package com.carstore.dojo;

import java.util.List;

import com.carstore.mojo.Car;


// Here we create a blueprint of the Dao class 
// On which we write logic to peform opertions.
public interface I_CarDojo 
{
	void addCar(Car book);
	List<Car> getAllCars();
	boolean deleteCar(int car_id);
	boolean updateCar(int car_id,Car car);
	
	
	// Method 
	Car getCar(int car_id);
	List<Car> getCar(String customer_name);
}
