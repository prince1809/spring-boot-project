package com.princekr.boot.web.server;


import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;

/**
 * Simple server-independent abstraction for error pages. Roughly equivalent to the
 * {@literal &lt;error-page&gt;} element traditionally found in web.xml.
 */
public class ErrorPage {

    private final HttpStatus status;

    private final Class<? extends Throwable> exception;

    private final String path;

    public ErrorPage(String path) {
        this.status = null;
        this.exception = null;
        this.path = path;
    }

    public ErrorPage(HttpStatus status, String path) {
        this.status = status;
        this.exception = null;
        this.path = path;
    }

    public ErrorPage(Class<? extends Throwable> exception, String path) {
        this.status = null;
        this.exception = exception;
        this.path = path;
    }

    /**
     * The path to render (usually implemented  as a forward), staring with "/". A custom
     * controller or servlet path can be used, or if the server supports it, a template
     * path (e.g. "/error.jsp").
     *
     * @return the path that will be rendered for this error
     */
    public String getPath() {
        return this.path;
    }

    /**
     * Returns the exception type (or {@code null} for a page that matches by status).
     *
     * @return the exception type or {@code null}
     */
    public Class<? extends Throwable> getException() {
        return this.exception;
    }

    /**
     * The http status value that this error page matches (or {@code null} for a page that
     * matches by exception).
     *
     * @return the status or {@code null}
     */
    public HttpStatus getStatus() {
        return this.status;
    }

    /**
     * The http status value that this error page matches.
     *
     * @return the status value (or 0 for a page that matches any status)
     */
    public int getStatusCode() {
        return (this.status == null ? 0 : this.status.value());
    }

    /**
     * The exception type name
     *
     * @return the exception type name {or {@code null} if there is none}
     */
    public String getExceptionName() {
        return (this.exception == null ? null : this.exception.getName());
    }

    /**
     * Return if this error page is global one (matches all unmatched status and
     * exception types).
     *
     * @return if this is a global error page
     */
    public boolean isGlobal() {
        return (this.status == null && this.exception == null);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ObjectUtils.nullSafeHashCode(getExceptionName());
        result = prime * result + ObjectUtils.nullSafeHashCode(this.path);
        result = prime * result + this.getStatusCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof ErrorPage) {
            ErrorPage other = (ErrorPage) obj;
            boolean rtn = true;
            rtn = rtn && ObjectUtils.nullSafeEquals(getExceptionName(), other.getExceptionName());
            rtn = rtn && ObjectUtils.nullSafeEquals(this.path, other.path);
            rtn = rtn && this.status == other.status;
            return rtn;
        }
        return false;
    }
}
