package inventorymanagement.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import inventorymanagement.entity.OrderItem;
import inventorymanagement.entity.Orders;
import inventorymanagement.entity.Product;
import inventorymanagement.exceptionn.InsuffcientStockException;
import inventorymanagement.repository.OrdersReposiotroy;
import inventorymanagement.repository.ProductRepository;

@Service
public class OrderService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrdersReposiotroy ordersReposiotroy;
	
	@Transactional
	public Orders placeorder(int id,int qty)
	{
		Product product=productRepository.findById(id).orElseThrow(
				()-> new RuntimeException("Product Unavilable"));
		if (product.getStock()<qty) {
			throw new InsuffcientStockException("insuffient stock");
		}
		product.setStock(product.getStock()-qty);
		
		Orders orders=new Orders();
		orders.setDateTime(LocalDateTime.now());
		
		OrderItem item = new OrderItem();
		item.setProduct(product);
		item.setQty(qty);
		item.setOrder(orders);
		
		orders.setItems(List.of(item));
		
		return ordersReposiotroy.save(orders);
				
		
	}
	
}
