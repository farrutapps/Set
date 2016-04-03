package com.farrutapps.set.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.farrutapps.set.R;
import com.farrutapps.set.controller.Controller;

public class HomeActivity extends AppCompatActivity {

    private Button btnPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // TODO temp
        new Controller();

        this.initResources();
        this.setResources();
    }

    private void initResources(){
        this.btnPlay = (Button) findViewById(R.id.btn_play);
    }

    private void setResources(){
        this.btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO general function in Controller ?
                Intent intent = new Intent(HomeActivity.this, PlayActivity.class);
                startActivity(intent);
            }
        });
    }
}
