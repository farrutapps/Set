package com.farrutapps.set.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.farrutapps.set.R;


public class OnePlayerActivity extends AppCompatActivity {

    private Button btnSoloMode, btnTimeRace, btnVsCpu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_player);

        this.initResources();
        this.setResources();
    }

    private void initResources(){
        this.btnSoloMode = (Button) findViewById(R.id.btn_solomode);
        this.btnTimeRace = (Button) findViewById(R.id.btn_timerace);
        this.btnVsCpu = (Button) findViewById(R.id.btn_vscpu);
    }

    private void setResources(){
        this.btnSoloMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO general function in Controller ?
                Intent intent = new Intent(OnePlayerActivity.this, BoardActivity.class);
                startActivity(intent);
            }
        });

        this.btnTimeRace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO general function in Controller ?
                Intent intent = new Intent(OnePlayerActivity.this, BoardActivity.class);
                startActivity(intent);
            }
        });

        this.btnVsCpu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO general function in Controller ?
                Intent intent = new Intent(OnePlayerActivity.this, BoardActivity.class);
                startActivity(intent);
            }
        });
    }
}
