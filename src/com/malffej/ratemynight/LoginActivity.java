package com.malffej.ratemynight;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends Activity {
	
	// Declaring member variables
	protected EditText mUsername;
	protected EditText mPassword;
	protected Button mLoginButton;
	protected TextView mSignupTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		// Casting member variables to XML layout
		mUsername = (EditText) findViewById(R.id.loginActivityEditTextUsername);
		mPassword = (EditText) findViewById(R.id.loginActivityEditTextPassword);
		mLoginButton = (Button) findViewById(R.id.loginActivityButtonLogin);
		mSignupTextView = (TextView) findViewById(R.id.loginActivityTextViewSignup);
		
		// Setting onClickListener for SignupTextView to take user to SignupActivity if clicked (via intent)
		mSignupTextView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
				startActivity(intent);
			}
		});
		
		// Takes user to MainActivity if a login is successful, and if not then prompts for an error message
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
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
