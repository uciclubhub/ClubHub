package com.example.clubhub_mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class OverviewActivity extends AppCompatActivity {

    Button eventImage, mainEvent, event1, event2, event3, event4, event5, event6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.overview_activity);

        eventImage = findViewById(R.id.event_image);
        mainEvent = findViewById(R.id.main_event);
        event1 = findViewById(R.id.event_1);
        event2 = findViewById(R.id.event_2);
        event3 = findViewById(R.id.event_3);
        event4 = findViewById(R.id.event_4);
        event5 = findViewById(R.id.event_5);
        event6 = findViewById(R.id.event_6);


        AsyncHttpClient client = new AsyncHttpClient();
        client.get("https://clubhubhackuci.herokuapp.com/clubs", new AsyncHttpResponseHandler() {
                    @Override
                    public void onStart() {
                        //Start progress indicator here
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        //Hide progress indicator
                        mainEvent.setText(new String(responseBody));
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        error.printStackTrace();
                    }

                    @Override
                    public void onRetry(int retryNo) {
                        // Request was retried
                    }

                    @Override
                    public void onProgress(long bytesWritten, long totalSize) {
                        // Progress notification
                    }

                    @Override
                    public void onFinish() {
                        // Completed the request (either success or failure)
                    }
                });


        eventImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OverviewActivity.this,ClubActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_up, R.anim.fade_out);
                finish();

            }
        });

        mainEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OverviewActivity.this,EventActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_up, R.anim.fade_out);
                finish();

            }
        });

        event1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OverviewActivity.this,EventActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_up, R.anim.fade_out);
                finish();

            }
        });

        event2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OverviewActivity.this, EventActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_up, R.anim.fade_out);
                finish();

            }
        });

        event3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OverviewActivity.this,EventActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_up, R.anim.fade_out);
                finish();

            }
        });

        event4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OverviewActivity.this, EventActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_up, R.anim.fade_out);
                finish();

            }
        });
        event5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OverviewActivity.this,EventActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_up, R.anim.fade_out);
                finish();

            }
        });

        event6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OverviewActivity.this, EventActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_up, R.anim.fade_out);
                finish();

            }
        });
    }
}
