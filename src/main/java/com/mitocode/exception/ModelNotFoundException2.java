package com.mitocode.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ModelNotFoundException2 extends RuntimeException{
	
	public ModelNotFoundException2(String mensaje) {
		super(mensaje);
	}

}
