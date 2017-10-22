package com.princekr.boot.web.server;

/**
 * Exception thrown by an web server.
 * <p>
 * Created by prince on 2017/10/22.
 */

@SuppressWarnings("serial")
public class WebServerException extends RuntimeException {

    public WebServerException(String message, Throwable cause) {
        super(message, cause);
    }
}
