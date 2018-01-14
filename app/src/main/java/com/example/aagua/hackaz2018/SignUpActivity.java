package com.example.aagua.hackaz2018;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by aagua on 1/13/2018.
 */

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    Toolbar myToolbar;
    Button signButton;
    EditText firstText, lastText, phoneText, emailText, pswdText,conPswdText;
    CheckBox isParent;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();

    private DatabaseReference DBReference;

    public void onCreate(Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);

        setContentView(R.layout.activity_signup);

        myToolbar = findViewById(R.id.signin_toolbar);
        myToolbar.setTitle("Sign Up");
        setSupportActionBar(myToolbar);

        signButton=findViewById(R.id.signupButton);
        signButton.setOnClickListener(this);

        firstText = findViewById(R.id.firstName);
        lastText=findViewById(R.id.lastName);
        phoneText=findViewById(R.id.phoneText);
        emailText=findViewById(R.id.email);
        pswdText=findViewById(R.id.pswdText);
        conPswdText=findViewById(R.id.conPswdText);
        isParent=findViewById(R.id.isParent);
        DBReference= FirebaseDatabase.getInstance().getReference();
    }


    public void onClick(View view){
        String firstName=firstText.getText().toString().trim();
        String lastName=lastText.getText().toString().trim();
        String phoneNumber=phoneText.getText().toString().trim();
        String email=emailText.getText().toString().trim();
        String password=pswdText.getText().toString().trim();
        boolean isAdmin=isParent.isChecked();

        String emailPattern="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (email.matches(emailPattern)) {
            User person=new User(firstName,lastName, phoneNumber, email,
                    password,isAdmin);

            DBReference.child("users").child(firstName+" "+lastName).setValue(person);
            mAuth.createUserWithEmailAndPassword(email, password);
            goToNextScreen(person);
        }
        else {
            Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();
        }
    }

    public void goToNextScreen(User person){
        if(person.isAdmin()){
            Intent personIntent=new Intent(this, AdminActivity.class);
            startActivity(personIntent);
        }
        else{
            Intent personIntent=new Intent(this, CalendarActivity.class);
            startActivity(personIntent);
        }
    }
}
