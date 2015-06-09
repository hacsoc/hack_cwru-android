package org.hacsoc.hackcwru.api;

import android.content.Context;

import org.hacsoc.hackcwru.gson.GSONFactory;
import org.hacsoc.hackcwru.model.User;

/**
 * API requests for the User resource.
 *
 * Created by andrew on 6/9/15.
 */
public class UserAPI extends API {
    /**
     * Invoke the create action on the server side by sending a POST request.
     *
     * @param body The data representing the user to be created.
     * @param context App context in which the request was made.
     * @param outerHandler Handler to send the created user back to.
     * @return
     */
    public static boolean create(String body,
                                 Context context,
                                 final ResponseHandler<User> outerHandler) {
        ResponseHandler innerHandler = new ResponseHandler<String>() {
            @Override
            public void responseReceived(String result) {
                User user = GSONFactory.createCalendarAdapter().fromJson(result, User.class);
                outerHandler.responseReceived(user);
            }
        };
        return sendRequest("/users", "POST", body, context, innerHandler);
    }
}
