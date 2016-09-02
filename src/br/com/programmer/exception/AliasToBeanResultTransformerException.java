package br.com.programmer.exception;

public class AliasToBeanResultTransformerException extends Exception{

	private static final long serialVersionUID = -5105280210288129112L;
	
	public AliasToBeanResultTransformerException(String message){
		super(message);
	}
	
	public AliasToBeanResultTransformerException(Exception e){
		super(e.getMessage());
		super.setStackTrace(e.getStackTrace());
	}

}
