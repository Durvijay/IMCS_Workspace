package trng.excptnHndlng.batchprogram;

/**
 * Created by Manohar on 4/22/2017.
 */
public class BatchException extends Exception {

    public BatchException(String msg) {
        super(msg);
    }

    public BatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public BatchException(Throwable cause) {
        super(cause);
    }

    public BatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public BatchException() {
    }
}
