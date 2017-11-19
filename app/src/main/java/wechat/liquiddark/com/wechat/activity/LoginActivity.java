package wechat.liquiddark.com.wechat.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import wechat.liquiddark.com.wechat.R;

public class LoginActivity extends AppCompatActivity {

    EditText etPassword,etEmail;
    Button loginBtn;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        etPassword = (EditText) findViewById(R.id.logact_log_passwordtv);
        etEmail = (EditText) findViewById(R.id.logact_log_email);
        loginBtn = (Button) findViewById(R.id.loginact_login_button);



        ifLoggedIn();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String password = etPassword.getText().toString();
                String email = etEmail.getText().toString();

                login(password,email);
            }

            
        });

    }

    private void ifLoggedIn() {

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                } else {
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
            }
        };
    }

    private void login(String password, String email) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());

                        if (!task.isSuccessful()) {
                            Log.w(TAG, "Log in with email failed", task.getException());


                            Toast.makeText(LoginActivity.this, R.string.auth_failed,
                                    Toast.LENGTH_SHORT).show();


                        }else{
                            startActivity(new Intent(LoginActivity.this,MainActivity.class));
                            finish();
                        }

                    }
                });
    }
}
