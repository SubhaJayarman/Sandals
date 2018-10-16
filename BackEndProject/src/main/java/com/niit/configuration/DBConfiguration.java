package com.niit.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.CartItemDao;
import com.niit.dao.CategoryDao;
import com.niit.dao.CustomerDao;
import com.niit.dao.PaymentModeDao;
import com.niit.dao.PlaceOrderHistoryDao;
import com.niit.dao.ProductDao;
import com.niit.dao.SupplierDao;
import com.niit.dao.UserProcessDao;
import com.niit.daoimpl.CartItemDaoImpl;
import com.niit.daoimpl.CategoryDaoImpl;
import com.niit.daoimpl.CustomerDaoImpl;
import com.niit.daoimpl.PaymentModeDaoImpl;
import com.niit.daoimpl.PlaceOrderHistoryDaoImpl;
import com.niit.daoimpl.ProductDaoImpl;
import com.niit.daoimpl.SupplierDaoImpl;
import com.niit.daoimpl.UserProcessDaoImpl;
import com.niit.model.Authorities;
import com.niit.model.BillingAddress;
import com.niit.model.CartItem;
import com.niit.model.Category;
import com.niit.model.Customer;
import com.niit.model.PaymentMode;
import com.niit.model.PlaceOrderHistory;
import com.niit.model.Product;
import com.niit.model.ShippingAddress;
import com.niit.model.Supplier;
import com.niit.model.User;

@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement   //commit / rollback
public class DBConfiguration {
//to create beans
	
	@Bean(name="dataSource")
	public DataSource getDataSource() {
		System.out.println("Entering DataSource Bean creation method ");
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("org.h2.Driver");
	    dataSource.setUrl("jdbc:h2:tcp://localhost/~/Sandals");
	
	    dataSource.setUsername("subha");
	    dataSource.setPassword("subha");
	    System.out.println("DataSource bean " +dataSource);
	    return dataSource;
	}
	/*
	 * <bean id="sessionFactory" class="org.springframework.orm.hibernate4.LocalSessionFactoryBuilder">
	 * <property name="dataSource" ref="dataSource">
	 */
	@Bean(name="sessionFactory") //SessionFactory - factory of session objects
	public SessionFactory sessionFactory() {
		System.out.println("Entering sessionFactory creation method");
		LocalSessionFactoryBuilder lsf=
				new LocalSessionFactoryBuilder(getDataSource());
		Properties hibernateProperties=new Properties();
		hibernateProperties.setProperty(
				"hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		lsf.addProperties(hibernateProperties);
		//An array of Class objects of all the entities
		//Map all entities to relational table
		Class classes[]=new Class[]{Product.class,Supplier.class,Category.class,Customer.class,User.class,Authorities.class,BillingAddress.class,ShippingAddress.class,CartItem.class,PlaceOrderHistory.class,PaymentMode.class};
		//localsesionfactorybuilder -> sessionfactory -> map all entities with relation table
		System.out.println("SessionFactory bean " + lsf);
	    return lsf.addAnnotatedClasses(classes).buildSessionFactory();
	}
	
	@Bean(name="userProcessDaoImpl")
	public UserProcessDao getUserProcess() {
		System.out.println("User Process Dao Created");
		return new UserProcessDaoImpl();
	}
	
	@Bean(name="productDaoImpl")
	public ProductDao getProduct() {
		System.out.println("Product Dao Created");
		return new ProductDaoImpl();
	}
	
	@Bean(name="supplierDaoImpl")
	public SupplierDao getSupplier() {
		System.out.println("Supplier Dao Created");
		return new SupplierDaoImpl();
	}
	
	@Bean(name="categoryDaoImpl")
	public CategoryDao getCategroy() {
		System.out.println("Category Dao Created");
		return new CategoryDaoImpl();
	}
	
	@Bean(name="customerDaoImpl")
	public CustomerDao getCustomer() {
		System.out.println("Customer Dao Created");
		return new CustomerDaoImpl();
	}
	
	@Bean(name="cartItemDaoImpl")
	public CartItemDao getCartItem() {
		System.out.println("Cart Item Dao Created");
		return new CartItemDaoImpl();
	}
	
	@Bean(name="placeOrderHistoryDaoImpl")
	public PlaceOrderHistoryDao getPlaceOrderHistory() {
		System.out.println("Place Order History Dao Created");
		return new PlaceOrderHistoryDaoImpl();
	}
	
	@Bean(name="paymentModeDaoImpl")
	public PaymentModeDao getPaymentMode() {
		System.out.println("Place Order History Dao Created");
		return new PaymentModeDaoImpl();
	}
	
	@Bean
	public HibernateTransactionManager hibTransManagement(){
		return new HibernateTransactionManager(sessionFactory());
	}
}
