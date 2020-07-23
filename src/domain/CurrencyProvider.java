package domain;

import java.util.HashMap;
import java.util.Map;

public class CurrencyProvider {
	
	private static final CurrencyProvider INSTANCE = new CurrencyProvider(new HashMap<String, Currency>(){{
	       put("EUR",new Currency("EUR", 1.00));
	       put("USD",new Currency("USD", 1.11));
	       put("MDL",new Currency("MDL", 19.25));
	       put("RUB",new Currency("RUB", 80.00));
	       put("RON",new Currency("RON", 4.5));
	       }});
	
	private Map<String,Currency> currencies;
	
	private CurrencyProvider(HashMap<String, Currency> currencies) {
		this.currencies = currencies;
	}

	public Currency getCurrency(String code) {
		return INSTANCE.currencies.get(code);
	}
	
	public static CurrencyProvider getCurrencyProvider() {
		return INSTANCE;
	}
}
