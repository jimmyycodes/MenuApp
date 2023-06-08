package Project2;
import java.util.*;
/*
 * Jimmy Le 
 * 202457646
 * myFranchise asks users for specific questions that builds their menu. 
 */
public class myFranchise{
	public static void main(String[] args) {
		String country;
		String franchiseName;
		int discount;
		String promotion = "";
		int burgerNumber;
		String newTopping;
		Scanner input = new Scanner(System.in);
		System.out.println("\nProject 2. Burger 211. (Winter Quarter 2022)");
		boolean run = true;
		while(run) {
			System.out.println("\nEnter country name. (Alpha-2 code)");
			country = input.next();
			if(country.equals("0")) {
				run = false;
				System.out.println("Bye!");
				break;
			}else {
				input.nextLine();
				System.out.println("Enter your franchise name.");
				franchiseName = input.nextLine();
				
				System.out.println("Enter discount rate %(0~99)");
				discount = input.nextInt();
				
				if(discount > 0) {
					input.nextLine();
					System.out.println("Enter promotion");
					promotion = input.nextLine();
				}
				Burger211 franchise = new Menu(country, franchiseName);
				System.out.println("\nWhich burger would you like to change the topping?(enter "+franchise.getHowManyBurgers()+" if not)\n");
				for(int i = 0; i < franchise.getHowManyBurgers(); i++) {
					System.out.println(i+ ". " + franchise.getName(i) + ": " + franchise.getToppings(i));
				}
				burgerNumber = input.nextInt();
				if(burgerNumber<franchise.getHowManyBurgers()) {
					input.nextLine();
					System.out.println("\nEnter new toppings of burger " + burgerNumber);
					newTopping = input.nextLine();
					franchise.setTopping(burgerNumber, newTopping);
				}
				franchise.Promotion((double)discount/100.0, promotion);
				franchise.printMenu();
			}
		}
	}
}
