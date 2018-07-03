package com.appbasic.fragment1;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity  {
    int width, height;
    private Button btn_fragment, btn_SqliteDb;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        width = dm.widthPixels;
        height = dm.heightPixels;

        btn_fragment = (Button) findViewById(R.id.btn_fragment);
        btn_SqliteDb = (Button) findViewById(R.id.btn_SqliteDb);

        btn_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StartActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btn_SqliteDb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(StartActivity.this,SqliteActivity.class);
                startActivity(intent2);
            }
        });

    }
}
