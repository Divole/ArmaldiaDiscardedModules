package com.armaldia.game.drawer.gym.async_task;

import android.content.Context;
import android.os.AsyncTask;

import com.armaldia.game.callbacks.UICallbacks;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetGymDataAsyncTask extends AsyncTask<Void, Void, Boolean> {
    private Context context;
    private URL gym_url;
    private JSONObject output_json;

    public GetGymDataAsyncTask(Context context) {
        this.context = context;
        try {
            gym_url = new URL("http://testing.armaldia.com/gym/json-list-activities");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) gym_url.openConnection();
            conn.setRequestProperty("Accept", "*/*");
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(10000);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.setDoOutput(false);
            conn.connect();
            BufferedReader bf;
            StringBuilder sb;

            int status  = conn.getResponseCode();

            System.out.println("JOB CENTER: response code - "+status);

            if(status == HttpURLConnection.HTTP_OK){

                System.out.println("JOB CENTER: status OK ");
                bf = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                sb = new StringBuilder();

                String line;

                while ((line = bf.readLine()) != null) {
                    sb.append(line);
                }
                if (!sb.toString().equals("")){
                    output_json = new JSONObject(sb.toString());
                }
                conn.disconnect();
                return true;
            }else{
                conn.disconnect();
                return false;
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        if (aBoolean){
            if (output_json != null){
                ((UICallbacks)context).updateGymUI(output_json);
            }
        }
    }
}
