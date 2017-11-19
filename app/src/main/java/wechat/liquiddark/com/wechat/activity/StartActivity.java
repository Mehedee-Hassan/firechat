package wechat.liquiddark.com.wechat.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import wechat.liquiddark.com.wechat.R;
import wechat.liquiddark.com.wechat.util.ViewFormatter;

public class StartActivity extends AppCompatActivity {


    Button registerButton ,loginButton;
    private ViewFormatter viewFormatter;
    Toolbar mainToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        initComponents();
        initListners();




    }




    private void initComponents() {
        loginButton = (Button) findViewById(R.id.start_goto_login_btn);
        registerButton = (Button) findViewById(R.id.startRegButton);
        viewFormatter = new ViewFormatter();
        viewFormatter.toolbarAdder(mainToolbar,StartActivity.this,R.id.start_act_app_bar);
    }



    private void initListners() {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regintent = new Intent(StartActivity.this,LoginActivity.class);
                startActivity(regintent);
                finish();
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent regintent = new Intent(StartActivity.this,RegisterActivity.class);
                startActivity(regintent);

            }
        });
    }
}
