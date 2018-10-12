	package com.niit.dao;

	import java.util.List;

	import org.hibernate.Query;
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	import org.springframework.transaction.annotation.Transactional;
	import com.niit.model.Product;
	@Repository("productDaoImpl")
	@Transactional
	public class ProductDaoImpl implements ProductDao {
		@Autowired
		private SessionFactory sessionFactory;
		
		public ProductDaoImpl()
		{
			System.out.println("productDaoImpl  bean is created");
		}
			public Product saveProduct(Product product){
			Session session=sessionFactory.getCurrentSession();
			System.out.println("id of the product before persisting"+product.getId());
			session.save(product);
			System.out.println("id of the product After persisting"+product.getId());
			return product;
			}
		public Product getProduct(int id) {
			// TODO Auto-generated method stub
			Session session=sessionFactory.getCurrentSession();
			
			Product product=(Product)session.get(Product.class,id);
			return product;
		}
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.update(product);
		
		return product;
	}
	public Product deleteProduct(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
	Product product=(Product)session.get(Product.class,id);
	 if(product!=null)
		session.delete(product);
		return product;
	}
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=(Query) session.createQuery("from Product");
		List<Product> product=query.list();	
		return product;
		
		}
	}
	
