package com.mitocode.exception;

import java.util.Date;

public class ExceptionResponse {
	
	private Date timeStamp;
	private String mensaje, detalles;
	
	public ExceptionResponse(Date timeStamp, String mensaje, String detalles) {
		super();
		this.timeStamp = timeStamp;
		this.mensaje = mensaje;
		this.detalles = detalles;
	}
	
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getDetalles() {
		return detalles;
	}
	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

}
