package ADT_StackContainer;

public class StackEmptyException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public StackEmptyException(String eccezione) {
		super(eccezione);
	}
}
