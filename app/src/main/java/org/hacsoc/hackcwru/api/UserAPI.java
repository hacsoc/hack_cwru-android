package org.hacsoc.hackcwru.api;

import android.content.Context;

import org.hacsoc.hackcwru.gson.GSONFactory;
import org.hacsoc.hackcwru.model.User;
import org.hacsoc.hackcwru.util.JSONUtil;

/**
 * API requests for the User resource.
 *
 * Created by andrew on 6/9/15.
 */
public class UserAPI extends API {
    /**
     * Invoke the create action on the server side by sending a POST request.
     *
     * @param user The user to be created.
     * @param context App context in which the request was made.
     * @param outerHandler Handler to send the created user back to.
     * @return
     */
    public static boolean create(User user,
                                 Context context,
                                 final ResponseHandler<User> outerHandler) {
        ResponseHandler innerHandler = new ResponseHandler<Response>() {
            @Override
            public void responseReceived(Response result) {
                User user = GSONFactory.createCalendarAdapter()
                        .fromJson(result.getContent(), User.class);
                outerHandler.responseReceived(user);
            }
        };

        String userJSON = JSONUtil.serialize(user.toJSONObject(), "user");

        return sendRequest("/users", "POST", userJSON, context, innerHandler);
    }
}
