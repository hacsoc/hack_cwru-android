package org.hacsoc.hackcwru.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;

import org.hacsoc.hackcwru.gson.adapters.CalendarAdapter;

import java.util.Calendar;

/**
 * Factory to create Gson objects based on various adapters.
 * g
 * Created by andrew on 6/8/15.
 */
public class GSONFactory {
    public static Gson createCalendarAdapter() {
        /*
         * TODO: Not sure if creating this multiple times (i.e. registering the
         *       TypeHierarchyAdapter more than once) will cause problems.
         */
        return createGson(Calendar.class, new CalendarAdapter());
    }

    private static Gson createGson(Class klass, TypeAdapter adapter) {
        return new GsonBuilder().registerTypeHierarchyAdapter(klass, adapter).create();
    }
}
