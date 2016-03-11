package com.udacity.gradle.builditbigger;

import android.test.InstrumentationTestCase;
import android.test.InstrumentationTestCase;
import android.util.Log;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by katsw on 09/03/2016.
 */
public class Test extends InstrumentationTestCase implements IResultHandler {
    private static boolean called;
    private CountDownLatch signal = new CountDownLatch(1);
    private String joke="";
    public final void testSuccessfulFetch() throws Throwable {
        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                new JokeTask(Test.this).execute(getInstrumentation().getContext());
            }
        });

        signal.await(10, TimeUnit.SECONDS);
        Log.d("Testing", "Joke is: " + joke);
        assertNotNull("Joke is not null",joke);
        if(joke!=null) {
            boolean empty = joke.isEmpty();
            Log.d("Testing", "Is Empty: " + empty);
            assertFalse("Joke needs to hold something", joke.isEmpty());
        }



    }

    @Override
    public void gotJoke(String joke) {
        this.joke=joke;
        signal.countDown();
    }
}
