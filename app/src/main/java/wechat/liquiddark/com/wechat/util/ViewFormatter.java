package wechat.liquiddark.com.wechat.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import wechat.liquiddark.com.wechat.R;

/**
 * Created by mhr on 19-Nov-17.
 */

public class ViewFormatter {

    public void toolbarAdder(Toolbar mainToolbar , AppCompatActivity appCompatActivity ,int resourceId){
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            mainToolbar = (Toolbar) appCompatActivity.findViewById(resourceId);
            appCompatActivity.setSupportActionBar(mainToolbar);
            appCompatActivity.getSupportActionBar().setTitle("FireChat");


        }
    }

    /**
     * @param mainToolbar
     * @param appCompatActivity
     * @param resourceId
     * @param titileText
     * @param showBackButton
     * @param showBack2HButton
     */
    public void toolbarAdder(Toolbar mainToolbar , AppCompatActivity appCompatActivity
            ,int resourceId,String titileText
            ,boolean showBackButton ,boolean showBack2HButton){

//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP)
        {
            mainToolbar = (Toolbar) appCompatActivity.findViewById(resourceId);
            appCompatActivity.setSupportActionBar(mainToolbar);
            appCompatActivity.getSupportActionBar().setTitle("FireChat");

            if(showBackButton){
                appCompatActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(showBack2HButton);
            }

        }
    }


}
