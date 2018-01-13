package com.example.aagua.hackaz2018;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{
    private Button child;
    private Button parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        child = findViewById(R.id.child);
        child.setOnClickListener(this);
        parent = findViewById(R.id.parent);
        parent.setOnClickListener(MainActivity.this);

    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.child:
                Intent childRegister=new Intent(MainActivity.this, CalendarActivity.class);

                startActivity(childRegister);
                break;
            case R.id.parent:
                break;
            default:
                break;
        }

    }
}
