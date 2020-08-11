package main;

import java.sql.Date;

import domain.Cart;
import domain.Category;
import domain.Money;
import domain.Product;
import domain.ProductFactory;
import domain.DataRepository;

public class Application {

	public static void main(String[] args) {
		
		Product p1 = (Product) DataRepository.load(Product.class);
		
		Cart cart = new Cart();
		
		cart.add(p1);
		
		cart.printAll();
		
		/* Product p1 = (Product) ProductFactory.getProductFactory().getProduct(
				"Book 1",
				new Money("MDL", 125.25f),
				12,
				Date.valueOf("2020-07-22"),
				"Republic of Moldova",
				new Category("Books")
				);
		
		ProductFactory.getProductFactory().printAllProducts();
		
		DataRepository.save(p1);
		
		Cart cart = new Cart();
		
		ProductFactory.getProductFactory().getAllProducts().forEach(p->
				cart.add(ProductFactory.getProductFactory().castProduct(p)));
		
		cart.printAll();
		
		System.out.println(cart.findByManufacturer("Republic of Moldova"));
		
		System.out.println(cart.findByCategory(new Category("Books")));
		
		cart.calculateTotal();
		System.out.println(cart.getTotal());
		
		Money priceInEur = new Money("RUB", 1000.0f);
		Money samePriceInLei = priceInEur.toCurrency("MDL");
		
		System.out.println(samePriceInLei); */
	}
}
