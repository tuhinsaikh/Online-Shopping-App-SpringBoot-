package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exception.ProductNotFoundException;
import com.project.model.Cart;
import com.project.model.Customer;
import com.project.model.Products;
import com.project.repository.AddressDao;
import com.project.repository.CartDao;
import com.project.repository.CustomerDao;
import com.project.repository.ProductsDao;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private ProductsDao pDao;
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private CustomerDao custDao;
	
	@Autowired
	private AddressDao addressDao;

//	@Override
//	public Cart addProductToCart(Cart cart, String name, Integer quantity) {
		// TODO Auto-generated method stub
		
//	List<Product> p1=pDao.findByProductName(name);
	
//	List<Products> prod=cart.getCartItem();
//	for(Products p:prod) {
//		
//		List<Products> pr = pDao.findByProductName(p.getProductName());
////		List<Products> pr1 = pDao.findByProductId(p.getProductId());
//		if(pr.size()<=0 ) {
//			throw new ProductNotFoundException("Product not found");
//		}
//		if(pr1.size()<=0 ) {
//			throw new ProductNotFoundException("Product not found");
//		}
//	}
	
//		pDao.findById(quantity);
//		pDao.findBy
		
//		return null;
//	}
	
	//Method to add the Product and customer in cart

	@Override
	public Cart AddProduct(Cart cart,Integer id,Integer custId) {
		// TODO Auto-generated method stub
		Optional<Products> opt=pDao.findById(id);
		Optional<Customer> customer=custDao.findById(custId);
//		System.out.println(customer.get());
		
		
		if(opt.isPresent()) {
		
			Products prod=opt.get();
			Customer cust=customer.get();
			cart.setCartItem(prod);
			cart.setCustomerlist(cust);
//			for(Customer cust:customer) {				
//				custDao.save(cust);				
//			}	
			return cartDao.save(cart);
		}else {
			throw new ProductNotFoundException("Product not available");
		}
	}
	
	//Method to view the cart

	@Override
	public List<Cart> ViewAllCart() {
		// TODO Auto-generated method stub
		List<Cart> list=cartDao.findAll();
		
		
		return list;
	}

	
//	@Override
//	public Cart addProductToCart(String name, int quantity) {
//		// TODO Auto-generated method stub
//		Cart cart=cartDao.getById(null);
//		
//		List<Product> p1=pDao.findByProductName(name);
//		
//		if(p1.size()!=0) {
//			for(Product product: p1) {
////				cartDao.get;
//			}
//		}
//		
//		return null;
//	}

	

	
	
}
