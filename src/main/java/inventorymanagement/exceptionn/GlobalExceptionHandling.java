package inventorymanagement.exceptionn;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {

	
	@ExceptionHandler(value = InsuffcientStockException.class)
	public ResponseEntity<String> handlestock(InsuffcientStockException exception)
	{
		return ResponseEntity.badRequest().body(exception.getMessage());
	}
	

	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<String> handlestock(RuntimeException exception)
	{
		return ResponseEntity.badRequest().body(exception.getMessage());
	}
}
