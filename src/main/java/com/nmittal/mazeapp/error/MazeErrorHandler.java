package com.nmittal.mazeapp.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MazeErrorHandler {

	Logger log = LoggerFactory.getLogger(MazeErrorHandler.class);

	@ExceptionHandler(value = { MissingServletRequestParameterException.class, MazeException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ApiError handleInvalidArguments(Exception e) {
		log.error("Invalid Arguments found " + e);
		return new ApiError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
	}

	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ApiError handleException(Exception e) {
		log.error("Unhandled exception occured " + e);
		return new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				String.format("Unhandled exception occurred: %s", e.getMessage()));
	}

}