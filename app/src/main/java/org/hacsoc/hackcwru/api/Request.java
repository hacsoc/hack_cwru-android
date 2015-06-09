package org.hacsoc.hackcwru.api;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;

import org.hacsoc.hackcwru.util.StreamUtil;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Class to make HTTP requests asynchronously.
 *
 * Created by andrew on 6/8/15.
 */
public class Request extends AsyncTask<String, Void, String> {
    private Context context;
    private ResponseHandler responseHandler;

    /**
     * Create a request object.
     *
     * @param context Context of the request. Used to get system services to check connectivity status.
     * @param responseHandler Handler for the response.
     */
    public Request(Context context, ResponseHandler responseHandler) {
        this.context = context;
        this.responseHandler = responseHandler;
    }

    /**
     * Returns true if the request was able to establish a network connection.
     *
     * @return
     */
    public boolean hasNetworkConnection() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    /**
     * Function to make the request. Run in the background by the AsyncTask.
     *
     * @param params Parameters for the request. Must contain exactly three elements:
     *               1) The URL to which to send the request.
     *               2) The HTTP method to use.
     *               3) The request body. Set to null if no data needs to be sent.
     * @return String containing the response data.
     */
    @Override
    protected String doInBackground(String... params) {
        try {
            return makeRequest(params[0], params[1], params[2]);
        } catch (IOException e) {
            Log.e("Request", "IOException when making request", e);
        }
        return null;
    }

    /**
     * Make an HTTP request and return the response.
     *
     * @param urlString URL to which to send the request.
     * @param method HTTP method to use.
     * @param body Request body. Set to null if no data needs to be sent.
     * @return String containing the response data.
     * @throws IOException For malformed requests, as well as any errors trying to read from or
     *                     write to the connection's input/output streams.
     */
    private String makeRequest(String urlString, String method, String body) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        // Set parameters (timeouts and HTTP method) on the connection
        connection.setConnectTimeout(200);
        connection.setReadTimeout(200);
        connection.setRequestMethod(method);
        if (body != null) {
            // Write in the request body if there is one.
            connection.getOutputStream().write(body.getBytes(Charset.defaultCharset()));
        }
        // Tell the request to put the response in its InputStream.
        connection.setDoInput(true);
        // Actually make the request
        connection.connect();

        Log.d("Request", String.format("Returned with response code: %d",
                                       connection.getResponseCode()));
        return StreamUtil.toString(connection.getInputStream());
    }
}
