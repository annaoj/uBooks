package app.annaj.android.example.com.ubooks;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class RegisterActivity extends Activity {
    protected EditText mUsername;
    protected EditText mUserEmail;
    protected EditText mUserPassword;
    protected Button  mRegisterButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "JKd0yGq0yU2EJRr3YKEapb96PYB1208WSAm5Tl86", "uoT6fLTHqh9LWPtRharc71J3qReG1x5M9GS3NAQi");
    //initialize
        mUsername = (EditText)findViewById(R.id.usernameRegisterEditText);
        mUserEmail=(EditText) findViewById(R.id.emailRegisterEditText);
        mUserPassword=(EditText)findViewById(R.id.passwordRegisterEditText);
        mRegisterButton=(Button)findViewById(R.id.registerButton);
//Listen to register button click
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // Toast.makeText(RegisterActivity.this, "Hi!", Toast.LENGTH_LONG).show();

            //get username , email and concert to string
                String username=mUsername.getText().toString().trim();
                String password=mUserPassword.getText().toString().trim();
                String email=mUserEmail.getText().toString().trim();


                //store new user in Parse and check if it's unique
                ParseUser user = new ParseUser();
                user.setUsername(username);
                user.setPassword(password);
                user.setEmail(email);
                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null){
                            //user signed up successfully

                            Toast.makeText(RegisterActivity.this, "Success.Welcome!", Toast.LENGTH_LONG).show();
                            //take user to the home page

                           //Intent takeUserToBrowseBooks=new Intent(RegisterActivity.this,BrowseBooksActivity.class);
                          //  startActivity(takeUserToBrowseBooks);
                        }
                        else{
                            //there was an error signing up user, advice user
                            Toast.makeText(RegisterActivity.this, "Error signing up!", Toast.LENGTH_LONG).show();

                        }
                    }
                });

            }
        });



    }

}
