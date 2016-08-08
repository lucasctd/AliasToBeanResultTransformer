package br.com.programmer.exception;

public class ProjectionHelperException extends Exception{

	private static final long serialVersionUID = -5105280210288129112L;
	
	public ProjectionHelperException(String message){
		super(message);
	}
	
	public ProjectionHelperException(Exception e){
		super(e.getMessage());
		super.setStackTrace(e.getStackTrace());
	}

}
