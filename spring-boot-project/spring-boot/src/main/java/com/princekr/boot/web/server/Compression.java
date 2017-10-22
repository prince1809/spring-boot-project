package com.princekr.boot.web.server;

/**
 * Simple server-independent abstraction for compression configuration.
 */
public class Compression {

    /**
     * If the response compression is enabled.
     */
    private boolean enabled = false;

    /**
     * Comma-separated list of MIME types that should be compressed.
     */
    private String[] mimeTypes = new String[]{"text/html", "text/xml", "text/plain",
            "text/css", "text/javascript", "application/javascript"};

    /**
     * Comma-separated list of user agents for which response should not be compressed.
     */
    private String[] excludeUserAgents = null;

    /**
     * Minimum response size that is required for compression to be performed.
     */
    private int minResponseSize = 2048;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String[] getMimeTypes() {
        return mimeTypes;
    }

    public void setMimeTypes(String[] mimeTypes) {
        this.mimeTypes = mimeTypes;
    }

    public String[] getExcludeUserAgents() {
        return excludeUserAgents;
    }

    public void setExcludeUserAgents(String[] excludeUserAgents) {
        this.excludeUserAgents = excludeUserAgents;
    }

    public int getMinResponseSize() {
        return minResponseSize;
    }

    public void setMinResponseSize(int minResponseSize) {
        this.minResponseSize = minResponseSize;
    }
}
