package com.malffej.ratemynight;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignupActivity extends Activity {
	
	// Declaring member variables
	protected EditText mUsername;
	protected EditText mEmail;
	protected EditText mPassword;
	protected Button mSignupButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signup);
		
		// Casting member variables to XML layout
		mUsername = (EditText) findViewById(R.id.SignupActivityEditTextUsername);
		mEmail = (EditText) findViewById(R.id.SignupActivityEditTextEmail);
		mPassword = (EditText) findViewById(R.id.SignupActivityEditTextPassword);
		mSignupButton = (Button) findViewById(R.id.SignupActivityButtonSignup);
		
		// Creates a new user on back-end if all fields are filled out correctly.
		mSignupButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// Get the String values for mUsername, mPassword, and mEmail, trim any white spaces, and store them in variables
				String username = mUsername.getText().toString().trim();
				String password = mPassword.getText().toString().trim();
				String email = mEmail.getText().toString().trim();
				
				// Test mUsername, mPassword, and mEmail fields for input, if empty then prompt user an AlertDialog with an error message
				if (username.isEmpty() || password.isEmpty() || email.isEmpty()){
					AlertDialog.Builder builder = new AlertDialog.Builder(SignupActivity.this);
					builder.setTitle(R.string.signup_activity_error_title);
					builder.setMessage(R.string.signup_activity_error_message);
					builder.setPositiveButton(android.R.string.ok, null);
					AlertDialog dialog = builder.create();
					dialog.show();
				}
				else{
					
				}
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.signup, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
