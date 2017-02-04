package com.preethi.captcha;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

/**
 * Created by BeulahPreethi on 2/4/2017.
 */

public class ChildActivity extends Activity   {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        Intent intent = getIntent();

        String Random1 = intent.getStringExtra("Ran1");
        String Random2 = intent.getStringExtra("Ran2");
        String Random3 = intent.getStringExtra("Ran3");
        String Random4 = intent.getStringExtra("Ran4");
        String Fin_RanItem = intent.getStringExtra("Fin_Ran");

    }
}
