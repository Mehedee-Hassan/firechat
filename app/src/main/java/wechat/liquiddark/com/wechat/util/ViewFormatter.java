package wechat.liquiddark.com.wechat.util;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

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





    public Typeface setFontCasualBold(Context context){

        Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/casual.ttf");
        return tf;
    }

    public Typeface setFontAvro(Context context){

        Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/arvoregular.ttf");
        return tf;
    }

    public Typeface setFontAcme(Context context){

        Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/acmeregular.ttf");
        return tf;
    }
    public Typeface setFontJosefinsans(Context context){

        Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/josefinsansregular.ttf");
        return tf;
    }


}
