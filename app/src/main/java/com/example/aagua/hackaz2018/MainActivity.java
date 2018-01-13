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
    private Button childButton;
    private Button parentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        childButton = findViewById(R.id.child);
        childButton.setOnClickListener(this);
        parentButton = findViewById(R.id.parent);
        parentButton.setOnClickListener(MainActivity.this);

    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.child:
                switchToChildLogin();
                break;
            case R.id.parent:
                switchToAdultLogin();
                break;
            default:
                break;
        }

    }

    public void switchToChildLogin(){
        Intent childRegister=new Intent(MainActivity.this, ChildLogIn.class);
        startActivity(childRegister);
    }

    public void switchToAdultLogin(){
        Intent parentRegister=new Intent(this, ChildLogIn.class);
        startActivity(parentRegister);
    }
}
