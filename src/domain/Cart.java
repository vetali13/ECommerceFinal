package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cart implements ProductRepository{
	
	private List<Product> products = new ArrayList<>();
	
	private Float total;

	public void add(Product product) {
		products.add(product);
	}

	public void delete(Integer productId) {
		products.remove(findById(productId));
	}

	public void updateQuantity(Integer productId, Integer newQuantity) {
		findById(productId).setQuantity(newQuantity);
		
	}

	public Product findById(Integer productId) {
		for (Product p : products) {
			if (p.getId().equals(productId)) {
				return p;
			}
		}
		return null;
	}

	public List<Product> findAll() {
		return products;
	}

	public List<Product> findByName(String productName) {
		List<Product> productListByName = new ArrayList<>();
		for (Product p : products) {
			if (p.getName().equals(productName)) {
				productListByName.add(p);
			}
		}
		return productListByName;
	}

	public List<Product> findByManufacturer(String productManufactured) {
		List<Product> productListByManufactured = new ArrayList<>();
		for (Product p : products) {
			if (p.getManufactured().equals(productManufactured)) {
				productListByManufactured.add(p);
			}
		}
		return productListByManufactured;
	}

	public List<Product> findByCategory(Category category) {
		List<Product> productListByCategory = new ArrayList<>();
		for (Product p : products) {
			if (p.getCategory().getName().equals(category.getName())) {
				productListByCategory.add(p);
			}
		}
		return productListByCategory;
	}

	public List<Product> findByExpirationDate(Date fromDate, String from) {
		List<Product> productListByExpiration = new ArrayList<>();
		for (Product p : products) {
			if (p.getExpiration().after(fromDate)) {
				productListByExpiration.add(p);
			}
		}
		return productListByExpiration;
	}

	public List<Product> findByExpirationDate(String to, Date toDate) {
		List<Product> productListByExpiration = new ArrayList<>();
		for (Product p : products) {
			if (p.getExpiration().before(toDate)) {
				productListByExpiration.add(p);
			}
		}
		return productListByExpiration;
	}

	public List<Product> findByExpirationDate(Date fromDate, Date toDate) {
		List<Product> productListByExpiration = new ArrayList<>();
		for (Product p : products) {
			if ( (p.getExpiration().after(fromDate)) && (p.getExpiration().before(toDate)) ) {
				productListByExpiration.add(p);
			}
		}
		return productListByExpiration;
	}
	
	public void printAll() {
		products.forEach(System.out::println);
	}

	/////////BUSINESS LOGIC
	
	public void calculateTotal() {
		total = 0.0f;
		products.forEach(p->{
			total += p.getPrice().getAmount() * p.getQuantity();
		});
	}
	
	public Float getTotal() {
		
		return total;
	}
	
	
}
