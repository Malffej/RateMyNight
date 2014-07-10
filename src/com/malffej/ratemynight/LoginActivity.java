package com.malffej.ratemynight;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

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

		// Setting onClickListener for SignupTextView to take user to
		// SignupActivity if clicked (via intent)
		mSignupTextView.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(LoginActivity.this,
						SignupActivity.class);
				startActivity(intent);
			}
		});

		// Takes user to MainActivity if a login is successful, and if not then
		// prompts for an error message
		mLoginButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				// Get the String values for both mUsername & mPassword, trim
				// any white spaces, and store them in variables
				String username = mUsername.getText().toString().trim();
				String password = mPassword.getText().toString().trim();

				// Test mUsername & mPassword fields for input, if empty then
				// prompt user an AlertDialog with an error message
				if (username.isEmpty() || password.isEmpty()) {
					AlertDialog.Builder builder = new AlertDialog.Builder(
							LoginActivity.this);
					builder.setTitle(R.string.login_activity_error_title);
					builder.setMessage(R.string.login_activity_error_message);
					builder.setPositiveButton(android.R.string.ok, null);
					AlertDialog dialog = builder.create();
					dialog.show();
				} else {

					// Attempt to Login
					ParseUser.logInInBackground(username, password,
							new LogInCallback() {

								@Override
								public void done(ParseUser user,
										ParseException e) {
									if (e == null) {
										// Success!
										Intent intent = new Intent(
												LoginActivity.this,
												MainActivity.class);
										intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
										intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
										startActivity(intent);
									} else {
										// Prompt AlertDialog box with parse
										// exception error
										AlertDialog.Builder builder = new AlertDialog.Builder(
												LoginActivity.this);
										builder.setTitle(R.string.login_activity_error_title);
										builder.setMessage(e.getMessage());
										builder.setPositiveButton(
												android.R.string.ok, null);
										AlertDialog dialog = builder.create();
										dialog.show();
									}
								}
							});
				}
			}
		});
	}
}
