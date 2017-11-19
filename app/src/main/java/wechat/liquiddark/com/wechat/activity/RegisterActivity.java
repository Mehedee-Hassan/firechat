package wechat.liquiddark.com.wechat.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import wechat.liquiddark.com.wechat.R;
import wechat.liquiddark.com.wechat.util.ViewFormatter;

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = "RegisterActivity";


    EditText mUserName;
    EditText mEmail;
    EditText mPassword;
    Button registerButton;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private ViewFormatter viewFormatter;
    Toolbar mainToolbar;


    ProgressDialog mprProgressDialog ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        mUserName = (EditText) findViewById(R.id.reg_user_name);
        mEmail = (EditText) findViewById(R.id.reg_email);
        mPassword = (EditText) findViewById(R.id.reg_password);
        registerButton=(Button) findViewById(R.id.reg_button);

        viewFormatter = new ViewFormatter();
        viewFormatter.toolbarAdder(mainToolbar,this,R.id.reg_act_app_bar,"Create Account",true,true);

        mprProgressDialog = new ProgressDialog(this);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = mUserName.getText().toString();
                String email = mEmail.getText().toString();
                String mpass = mPassword.getText().toString();


                if (!userName.equals("")&& !email.equals("") && !mpass.equals("")){
                    createAccount(userName,email,mpass);


                    mprProgressDialog.setTitle("Register user");
                    mprProgressDialog.setMessage("Creating new user");
                    mprProgressDialog.setCanceledOnTouchOutside(false);


                    mprProgressDialog.show();
                }
                else{
                    Toast.makeText(RegisterActivity.this, "Please fillup blanks",Toast.LENGTH_SHORT).show();
                }

                Log.d(TAG, " == "+email+" "+mpass);

            }
        });

    }

    private void createAccount(String username ,String email ,String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful()+task.toString());
                        if (!task.isSuccessful()) {

                            mprProgressDialog.hide();
                            Toast.makeText(RegisterActivity.this, R.string.auth_failed,
                                    Toast.LENGTH_SHORT).show();



                        }else{

                            mprProgressDialog.dismiss();
                            Toast.makeText(RegisterActivity.this, R.string.register_succed,
                                    Toast.LENGTH_SHORT).show();
                            Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                            startActivity(new Intent(RegisterActivity.this,MainActivity.class));
                            finish();


                        }

                        // ...
                    }
                });
    }


}
