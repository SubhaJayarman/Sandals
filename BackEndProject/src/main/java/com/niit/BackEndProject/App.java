package com.niit.BackEndProject;





import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.configuration.DBConfiguration;
import com.niit.dao.*;
import com.niit.daoimpl.*;
import com.niit.model.*;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		// TESTING DAO LAYER

        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DBConfiguration.class,ProductDaoImpl.class);
        context.scan("com.niit");
        //context.refresh();
		ProductDao productDao = (ProductDao) context.getBean("ProductDaoImpl");
		
		Product prodc=new Product();
		
		 prodc.setProductname("Mule");
		  prodc.setDescription("purple");
		  prodc.setPrice(2000); 
		  prodc.setQuantity(25);
			productDao.saveProduct(prodc);
		/*UserProcess up = new UserProcess();
		up.setId(5);
		up.setName("rathish");
		up.setNumber("1234567890");
		up.setPassword("rathish@niit");
		up.setUsername("rathis@abc");
		up.setEmailid("rathish@gmail.com");
		productDao.saveUserProcess(up);*/
		/*List<UserProcess> lifofuser = productDao.getId(6);
		for (UserProcess upp : lifofuser) {
			System.out.println(upp.getName() + "   " + upp.getEmailid());
		}*/ 
		/*System.out.println(userProcess.getId());

		  prodc.setProductname("Refrijerator");
		  prodc.setDescription("Orange color machine"); prodc.setQuantity(25);
		  prodc.setPrice(20000); productDao.saveProduct(prodc);
		/*SupplierDao productDao=(SupplierDao) context.getBean("supplierDAO");
		Supplier produ=new Supplier();*/
		/*produ.setId(5);
		produ.setDescription("yellow color");
		produ.setProductname("Tele Vision");
		produ.setPrice(35000);
		produ.setQuantity(25);
		productDao.saveProduct(produ);*/
		/*List<Product> lpfol=productDao.getId(3);
		for(Product p1:lpfol)
			System.out.println(p1.getId()+" "+p1.getProductname()+" "+p1.getDescription()+" "+p1.getQuantity()+" "+p1.getPrice());*/
		/*List<Product> lpfol=productDao.getAllProduct();
		for(Product p1:lpfol)
			System.out.println(p1.getId()+" "+p1.getProductname()+" "+p1.getDescription()+" "+p1.getQuantity()+" "+p1.getPrice());*/
		 /*produ.setSupplierAddr("Dubai");
		 produ.setSupplierName("Shake");
		 System.out.println(productDao.addSupplier(produ));*/
		/*System.out.println(productDao.deleteSupplier(10));*/
		/*produ.setSupplierId(6);
		produ.setSupplierName("Paul");
		produ.setSupplierAddr("Chicago");
		System.out.println(productDao.updateSupplier(produ));*/
		/*for(Supplier s:productDao.listSupplier())
			System.out.println(s.getSupplierId()+" "+s.getSupplierName()+" "+s.getSupplierAddr());*/
		/*for(Supplier s:productDao.getSupplier(3))
			System.out.println(s.getSupplierId()+" "+s.getSupplierName()+" "+s.getSupplierAddr());*/
	}
}
