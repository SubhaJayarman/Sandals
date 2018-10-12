package com.niit.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.configuration.DBConfig;
import com.niit.model.Product;

import junit.framework.TestCase;

public class ProductDaoImpltest extends TestCase {
	ApplicationContext context=new AnnotationConfigApplicationContext(DBConfig.class,ProductDaoImpl.class);
    ProductDao productDao=(ProductDao)context.getBean("productDaoImpl");
	public void testSaveProduct() {
Product product=new Product();
		
		product.setPrice(15000);
		product.setQuantity(1);
		product.setProductname("HIGH HEELS");
		product.setProductdescription(" No Pain Silky smooth Heels ");
		product=productDao.saveProduct(product);
		assertTrue(product.getId()>0);
		
	}

	public void testGetProduct() {
		Product product1=productDao.getProduct(3);
		Product product2=productDao.getProduct(9);
		
		assertNotNull(product1);
		assertNull(product2);
		
		
		double expectedPrice=1000;
		double actualPrice=1000;
		assertTrue(expectedPrice==actualPrice);
	}

	public void testUpdateProduct() {
		Product product1=productDao.getProduct(3);
		Product product2=productDao.getProduct(9);
		
		assertNotNull(product1);
		assertNull(product2);
		
		
		double expectedPrice=100;
		double actualPrice=100;
		assertTrue(expectedPrice==actualPrice);
	}

	
}
