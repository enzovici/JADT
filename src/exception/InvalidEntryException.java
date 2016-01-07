package exception;

@SuppressWarnings("serial")
public class InvalidEntryException extends RuntimeException {

	public InvalidEntryException(){
		super();
	}
	
	public InvalidEntryException(String x){
		super(x);
	}
	
}
