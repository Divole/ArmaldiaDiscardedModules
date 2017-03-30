package com.armaldia.game.drawer.university.asynk_task;

import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LearnAsyncTask extends AsyncTask<Void, Void, Boolean> {

    private Context context;
    private URL job_center_url;
    private JSONObject output_json;

    public LearnAsyncTask(Context context, int contractID, int amount) {
        this.context = context;
        try {
            job_center_url = new URL("http://testing.armaldia.com/university/ajax-learn/"+contractID+"/1/"+amount+"/1");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        HttpURLConnection conn = null;

        try {
            conn = (HttpURLConnection) job_center_url.openConnection();
            conn.setRequestProperty("Accept", "*/*");
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(10000);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.connect();
            BufferedReader bf;
            StringBuilder sb;

            System.out.println("JOB CENTER: response code - " + conn.getResponseCode());

            if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){

//                System.out.println("JOB CENTER: status OK ");
//                bf = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//                sb = new StringBuilder();
//
//                String line;
//
//                while ((line = bf.readLine()) != null) {
//                    sb.append(line);
//                }
//                if (!sb.toString().equals("")){
//                    output_json = new JSONObject(sb.toString());
//                }
                conn.disconnect();
                return true;
            }else{
                conn.disconnect();
                return false;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        if (aBoolean){
            if (output_json != null){
//                ((UICallbacks)context).updateAfterDoingContract();
            }
        }
    }
}
