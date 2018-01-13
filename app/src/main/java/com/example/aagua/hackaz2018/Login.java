package com.example.aagua.hackaz2018;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by aagua on 1/13/2018.
 */

public class Login extends Activity implements View.OnClickListener {
    private Button nextPageButton;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nextPageButton=findViewById(R.id.next);
        nextPageButton.setOnClickListener(this);
    }

    public void onClick(View view){
        Intent calendarIntent=new Intent(this, CalendarActivity.class);
        startActivity(calendarIntent);
    }
}
