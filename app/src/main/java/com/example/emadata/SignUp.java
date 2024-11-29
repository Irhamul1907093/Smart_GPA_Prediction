package com.example.emadata;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    private Button signUpButton;
    private EditText usernameEditText, emailEditText, passwordEditText, rePasswordEditText;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        mAuth = FirebaseAuth.getInstance();

        usernameEditText = findViewById(R.id.username);
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        rePasswordEditText = findViewById(R.id.repassword);
        progressBar = findViewById(R.id.progressBar);

        signUpButton = findViewById(R.id.signupbtn);
        signUpButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.signupbtn) {
            signUp();
        }
    }

    private void signUp() {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String rePassword = rePasswordEditText.getText().toString().trim();

        // Show ProgressBar
        progressBar.setVisibility(View.VISIBLE);

        if(email.isEmpty())
        {
            emailEditText.setError( "Enter email address");
            emailEditText.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.setError( "Invalid email address");
            return;
        }

        if(password.isEmpty())
        {
            passwordEditText.setError( "Enter password");
            passwordEditText.requestFocus();
            return;
        }

        if(password.length()<6)
        {
            passwordEditText.setError( "Minimum length of a password should be 6");
            passwordEditText.requestFocus();
            return;
        }

        if (!password.equals(rePassword) || rePassword.isEmpty()) {
            rePasswordEditText.setError( "Passwords do not match");
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<com.google.firebase.auth.AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<com.google.firebase.auth.AuthResult> task) {
                        if (task.isSuccessful()) {
                            progressBar.setVisibility(View.INVISIBLE);
                            // Sign up success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            // You can add additional actions here, e.g., redirect to a profile page
                            Toast.makeText(SignUp.this, "Sign up successful!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignUp.this, Login.class));
                            finish(); // Close the SignUp activity after successful sign-up
                        } else {
                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                Toast.makeText(getApplicationContext(), "User is already registered", Toast.LENGTH_SHORT).show();
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(SignUp.this, "Sign UP not successful : " + task.getException().getMessage(),
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
    }
    }
