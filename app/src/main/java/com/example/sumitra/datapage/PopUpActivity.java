package com.example.sumitra.datapage;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

public class PopUpActivity extends Activity {
    Button bnOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up);
        bnOk= (Button) findViewById(R.id.bn_ok);

        DisplayMetrics displayMetrics=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width=displayMetrics.widthPixels;
        int height=displayMetrics.heightPixels;

        getWindow().setLayout((int)(width*0.8),(int)(height*0.4));

        bnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PopUpActivity.this,DetailShow.class);
                startActivity(intent);


            }
        });
    }
}
