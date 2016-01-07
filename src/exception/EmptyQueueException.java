package exception;

public class EmptyQueueException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyQueueException(String messaggio){
		super(messaggio);
	}
}
