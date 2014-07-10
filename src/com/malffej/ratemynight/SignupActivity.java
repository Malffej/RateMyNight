package com.malffej.ratemynight;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

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

		// Creates a new user on back-end if all fields are filled out
		// correctly.
		mSignupButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				// Get the String values for mUsername, mPassword, and mEmail,
				// trim any white spaces, and store them in variables
				String username = mUsername.getText().toString().trim();
				String password = mPassword.getText().toString().trim();
				String email = mEmail.getText().toString().trim();

				// Test mUsername, mPassword, and mEmail fields for input, if
				// empty then prompt user an AlertDialog with an error message
				if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {

					// AlertDialog box for an error.
					AlertDialog.Builder builder = new AlertDialog.Builder(
							SignupActivity.this);
					builder.setTitle(R.string.signup_activity_error_title);
					builder.setMessage(R.string.signup_activity_error_message);
					builder.setPositiveButton(android.R.string.ok, null);
					AlertDialog dialog = builder.create();
					dialog.show();
				} else {
					// Creating a new user
					ParseUser newUser = new ParseUser();
					newUser.setUsername(username);
					newUser.setEmail(email);
					newUser.setPassword(password);
					newUser.signUpInBackground(new SignUpCallback() {

						@Override
						public void done(ParseException e) {
							if (e == null) {

								// Create a new user
								Intent intent = new Intent(SignupActivity.this,
										MainActivity.class);
								intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
								intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
								startActivity(intent);

							} else {

								// Prompt AlertDialog error
								AlertDialog.Builder builder = new AlertDialog.Builder(
										SignupActivity.this);
								builder.setTitle(R.string.signup_activity_error_title);
								builder.setMessage(e.getMessage());
								builder.setPositiveButton(android.R.string.ok,
										null);
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