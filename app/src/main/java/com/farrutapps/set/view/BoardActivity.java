package com.farrutapps.set.view;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.GridView;

import com.farrutapps.set.R;
import com.farrutapps.set.controller.Controller;
import com.farrutapps.set.model.Card;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class BoardActivity extends AppCompatActivity {

    private BoardAdapter boardAdapter;
    private Button btnSolution;
    private Button btnHint;
    private Button btnPause;
    private Chronometer chmTime;
    private GridView cardGrid;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    private boolean isTimeRunning;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        initResources();
        setResources();

        chmTime.start();
        isTimeRunning=true;

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    public void initResources() {
        this.btnSolution.findViewById(R.id.btn_solution);
        this.btnHint.findViewById(R.id.btn_hint);
        this.btnPause.findViewById(R.id.btn_pause);

        this.chmTime.findViewById(R.id.chm_time);
        this.chmTime.setBase(0);

        this.cardGrid = (GridView) findViewById(R.id.gv_cards);


    }

    public void setAdapter() {
        try {
            this.boardAdapter =new BoardAdapter(this, Controller.getBoard());
            this.cardGrid.setAdapter(this.boardAdapter);

        } catch (Exception e) {
        }
    }

    public void setResources() {

        this.btnSolution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Card> solution=Controller.findSolution();

                for (Card c: solution
                     ) {

                }
            }
        });

        this.btnHint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Card> hint = new ArrayList<Card>();
                hint = Controller.Hint(false);

                // TODO: Now display hint
            }
        });

        this.btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isTimeRunning) {
                    chmTime.stop();
                    isTimeRunning=true;
                }

                else {
                    chmTime.start();
                    isTimeRunning=false;
                }
            }
        });

    }



    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Board Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.farrutapps.set.view/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Board Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.farrutapps.set.view/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}