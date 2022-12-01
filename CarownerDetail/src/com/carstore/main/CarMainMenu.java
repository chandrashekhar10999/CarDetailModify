//package com.carstore.main;
//
//public class CarMainMenu {
//
//}

package com.carstore.main;

import java.util.List;
import java.util.Scanner;
 

import com.carstore.dojo.Cardojo;
import com.carstore.mojo.Car;

public class CarMainMenu {

	public static void menu()
	{
		System.out.println("1. Add Custom_car");
		System.out.println("2. Show All Custom_car");
		System.out.println("3. Delete Custom_car Detail");
		System.out.println("4. Update Custom_car Detail");
		System.out.println("5. Exit  ");
	}
	
	public static void main(String[] args)
	{
		int choice=0;
		int uchoice=0;
		Scanner sc = new Scanner(System.in);
		
		int id;
		String name;
		double price;
		
		Car b;
 		
		Cardojo cardojo = new Cardojo();
		
		List<Car> blist = null;
		
		boolean flag=false;
		
		while(choice!=5)
		{
			menu(); // one static can call another static method of same class directly
			System.out.println("Select your Choice");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("Enter New Custom_car Details ");
				System.out.println("Custom_car Name:- ");
				sc.nextLine();
				name = sc.nextLine();
				
				System.out.println("Custom_car Price");
				price = sc.nextDouble();
				
				b = new Car(name, price);
				
				cardojo.addCar(b);
				System.out.println("\n\n Custom_car is Added...\n\n");
				break;
			case 2:
				blist = cardojo.getAllCars();
				System.out.println("----------------------------  Custom_car List  ----------------------------");
				for(Car obj :blist)
				{
					System.out.println(obj);
					System.out.println("--------------------------------------------------------------------");
				}
				System.out.println("______________________________List Ended______________________________");
				
				break;
			case 3:
				System.out.println("Enter a Custom_car Id to delete Custom_car");
				id = sc.nextInt();
				
				flag = cardojo.deleteCar(id);
				
				if(flag==true)
				{
					System.out.println("\n\nBook is Deleted.\n\n");
				}else{
					System.out.println("\n\nBook is Not Deleted.\n\n");
				}
				break;
			case 4:
				while(uchoice != 4) 
				{
					System.out.println("1.Update Name:- ");
					System.out.println("2.Update Price:- ");
					System.out.println("3.Update Both:- ");
					System.out.println("4.Stop");
					System.out.println("Select your choice for update");
					uchoice = sc.nextInt();
					
					System.out.println("Enter a book Id to Update Custom_car");
					id = sc.nextInt();
					
					System.out.println("Enter Updated Book Details of bookId:="+id);
					
					
					switch(uchoice) {
					
					case 1:
						System.out.println("Custom_car Name:- ");
						name = sc.next();
						
						flag = cardojo.updateCar(id, name);
						break;
					case 2:
						System.out.println("Under Progress....");
						break;
					case 3:
						System.out.println("Custom_car Name:- ");
						name = sc.next();
						System.out.println("Custom_car Price");
						price = sc.nextDouble();
						
						b  = new Car(name, price);
						flag = cardojo.updateCar(id, b);
						break;
					}
					if(flag==true)
					{
						System.out.println("\n\nCustom_car is Updated.\n\n");
					}else{
						System.out.println("\n\nCustom_car is Not Updated.\n\n");
					}
				}// while End
				uchoice=0;
				break;
			case 5:
				System.out.println("Thank You...:)");
				break;
			default:
				System.err.println("\n\nInvalid Choice\n\n");
				break;
				
			}
		}

	}

}

