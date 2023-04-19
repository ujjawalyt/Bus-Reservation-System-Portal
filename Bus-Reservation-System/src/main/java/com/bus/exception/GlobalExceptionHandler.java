package com.bus.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {


	@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<MyErrorDetails> myMANVEHandler(MethodArgumentNotValidException me){
		
		MyErrorDetails error = new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage("Validation Error.!");
		error.setDescription(me.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}
	
	

	@ExceptionHandler(CustomerNotFoundException.class)
public ResponseEntity<MyErrorDetails> myCNFEHandler(CustomerNotFoundException cn, WebRequest wr){
		
		MyErrorDetails error = new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(cn.getMessage());
		error.setDescription(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(BusNotFoundException.class)
	public ResponseEntity<MyErrorDetails> myBNFEHandler(BusNotFoundException bn, WebRequest wr){
			
			MyErrorDetails error = new MyErrorDetails();
			error.setTimestamp(LocalDateTime.now());
			error.setMessage(bn.getMessage());
			error.setDescription(wr.getDescription(false));
			
			return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
		
	
}
	
	
	@ExceptionHandler(RouteNotFoundException.class)
	public ResponseEntity<MyErrorDetails> myRNFEHandler(RouteNotFoundException rn, WebRequest wr){
			
			MyErrorDetails error = new MyErrorDetails();
			error.setTimestamp(LocalDateTime.now());
			error.setMessage(rn.getMessage());
			error.setDescription(wr.getDescription(false));
			
			return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
		
	
}
	
	@ExceptionHandler(AdminNotFoundException.class)
	public ResponseEntity<MyErrorDetails> myANFEHandler(AdminNotFoundException adn, WebRequest wr){
			
			MyErrorDetails error = new MyErrorDetails();
			error.setTimestamp(LocalDateTime.now());
			error.setMessage(adn.getMessage());
			error.setDescription(wr.getDescription(false));
			
			return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
		
	
}
	@ExceptionHandler(FeedbackNotFoundException.class)
	public ResponseEntity<MyErrorDetails> myFNFEHandler(FeedbackNotFoundException fBFe, WebRequest wr){
			
			MyErrorDetails error = new MyErrorDetails();
			error.setTimestamp(LocalDateTime.now());
			error.setMessage(fBFe.getMessage());
			error.setDescription(wr.getDescription(false));
			
			return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
		
	
}
	
}



