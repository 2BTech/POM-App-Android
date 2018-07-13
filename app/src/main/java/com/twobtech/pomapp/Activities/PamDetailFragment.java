package com.twobtech.pomapp.Activities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twobtech.pomapp.R;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PamDetailFragment extends MultiPAMFragment {


    /*
    Create fragment to desplay information about pam
    */

    public List<View> fragments = new ArrayList<View>();

    public PamDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pam_detail, container, false);
    }

    public void createFragmetns(int numberOfViews, List<Device.Packet> packets)
    {

    }

}
