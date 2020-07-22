package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.github.javafaker.Faker;

public class ProductFactory {
	
	private static final ProductFactory INSTANCE = new ProductFactory(new ArrayList<>(), 1);
	private List<AbstractProduct> products;
	private Integer id;
	
	private ProductFactory(List<AbstractProduct> products, Integer id) {
		this.products = products;
		this.id = id;
	}
	
	
	public AbstractProduct getProduct(String name, Money price, Integer quantity, Date expiration, String manufactured, Category category) {
		AbstractProduct p = new Product(getId(), name, price, quantity, expiration, manufactured, category);
		INSTANCE.products.add(p);
		return p;
	}
	
	public AbstractProduct getFakeProduct() {
		Faker faker = new Faker();
		AbstractProduct p = new Product(
								getId(),
								faker.commerce().productName(),
								new Money(faker.currency().name(), (float)faker.number().randomDouble(2, 0, 1000)),
								Integer.valueOf(faker.number().numberBetween(0, 1000)),
								faker.date().birthday(),
								faker.country().name(),
								new Category(faker.commerce().department())
								);
		INSTANCE.products.add(p);
		return p;
	}
	
	public List<AbstractProduct> getManyFakeProducts(int quantity) {
		Faker faker = new Faker();
		int counter = 0;
		while( counter < quantity) {
			INSTANCE.products.add(new Product(
					getId(),
					faker.commerce().productName(),
					new Money(faker.currency().name(), (float)faker.number().randomDouble(2, 0, 1000)),
					Integer.valueOf(faker.number().numberBetween(0, 1000)),
					faker.date().birthday(),
					faker.country().name(),
					new Category(faker.commerce().department())
					) );
			counter++;
		}
		
		return INSTANCE.products;
	}
	
	public void printAllProducts() {
		INSTANCE.products.forEach(System.out::println);
	}
	
	public Integer getId() {
		return INSTANCE.id++;
	}
	
	public static ProductFactory getProductFactory() {
		return INSTANCE;
	}
	
	public List<AbstractProduct> getAllProducts() {
		return INSTANCE.products;
		}
	
	public Product castProduct(AbstractProduct abstractProduct) {
		return (Product)abstractProduct;
	}
	
}
