package com.malffej.ratemynight;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
