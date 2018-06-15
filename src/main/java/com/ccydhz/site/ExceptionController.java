package com.ccydhz.site;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ccydhz.site.exception.ServiceException;

@ControllerAdvice(basePackages = "com.ccydhz")
public class ExceptionController {


	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ServiceException.class)
	private String handleServiceException(ServiceException e) {
		String message = e.getLocalizedMessage();
		return message;
	}

}
