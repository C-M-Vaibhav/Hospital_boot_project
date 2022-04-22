package com.ty.hospital.hospitalappboot.Exception;

public class NoFoundByIdException extends RuntimeException{
	
private String message = "Given Id Is Not Exist";
	
	public NoFoundByIdException() {}
	
	public NoFoundByIdException(String message) {
		this.message= message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}

}
