package com.smarltines.buhwarcolono.ui.fragment.guardia;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

import com.smarltines.buhwarcolono.R;
public class GuardiaFragment extends Fragment {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.guardia_fragment, container, false);

        return view;
    }

    public static GuardiaFragment newInstance() {
        GuardiaFragment frag = new GuardiaFragment();
        Bundle args = new Bundle();
        frag.setArguments(args);
        return frag;
    }


}
