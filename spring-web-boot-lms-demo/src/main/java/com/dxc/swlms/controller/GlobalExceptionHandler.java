package com.dxc.swlms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.dxc.swlms.exception.LibraryException;

public class GlobalExceptionHandler {

	Logger logger = LoggerFactory.getLogger("ims");

	@ExceptionHandler(LibraryException.class)
	public ModelAndView handleException(LibraryException exp) {
		logger.error(exp.getMessage(), exp);
		return new ModelAndView("errorPage", "exception", exp);
	}

}
