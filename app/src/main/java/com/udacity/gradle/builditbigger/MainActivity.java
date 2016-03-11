package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.nekokittygames.jokedisplay.JokeDisplay;


public class MainActivity extends AppCompatActivity  implements IResultHandler{

    private Button mJokeButton;
    private ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mJokeButton = (Button) findViewById(R.id.jokeButton);


        AdManager.InitInterstatialAd(this, mJokeButton);
        AdManager.loadInterstitial(this);
    }



    public static void MakeJoke(MainActivity context) {
        context.progress=new ProgressDialog(context);
        context.progress.setTitle("Loading");
        context.progress.setMessage("Wait while loading...");
        context.progress.show();
        new JokeTask(context).execute(context);
    }



    @Override
    protected void onResume() {
        super.onResume();
        if(!AdManager.isPaid())
            mJokeButton.setEnabled(false);
        AdManager.InitInterstatialAd(this,mJokeButton);
        AdManager.loadInterstitial(this);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view){

            AdManager.showInterstitial(this);
    }


    @Override
    public void gotJoke(String joke) {
        progress.dismiss();
        Intent intent = new Intent(this, JokeDisplay.class);
        intent.putExtra("joke", joke);
        this.startActivity(intent);
    }
}
