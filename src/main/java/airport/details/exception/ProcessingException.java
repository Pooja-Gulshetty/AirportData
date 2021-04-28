package airport.details.exception;

public class ProcessingException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6808009193513076630L;

	private String message;

	private Throwable error;

	public ProcessingException(String message, Throwable error) {
		this.message = message;
		this.error = error;
	}

	public ProcessingException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Throwable getError() {
		return error;
	}

	public void setError(Throwable error) {
		this.error = error;
	}

}
