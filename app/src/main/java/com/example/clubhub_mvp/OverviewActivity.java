package com.example.clubhub_mvp;

import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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


/*        Button[] allButtons = new Button[5];

        for (int i = 0; i < 5; i++) {
            Button button = new Button(this);
            LinearLayout.LayoutParams par = (LinearLayout.LayoutParams) button.getLayoutParams();
            par.topMargin = 0;
            button.setLayoutParams(par);
            allButtons[i] = button;

            ((LinearLayout) findViewById(R.id.ll)).addView(button);
        }
*/
        // Intent for the activity to open when user selects the notification
        Intent detailsIntent = new Intent(this, EventActivity.class);

        // Use TaskStackBuilder to build the back stack and get the PendingIntent
        PendingIntent pendingIntent =
                TaskStackBuilder.create(this)
                        // add all of DetailsActivity's parents to the stack,
                        // followed by DetailsActivity itself
                        .addNextIntentWithParentStack(detailsIntent)
                        .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentIntent(pendingIntent);


        AsyncHttpClient client = new AsyncHttpClient();
        client.get("https://clubhubhackuci.herokuapp.com/clubs", new JsonHttpResponseHandler() {
                    @Override
                    public void onStart() {
                        //Start progress indicator here
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject responseBody) {
                        //Hide progress indicator

                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONArray responseBody) {
                        mainEvent.setText("");
                        try{

                            Button[] buttonList = new Button[responseBody.length()];
                            for (int i = 0; i < buttonList.length; i++){
                                buttonList[i] = findViewById(R.id.event_1);
                                buttonList[i].setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = new Intent(OverviewActivity.this,EventActivity.class);
                                        startActivity(intent);
                                        overridePendingTransition(R.anim.slide_up, R.anim.fade_out);
                                        finish();

                                    }
                                });

                                JSONObject info = responseBody.getJSONObject(0);
                                mainEvent.setText((info.getString("clubName")));

                                JSONObject info1 = responseBody.getJSONObject(1);
                                event1.setText((info1.getString("clubName")));

                                JSONObject info2 = responseBody.getJSONObject(2);
                                event2.setText((info2.getString("clubName")));

                                JSONObject info3 = responseBody.getJSONObject(3);
                                event3.setText((info3.getString("clubName")));

                                JSONObject info4 = responseBody.getJSONObject(4);
                                event4.setText((info4.getString("clubName")));

                                JSONObject info5 = responseBody.getJSONObject(5);
                                event5.setText((info5.getString("clubName")));

                                JSONObject info6 = responseBody.getJSONObject(6);
                                event6.setText((info6.getString("clubName")));


//                                buttonList[0].setText((info.getString("clubName")));

                            }
//                            JSONObject info = responseBody.getJSONObject(0);
//                            mainEvent.setText(info.getString("clubName"));

                        }
                        catch(JSONException e){

                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable error, JSONObject responseBody) {
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
