package br.com.avaliacao.helper;

import java.util.ArrayList;
import java.util.List;

public class ObjectResponse {

	private Object object;
	private String message;
	private List<String> errors = new ArrayList<String>();
	
	public void setError(String error){
		this.getErrors().add(error);
	}
	
	public boolean hasError(){
		return this.errors.size()>0;
	}
	
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getErrors() {
		return errors;
	}
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	
	
	
}
