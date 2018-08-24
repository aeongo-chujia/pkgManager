package com.aeongo.packagemanagementsystem.exception;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.aeongo.packagemanagementsystem.response.GeneralResponse;
import com.aeongo.packagemanagementsystem.response.PackageResponse;

@RestControllerAdvice
public class RestExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);
	
	
    /**
     * @title Json Format Handler
     * @param Exception ex
     * @author Sun
     */
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(ValidationFailedException.class)
    public GeneralResponse validationFailedHandler(ValidationFailedException ex) {
		String msg = ex.getMessage();
		logger.error(msg);
		String returnMsg = "Json format error";
		GeneralResponse response = new GeneralResponse();
		response.setMsg(msg);
		response.setStatus(1);
		return response;
    }
	
	
	
    /**
     * @title Json Format Handler
     * @param Exception ex
     * @author Sun
     */
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(HttpMessageNotReadableException.class)
    public String jsonFormatHandler(HttpMessageNotReadableException ex) {
		String msg = ex.getMessage();
		logger.error(msg);
		String returnMsg = "Json format error";
		return returnMsg;
    }
	
	
    /**
     * @title Argument Handler
     * @param Exception ex
     * @author Sun
     */
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public String argumentHandler(MethodArgumentNotValidException ex) {
		String msg = ex.getMessage();
		logger.error(msg);
		return "Input argument error: " + msg;
    }
	
	
	
    /**
     * @title General Handler
     * @param Exception ex
     * @author Sun
     */
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(Exception.class)
    public String generalHandler(Exception ex) {
		String msg = ex.getMessage();
		logger.error(msg);
		ex.printStackTrace();
		return "Error occurs: " + msg;
    }
}
