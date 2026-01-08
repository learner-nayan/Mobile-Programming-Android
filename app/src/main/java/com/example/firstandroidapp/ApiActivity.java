package com.example.firstandroidapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiActivity extends AppCompatActivity {
    Button btnFetch;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.api_linear);

        btnFetch = findViewById(R.id.fetch);
        textResult = findViewById(R.id.result);

        btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new GetDataTask().execute();
            }
        });
    }

    private class GetDataTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids) {
            String result = "";

            try {
                URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.setRequestMethod("GET");
                connection.connect();

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream())
                );

                String line;
                StringBuilder builder = new StringBuilder();

                while ((line = reader.readLine()) != null)
                {
                    builder.append(line);
                }
                reader.close();
                result = builder.toString();

            } catch (Exception e){
                e.printStackTrace();
            }
            return result;
        }

        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            try {
                JSONObject jsonObject = new JSONObject(result);

                String title = jsonObject.getString("title");
                String body = jsonObject.getString("body");

                textResult.setText("Title:\n" + title + "\n\nBody\n" + body);
            } catch (Exception e) {
                textResult.setText("Error parsing data");
            }
        }
    }
}
