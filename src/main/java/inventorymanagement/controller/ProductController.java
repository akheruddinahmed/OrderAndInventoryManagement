package inventorymanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import inventorymanagement.entity.Product;
import inventorymanagement.repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@PostMapping("/save")
	public Product saveproduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
}
