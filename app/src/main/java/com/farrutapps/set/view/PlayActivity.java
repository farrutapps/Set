package com.farrutapps.set.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.farrutapps.set.R;


public class PlayActivity extends AppCompatActivity {

    private Button btnOnePlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        this.initResources();
        this.setResources();
    }

    private void initResources() {
        this.btnOnePlayer = (Button) findViewById(R.id.btn_one_player);
    }

    private void setResources() {
        this.btnOnePlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO general function in Controller ?
                Intent intent = new Intent(PlayActivity.this, OnePlayerActivity.class);
                startActivity(intent);
            }
        });
    }
}