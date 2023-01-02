package com.cg.ofda.exception;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public @ResponseBody ErrorInfo LoginException(UserNotFoundException e,HttpServletRequest req) {
	  
		String msg=e.getMessage();
		String uri= req.getRequestURI();
		return new ErrorInfo(msg,uri,LocalDateTime.now());
	}
	@ExceptionHandler(CustomerException.class)
	public @ResponseBody ErrorInfo CustomerException(CustomerException e,HttpServletRequest req) {
	  
		String msg=e.getMessage();
		String uri= req.getRequestURI();
		return new ErrorInfo(msg,uri,LocalDateTime.now());
	}
	@ExceptionHandler(CategoryException.class)
	public @ResponseBody ErrorInfo CategoryException(CategoryException e,HttpServletRequest req) {
	  
		String msg=e.getMessage();
		String uri= req.getRequestURI();
		return new ErrorInfo(msg,uri,LocalDateTime.now());
	}
	 @ExceptionHandler(OrderDetailsException.class)
     public @ResponseBody ErrorInfo OrdertException(OrderDetailsException e,HttpServletRequest req) {

         String msg=e.getMessage();
         String uri= req.getRequestURI();
         return new ErrorInfo(msg,uri,LocalDateTime.now());
	 }
      @ExceptionHandler(RestaurantException.class)
      public @ResponseBody ErrorInfo RestaurantException(RestaurantException e,HttpServletRequest req) {

             String msg=e.getMessage();
             String uri= req.getRequestURI();
             return new ErrorInfo(msg,uri,LocalDateTime.now());
         
      }
      @ExceptionHandler(CartException.class)
      public @ResponseBody ErrorInfo CartException(CartException e,HttpServletRequest req) {

             String msg=e.getMessage();
             String uri= req.getRequestURI();
             return new ErrorInfo(msg,uri,LocalDateTime.now());
      }
      
      @ExceptionHandler(BillException.class)
      public @ResponseBody ErrorInfo BillException(BillException e,HttpServletRequest req) {

             String msg=e.getMessage();
             String uri= req.getRequestURI();
             return new ErrorInfo(msg,uri,LocalDateTime.now());
      }
      
      @ExceptionHandler(ItemException.class)
      public @ResponseBody ErrorInfo ItemException(ItemException e,HttpServletRequest req) {

             String msg=e.getMessage();
             String uri= req.getRequestURI();
             return new ErrorInfo(msg,uri,LocalDateTime.now());
      }
}

