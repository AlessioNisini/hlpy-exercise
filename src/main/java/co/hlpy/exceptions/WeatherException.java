package co.hlpy.exceptions;

import java.io.Serializable;

public class WeatherException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    public WeatherException() {
    }

    public WeatherException(String message) {
        super(message);
    }

    public WeatherException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeatherException(Throwable cause) {
        super(cause);
    }

    public WeatherException(String message, Throwable cause,
                            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}