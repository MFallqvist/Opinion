package com.opinion.opinion;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Marcus on 2017-07-04, based on Youtube tutorial. Connecting to web database running php we get JSON data
 */
public class ApiConnector {

    public JSONArray GetAllCustomers()
    {
        // URL for getting all customers
        InputStream in = null;
        try {
            URL url = new URL("http://ip.marvinpls.php");

            //Open connection and read stream
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            try {
                in = new BufferedInputStream(urlConnection.getInputStream());
                //readStream(in);
            } finally {
                urlConnection.disconnect();
            }

        }catch(java.io.IOException e){
            e.printStackTrace();
        }
        // Convert stream to JSON
        JSONArray jsonArray = null;
        if (in != null){
            try{
                String httpRespose = in.toString(); // need mod

                Log.e("Response from http: ", httpRespose);

                jsonArray = new JSONArray(httpRespose);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
return null;
    }
}
