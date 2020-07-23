package domain;

public class Money {
	private Currency currency;
	private Float amount;
	private static CurrencyProvider currencyProvider;
	
	public Money toCurrency(String code) {
		Float amountInEur = (float)( this.getAmount() / CurrencyProvider.
													getCurrencyProvider().
													getCurrency(this.getCurrency().getCode()).
													getRate() ) ;
		Float newAmount = amountInEur * (float)(CurrencyProvider.
												getCurrencyProvider().
												getCurrency(code).getRate());
		return new Money(code, newAmount);
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = CurrencyProvider.getCurrencyProvider().getCurrency(currency);
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public Money(String currency, Float amount) {
		this.currency = CurrencyProvider.getCurrencyProvider().getCurrency(currency);
		this.amount = amount;
	}
	@Override
	public String toString() {
		return amount + " " + currency;
	}

	
}
