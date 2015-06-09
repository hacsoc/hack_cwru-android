package org.hacsoc.hackcwru.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Util functions regarding InputStream and OutputStream
 *
 * Created by andrew on 6/8/15.
 */
public class StreamUtil {
    private static final int EOF = -1;

    /**
     * Read an InputStream into a String. Assumes that the InputStream is
     * encoded in UTF-8.
     *
     * @param stream The InputStream to be read in.
     * @return The String containing the contents of :stream.
     * @throws IOException If the InputStream cannot be read from, or if stream is not UTF-8.
     */
    public static String toString(InputStream stream) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        Reader reader = new InputStreamReader(stream, "UTF-8");
        int read;
        while ((read = reader.read()) != EOF) {
            stringBuilder.append((char) read);
        }
        return stringBuilder.toString();
    }
}
