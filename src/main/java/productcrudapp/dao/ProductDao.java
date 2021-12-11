package productcrudapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import productcrudapp.model.Product;

@Component
public class ProductDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//create product
	@Transactional
	public void createProduct(Product product) {
		this.hibernateTemplate.saveOrUpdate(product);
	}
	
	//get all Products
	public List<Product> getProducts(){
		List<Product> products = this.hibernateTemplate.loadAll(Product.class);
		return products;
	}
	
	//delete product
	@Transactional
	public void deleteProduct(int productId) {
		Product product = this.hibernateTemplate.load(Product.class, productId);
		this.hibernateTemplate.delete(product);
	}
	
	//get product
	public Product getProduct(int productId) {
		return this.hibernateTemplate.get(Product.class, productId);
	}
	
}
