package trng.excptnHndlng;

import java.io.PrintStream;

class SSNValidException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7969025719728519852L;

	public SSNValidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public SSNValidException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public SSNValidException(String message) {
		super(message);
	}

	public SSNValidException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SSNValidException(String message, Throwable arg1) {
		super(message, arg1);
		// TODO Auto-generated constructor stub
	}	
}