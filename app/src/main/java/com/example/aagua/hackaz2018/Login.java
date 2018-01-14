package com.example.aagua.hackaz2018;


import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by aagua on 1/13/2018.
 */

public class Login extends AppCompatActivity implements View.OnClickListener  {
    private Button nextPageButton;
    private Toolbar myToolbar;
    private EditText emailText;
    private DatabaseReference DBReference;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // getReference allows us access to the root node
        DBReference=FirebaseDatabase.getInstance().getReference();

        myToolbar = findViewById(R.id.login_toolbar);
        myToolbar.setTitle("Log In");
        setSupportActionBar(myToolbar);

        nextPageButton=findViewById(R.id.next);
        nextPageButton.setOnClickListener(this);

        emailText=findViewById(R.id.emailText);

    }

    public void onClick(View view){
        String email=emailText.getText().toString().trim();
        String emailPattern="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (email.matches(emailPattern)) {
<<<<<<< HEAD

=======
            /*
            User me=new User("A","A", "5208919545", email,
                             "HOLA",true);

            DBReference.child("users").child("child").setValue(me);
            */

            mAuthListener = new FirebaseAuth.AuthStateListener() {

                @Override
                public void onAuthStateChanged(FirebaseAuth mAuth) {
                    System.out.println("daniel");
                    Intent calendarIntent = new Intent(Login.this, CalendarActivity.class);
                    startActivity(calendarIntent);
                }
            } ;
            mAuth.addAuthStateListener(mAuthListener);
            mAuth.signInWithEmailAndPassword(email,"123456");
>>>>>>> f5aa68419b0ed3e5542f196cb9ba796295d44651

        }
        else {
            Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();
        }

    }
}
