package wechat.liquiddark.com.wechat.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import wechat.liquiddark.com.wechat.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MARequestFragment extends Fragment {


    public MARequestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_marequest, container, false);
    }

}
