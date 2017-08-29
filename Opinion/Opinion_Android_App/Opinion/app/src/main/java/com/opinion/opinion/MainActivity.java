package com.opinion.opinion;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

        private TextView responseTextView;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            this.responseTextView = (TextView) this.findViewById(R.id.responseTextView);

            // Get data with AsyncTask - need IP from Marvin
           // new GetAllCustomersBackgroundTask().execute(new ApiConnector());

            final Button buttonRestaurant = (Button) findViewById(R.id.buttonRestaurant);
            buttonRestaurant.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // Perform action on click
                    startRestaurantFinder(v);
                }
            });
            final Button buttonAddUser = (Button) findViewById(R.id.buttonRestaurant);
            buttonAddUser.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // Perform action on click
                    addUser(v);
                }
            });

    }

    public void setTextToTextView(JSONArray jsonArray)
    {
        // Prints, might want to save?
        String s="";
        for(int i=0; i<jsonArray.length();i++)
        {
            JSONObject json = null;
            try {
                json=jsonArray.getJSONObject(i);
                s=s+
                        "Name: " +json.getString("Fieldname1")+" "+json.getString("Fieldname2")+"\n";
            }catch(JSONException e){
                e.printStackTrace();
            }
            this.responseTextView.setText(s);
        }
    }
    private class GetAllCustomersBackgroundTask extends AsyncTask<ApiConnector,Long,JSONArray>
    {
        @Override
        protected JSONArray doInBackground(ApiConnector... params) {
            // Executed on background thread
            return params[0].GetAllCustomers();
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {
            // Main thread execution
            setTextToTextView(jsonArray);
        }
    }

    /** Called when the user taps the Send button */
    public void addUser(View view) {
        Intent intent = new Intent(this, restaurantFind.class);
        //EditText editText = (EditText) findViewById(R.id.editText);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    /** Called when the user taps the Send button */
    public void startRestaurantFinder(View view) {
        Intent intent = new Intent(this, restaurantFind.class);
        //EditText editText = (EditText) findViewById(R.id.editText);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }



}
