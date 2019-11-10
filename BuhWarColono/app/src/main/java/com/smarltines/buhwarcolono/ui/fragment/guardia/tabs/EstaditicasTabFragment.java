package com.smarltines.buhwarcolono.ui.fragment.guardia.tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.smarltines.buhwarcolono.R;

public class EstaditicasTabFragment extends Fragment {
    private TextView txtDateVisita;
    private Spinner spinnerVisita;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.fragment_estadisticas, container, false);

        return view;
    }

    public static EstaditicasTabFragment newInstance() {
        EstaditicasTabFragment frag = new EstaditicasTabFragment();
        Bundle args = new Bundle();
        frag.setArguments(args);
        return frag;
    }


}
