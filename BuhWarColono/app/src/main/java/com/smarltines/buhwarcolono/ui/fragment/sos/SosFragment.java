package com.smarltines.buhwarcolono.ui.fragment.sos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.smarltines.buhwarcolono.R;

import androidx.fragment.app.Fragment;


public class SosFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_sos, container, false);
        return inflate;
    }


    public static SosFragment newInstance() {
        SosFragment frag = new SosFragment();
        Bundle args = new Bundle();
        frag.setArguments(args);
        return frag;
    }


}
