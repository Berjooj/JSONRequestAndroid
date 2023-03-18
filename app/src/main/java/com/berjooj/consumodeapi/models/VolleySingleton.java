package com.berjooj.consumodeapi.models;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingleton {

    private RequestQueue requestQueue;
    private static VolleySingleton currentInstance;

    private VolleySingleton(Context context) {
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    public static synchronized VolleySingleton getInstance(Context context) {
        if (currentInstance == null) {
            currentInstance = new VolleySingleton(context);
        }

        return currentInstance;
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }
}