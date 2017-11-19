package wechat.liquiddark.com.wechat.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import wechat.liquiddark.com.wechat.fragments.MAChatFragment;
import wechat.liquiddark.com.wechat.fragments.MAFriendsFragment;
import wechat.liquiddark.com.wechat.fragments.MARequestFragment;

/**
 * Created by mhr on 20-Nov-17.
 */

class SelectionsPagerAdapter extends FragmentPagerAdapter{


    public SelectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:

                MAFriendsFragment maFriendsFragment = new MAFriendsFragment();
                return maFriendsFragment;


            case 1:

                MAChatFragment maChatFragment = new MAChatFragment();
                return maChatFragment;

            case 2:

                MARequestFragment maRequestFragment = new MARequestFragment();
                return maRequestFragment;

            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 0:
                return "Friends";
            case 1:
                return "Chat";
            case 2:
                return "Request";
            default:
        }

        return super.getPageTitle(position);
    }
}
