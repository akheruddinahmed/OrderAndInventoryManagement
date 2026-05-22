package inventorymanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import inventorymanagement.entity.Orders;
import inventorymanagement.service.OrderService;
import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/orders")
public class OderController {
	@Autowired
	private OrderService orderService;

	@PostMapping("/place")
	public ResponseEntity<Orders> placeorder(@RequestParam int id,@RequestParam int qty)
	{
	 return   ResponseEntity.ok(orderService.placeorder(id, qty));
	}
}

