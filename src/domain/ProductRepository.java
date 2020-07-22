package domain;

import java.util.Date;
import java.util.List;

public interface ProductRepository {
	public void add(Product product);
	public void delete(Integer productId);
	public void updateQuantity(Integer productId, Integer newQuantity);
	public Product findById(Integer productId);
	public List<Product> findAll();
	public List<Product> findByName(String productName);
	public List<Product> findByManufacturer(String productManufactured);
	public List<Product> findByCategory(Category category);
	
	public List<Product> findByExpirationDate(Date fromDate, String from);
	public List<Product> findByExpirationDate(String to, Date toDate);
	public List<Product> findByExpirationDate(Date fromDate, Date toDate);

}
