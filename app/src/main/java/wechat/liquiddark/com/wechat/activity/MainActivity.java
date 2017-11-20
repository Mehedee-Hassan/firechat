package wechat.liquiddark.com.wechat.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import wechat.liquiddark.com.wechat.R;
import wechat.liquiddark.com.wechat.util.ViewFormatter;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private Button gotoReg;
    private static final String TAG = "MainActivity";
    Toolbar mainToolbar ;
    ViewFormatter viewFormatter;
    private ViewPager chatPager;
    private SelectionsPagerAdapter mSelectionPager;
    private TabLayout mTablayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "on create");

        mAuth = FirebaseAuth.getInstance();

        viewFormatter = new ViewFormatter();
        viewFormatter.toolbarAdder(mainToolbar,this,R.id.main_app_bar);

        chatPager = (ViewPager) findViewById(R.id.main_act_view_pager);
        mSelectionPager = new SelectionsPagerAdapter(getSupportFragmentManager());
        chatPager.setAdapter(mSelectionPager);

        mTablayout = (TabLayout) findViewById(R.id.main_act_tab_lo_id);
        mTablayout.setupWithViewPager(chatPager);



         authenticateFireb();
    }

    private void authenticateFireb() {
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
//                    startActivity(new Intent(MainActivity.this,StartActivity.class));
                } else {
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                    gotToStart();
                }
            }
        };
    }




    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }
    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }


    private void gotToStart(){
        startActivity(new Intent(MainActivity.this,StartActivity.class));
        finish();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        if (item.getItemId() == R.id.m_menu_all_users_itm){

        }
        else if (item.getItemId() == R.id.m_menu_acc_sett_itm){

        }
        else if (item.getItemId() == R.id.m_menu_logout_itm){

//            FirebaseAuth.getInstance().signOut();
            gotToStart();
        }

        return true;
    }
}
