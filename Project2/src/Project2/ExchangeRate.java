package Project2;
/*
 * Exchange rate class calculates the exchange rate for the specific currency. 
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class ExchangeRate {
	static double rate = 1.0;
	public static double getRate(String currencyCode) throws Exception{
		
		//reads the url as a json file and finds the conversion rate given the currencyCode.
		try {
			URL url = new URL("https://v6.exchangerate-api.com/v6/8eb50ca9df01f5d3cf70384b/latest/USD");
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			JSONParser jsonParser = new JSONParser();
			JSONObject myObject = (JSONObject)jsonParser.parse(br);
			JSONObject convRate = (JSONObject)myObject.get("conversion_rates");
			NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
			Number number = format.parse(String.valueOf(convRate.get(currencyCode)));
			rate = number.doubleValue();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rate;
	}
}
