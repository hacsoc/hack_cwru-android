package org.hacsoc.hackcwru.api;

/**
 * Abstraction of HTTP Responses.
 *
 * Created by andrew on 6/10/15.
 */
public class Response {
    private int responseCode;
    private String content;

    /**
     * Create an Response object with the given response code and content.
     *
     * @param responseCode
     * @param content
     */
    public Response(int responseCode, String content) {
        this.responseCode = responseCode;
        this.content = content;
    }

    /**
     * Get the response code of this response.
     *
     * @return
     */
    public int getResponseCode() {
        return responseCode;
    }

    /**
     * Get the data contained in this response.
     * 
     * @return
     */
    public String getContent() {
        return content;
    }
}
