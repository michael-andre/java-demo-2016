package fr.ecp.sio.demo;

/**
 * Created by Michaël on 20/10/2016.
 */
public class InvalidGeometryException extends Exception {

    public InvalidGeometryException() {
    }

    public InvalidGeometryException(String message) {
        super(message);
    }

    public InvalidGeometryException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidGeometryException(Throwable cause) {
        super(cause);
    }

    public InvalidGeometryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
