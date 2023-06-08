package Project2;
/*
 * Jimmy Le
 * 202457646
 * Burger211 class is a super class that creates the three objects for the burger. It has abstract and regular methods that would be used
 * in sub classes to print out desired things like name, topping, and price.
 */
import java.util.*;
//class burgerInfo creates a constructor that stores the name, topping, price of the specific burger.
class BurgerInfo{
	String name;
	String toppings;
	double price;
	public BurgerInfo(String name, String toppings, double price) {
		this.name = name;
		this.toppings = toppings;
		this.price = price;
	}
}
abstract class Burger211{
	private ArrayList<BurgerInfo> Burger = new ArrayList<>();
	public static double[] price = {3.0, 3.5, 2.0};
	abstract void printMenu();
	abstract void Promotion(double discount, String promoteReason);
	public Burger211() {//created constructor that initializes each 3 burger and their default topping, name, and price.
		BurgerInfo b1 = new BurgerInfo("Inheritance Burger", "beef patty, tomato, onion, ranch sauce", price[0]);
		Burger.add(b1);
		BurgerInfo b2 = new BurgerInfo("Override Burger","beef patty, lime, onion, lettuce, tomato sauce",price[1]);
		Burger.add(b2);
		BurgerInfo b3 = new BurgerInfo("Polymorphism Burger","chicken breast, gallo, onion, ranch sauce",price[2]);
		Burger.add(b3);
	}
	public int getHowManyBurgers() {
		return Burger.size();
	}
	public String getName(int i) {
		return Burger.get(i).name;
	}
	public String getToppings(int i) {
		return Burger.get(i).toppings;
	}
	public double getPrice(int i) {
		return Burger.get(i).price;
	}
	//created a setter method called setTopping that sets the new desired topping for the specific burger object.
	public void setTopping(int i, String newTopping) {
		Burger.set(Burger.indexOf(Burger.get(i)), new BurgerInfo(getName(i),newTopping, price[i]));
	}
	//initialized updateTopping within the super class as well because myFranchise created a polymorphism run-time object which means
	//every new method created in the Menu must also be in Burger211(super class).
	public void updateTopping(int burgerNumber, String newTopping) {}
	
}