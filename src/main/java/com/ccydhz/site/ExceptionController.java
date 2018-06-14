package com.ccydhz.site;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ccydhz.site.exception.ServiceException;

@ControllerAdvice(basePackages = "com.ccydhz")
public class ExceptionController {

	private static final Logger SERVICE_LOGGER = LoggerFactory.getLogger(ServiceException.class);

	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ServiceException.class)
	private String handleServiceException(ServiceException exception) {
		String message = exception.getLocalizedMessage();
		SERVICE_LOGGER.info(message);
		return message;
	}

}
