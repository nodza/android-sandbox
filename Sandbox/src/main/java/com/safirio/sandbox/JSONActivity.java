package com.safirio.sandbox;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by noelhwande on 11/1/13.
 */
public class JSONActivity extends Activity {

    static String allvirtUrl = "https://allvirtuous.com/api/v1/container_buckets";

    static String userId ="";
    static String containerBarcode ="";
    static String location ="";
    static String longitude ="";
    static String latitude ="";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        new MyAsyncTask().execute();

    }

    private class MyAsyncTask extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {

            DefaultHttpClient httpClient = new DefaultHttpClient(new BasicHttpParams());

            HttpPost httpPost = new HttpPost(allvirtUrl);

            httpPost.setHeader("Content-type", "application/json");

            InputStream inputStream = null;

            String result = null;

            try {
                HttpResponse response = httpClient.execute(httpPost);
                HttpEntity entity = response.getEntity();
                inputStream = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
                StringBuilder theStringBuilder = new StringBuilder();

                String line = null;

                while ((line = reader.readLine()) != null) {
                    theStringBuilder.append(line + "\n");
                }
                result = theStringBuilder.toString();
            } catch (Exception e) {

            }

            finally {
                try {
                    if(inputStream != null) inputStream.close();
                } catch (Exception e) {

                }
            }
            JSONObject jsonObject;

            try {
                Log.v("JSONParser RESULT", result);

                jsonObject = new JSONObject(result);

                JSONObject queryJSONObject = jsonObject.getJSONObject("container_buckets");

                userId = queryJSONObject.getString("user_id");
                containerBarcode = queryJSONObject.getString("container_barcode");
                location = queryJSONObject.getString("location");
                longitude = queryJSONObject.getString("geo_long");
                latitude = queryJSONObject.getString("geo_lat");

//                JSONArray queryArray = queryJSONObject.names();
//                Log.i(JSONActivity.class.getName(),
//                        "Number of entries " + queryArray.length());
//
//                List<String> list = new ArrayList<String>();
//                for (int i = 0; i < queryArray.length(); i++) {
//                    list.add(queryArray.getString(i));
//                }

//                for(String item : list) {
//                    Log.v("JSON ARRAY ITEMS", item);
//                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            TextView line1 = (TextView) findViewById(R.id.line1);
            TextView line2 = (TextView) findViewById(R.id.line2);
            TextView line3 = (TextView) findViewById(R.id.line3);
            TextView line4 = (TextView) findViewById(R.id.line4);
            TextView line5 = (TextView) findViewById(R.id.line5);

            line1.setText("User ID: " + userId);
            line2.setText("Barcode: " + containerBarcode);
            line3.setText("Location: " + location);
            line4.setText("Longitude: " + longitude);
            line5.setText("Latitude: " + latitude);
        }
    }
}

// 20:29 http://www.youtube.com/watch?v=qcotbMLjlA4