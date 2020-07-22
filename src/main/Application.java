package main;

import java.sql.Date;

import domain.Cart;
import domain.Category;
import domain.Money;
import domain.ProductFactory;

public class Application {

	public static void main(String[] args) {
		
		ProductFactory.getProductFactory().getProduct(
				"Book 1",
				new Money("MDL", 125.25f),
				12,
				Date.valueOf("2020-07-22"),
				"Republic of Moldova",
				new Category("Books")
				);
		ProductFactory.getProductFactory().getFakeProduct();
		ProductFactory.getProductFactory().getManyFakeProducts(10);
		
		ProductFactory.getProductFactory().printAllProducts();
		
		Cart cart = new Cart();
		
		ProductFactory.getProductFactory().getAllProducts().forEach(p->{
			if(p.getId()%2 == 1) {
				cart.add(ProductFactory.getProductFactory().castProduct(p));
			}
		});
		
		cart.add(cart.findById(1));
		
		cart.printAll();
		
		System.out.println(cart.findByManufacturer("Republic of Moldova"));
		
		System.out.println(cart.findByCategory(new Category("Books")));
		
		cart.calculateTotal();
		System.out.println(cart.getTotal());
	}

	
}
