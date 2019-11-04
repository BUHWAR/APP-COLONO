package com.smarltines.buhwarcolono.ui.fragment.clasificar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.smarltines.buhwarcolono.R;

public class ClasificarFragment extends Fragment {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.fragment_clasificar, container, false);

        return view;
    }

    public static ClasificarFragment newInstance() {
        ClasificarFragment frag = new ClasificarFragment();
        Bundle args = new Bundle();
        frag.setArguments(args);
        return frag;
    }


}
