package Project2;
/*
 * Menu is a subclass of Burger211 and it initializes the abstract method from burger211 where it will implement the exchange rate and 
 * create the GUI where the menu pops up.
 */
import java.text.DecimalFormat;
import java.util.*;
public class Menu extends Burger211{
	String country;
	String franchise;
	double discountRate;
	String promotion;
	String currencyCode;
	String currencySymbol;
	double ExchangeRate;
	int updatedBurgerNum;
	String updatedTopping;
	static ExchangeRate convert;
	public Menu() {
		super();
	}
	public Menu(String country, String franchise) {
		this.country = country;
		this.franchise = franchise;
		Locale locale = new Locale.Builder().setRegion(country).build();
		currencyCode = Currency.getInstance(locale).getCurrencyCode();
		currencySymbol = Currency.getInstance(locale).getSymbol();
		try {
			convert = new ExchangeRate();
			ExchangeRate = convert.getRate(currencyCode);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void printMenu() {
		DecimalFormat df = new DecimalFormat("#,###,###.00");
		//created a string array that will store the local price of the specific burger which would be called in the menuGUI
		String[] localPrice = new String[getHowManyBurgers()];
		
		for(int i = 0; i < getHowManyBurgers(); i++) {//Gets the price of the specific country and adds discount rate(if > 0) and adds to localPrice array
			double price = getPrice(i);
			if(discountRate>0.0) {
				price *= ((1-discountRate));
				localPrice[i] = df.format(price);
				localPrice[i] += " (regular: " + df.format(getPrice(i)) + ")";
				
			}else {
				localPrice[i] = df.format(price);
			}
		}
		new MenuGUI(franchise,promotion,getName(0),currencySymbol+localPrice[0], getToppings(0), getName(1), currencySymbol+localPrice[1], getToppings(1), getName(2), currencySymbol+localPrice[2], getToppings(2));
	}
	//sets promotion reason to promotion and the discountRate to discount variable.
	public void Promotion(double discountRate, String promoteReason) {
		promotion = promoteReason;
		this.discountRate = discountRate;
	}
	@Override
	//Two override methods
	public double getPrice(int i) {
		return super.getPrice(i)*ExchangeRate;
	}
	public String getToppings(int i) {
		return super.getToppings(i);
	}
	//Created updateTopping that calls super method setTopping and sets new topping for the specific burger.
	public void updateTopping(int i, String newTopping) {
		super.setTopping(i, newTopping);
	}
	
}
