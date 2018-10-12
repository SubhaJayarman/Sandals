package com.niit.sandalsb;


import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.configuration.DBConfig;
import com.niit.dao.ProductDao;
import com.niit.dao.ProductDaoImpl;
import com.niit.model.Product;


/**
 * SHAZIA
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "SHAZIA" );
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DBConfig.class,ProductDaoImpl.class);   
        context.scan("com.niit");
        ProductDao productDao=(ProductDao)context.getBean("productDaoImpl");

/*Product product=new Product();
		
	

		product.setQuantity(3);
		product.setProductname("Mule");
		product.setPrice(1500);
		product.setProductdescription("Pencil heels");
		product=productDao.saveProduct(product);*/
        
        
/*
    	Product product=productDao.getProduct(2);
    	product.setPrice(20000);
    	product.setQuantity(20);
    	
    	productDao.updateProduct(product);*/
        
     /*   productDao.deleteProduct(2);*/
        
        List<Product>products=productDao.getAllProducts();
        
        for(Product p:products)
        {
        	
        	System.out.println(p.getId()+"   "+p.getPrice()+"   "+p.getProductdescription()+"   "+p.getQuantity());
        }
        
        
        
        
    }
}
