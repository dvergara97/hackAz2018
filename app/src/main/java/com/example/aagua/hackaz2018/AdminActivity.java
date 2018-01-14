package com.example.aagua.hackaz2018;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by aagua on 1/13/2018.
 */

public class AdminActivity extends AppCompatActivity implements View.OnClickListener {
    private Button eventButton;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        eventButton=findViewById(R.id.eventButton);
        eventButton.setOnClickListener(AdminActivity.this);
    }


    public void onClick(View view){
        Intent eventIntent=new Intent(AdminActivity.this,
                                      InputEventNameAndDescription.class);

        startActivity(eventIntent);
    }

    @Override
    public void onBackPressed() {
    }
}
