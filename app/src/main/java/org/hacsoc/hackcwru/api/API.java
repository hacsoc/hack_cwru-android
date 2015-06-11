package org.hacsoc.hackcwru.api;

import android.content.Context;

import org.hacsoc.hackcwru.BuildConfig;

/**
 * Util-like object for making requests to the backend API. Sub-class this per
 * model scope (i.e. UserAPI, AnnouncementAPI, etc).
 *
 * Created by andrew on 6/8/15.
 */
public class API {
    /**
     * Return the base URL for making requests. Attempts to go to a local
     * backend if the app is running in debug. Goes to the real URL otherwise.
     *
     * @return
     */
    public static final String getBaseURL() {
        String protocol = "http://";
        String host;
        if (BuildConfig.DEBUG) {
            /*
             * This is what the android emulator sees as "localhost". If you
             * are developing on a real phone, change this IP (and port) to
             * the IP of the machine running the Rails server.
             */
            host = "10.0.2.2:3000";
        } else {
            host = ""; // TODO: deploy the backend somewhere.
        }
        return protocol + host;
    }

    /**
     * Abstract all the nastiness of sending asynchronous requests. All requests
     * should be sent through here.
     *
     * @param path The path. <em>NOT</em> the URL. JSON path ending is taken care of for you.
     * @param method The HTTP method to use.
     * @param body The request body. Null if no data needs to be sent.
     * @param context The context of the request.
     * @param responseHandler The handler to call back to. In your method that calls this method,
     *                        you should pass in a new response handler, which does the following:
     *                          1) Receives the response as a String.
     *                          2) Converts the String using Gson to the appropriate type for your
     *                             endpoint.
     *                          3) Returns the converted object to the original handler.
     *                        @see "The post request in the UserAPI."
     * @return True if the request succeeded.
     */
    public static final boolean sendRequest(String path,
                                            String method,
                                            String body,
                                            Context context,
                                            ResponseHandler responseHandler) {
        Request request = new Request(context, responseHandler);
        if (!request.hasNetworkConnection()) {
            return false;
        }

        request.execute(fullJSONURl(path), method, body);
        return true;
    }

    /**
     * Convert a path to a full JSON URL, based on baseURL. Appends the .json to the URL.
     *
     * @param path The path to convert.
     * @return
     */
    private static final String fullJSONURl(String path) {
        return getBaseURL() + path + ".json";
    }
}
