package org.hacsoc.hackcwru.api;

/**
 * Handler for asynchronous requests.
 *
 * Created by andrew on 6/8/15.
 */
public interface ResponseHandler<T> {
    /**
     * Called when an asynchronous task completes.
     * @param result The HTTP response.
     */
    public void responseReceived(T result);
}
