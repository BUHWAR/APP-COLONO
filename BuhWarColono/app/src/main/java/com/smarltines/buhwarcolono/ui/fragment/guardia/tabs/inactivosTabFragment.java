package com.smarltines.buhwarcolono.ui.fragment.guardia.tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.smarltines.buhwarcolono.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import androidx.fragment.app.Fragment;

public class inactivosTabFragment extends Fragment {
    private TextView txtDateVisita;
    private Spinner spinnerVisita;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.fragment_tab_inactivos, container, false);


        return view;
    }

    public static inactivosTabFragment newInstance() {
        inactivosTabFragment frag = new inactivosTabFragment();
        Bundle args = new Bundle();
        frag.setArguments(args);
        return frag;
    }


}
