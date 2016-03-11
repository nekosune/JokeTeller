package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.nekokittygames.jokedisplay.JokeDisplay;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by katsw on 09/03/2016.
 */
public class JokeTask extends AsyncTask<Context,Void,String> {

    private static MyApi myApiService = null;
    private Context context;
    private IResultHandler handler;
    public JokeTask(IResultHandler handler) {
        this.handler = handler;
    }
    @Override
    protected String doInBackground(Context... params) {
        context = params[0];
        if(myApiService==null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("http://192.168.0.23:8080")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            myApiService=builder.build();
        }
        try
        {
            return myApiService.getJoke().execute().getData();
        }
        catch (IOException e)
        {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        handler.gotJoke(s);
    }
}
