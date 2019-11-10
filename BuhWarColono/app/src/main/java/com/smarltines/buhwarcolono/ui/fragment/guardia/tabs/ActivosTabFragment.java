package com.smarltines.buhwarcolono.ui.fragment.guardia.tabs;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.smarltines.buhwarcolono.R;
import com.smarltines.buhwarcolono.ui.activity.GuardiaActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class ActivosTabFragment extends Fragment {
    private CardView act1;
    private CardView act2;
    private CardView act3;
    private CardView act4;
    private CardView act5;
    private TextView txtDateVisita;
    private Spinner spinnerVisita;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.fragment_tab_activos, container, false);

        act1 = (CardView) view.findViewById(R.id.Act1);
        act2 = (CardView) view.findViewById(R.id.Act2);
        act3 = (CardView) view.findViewById(R.id.Act3);
        act4 = (CardView) view.findViewById(R.id.Act4);
        act5 = (CardView) view.findViewById(R.id.Act5);

        act1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GuardiaActivity.class);
                startActivity(intent);
            }

        });

        act2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GuardiaActivity.class);
                startActivity(intent);
            }

        });

        act3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GuardiaActivity.class);
                startActivity(intent);
            }

        });

        act4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GuardiaActivity.class);
                startActivity(intent);
            }

        });

        act5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GuardiaActivity.class);
                startActivity(intent);
            }

        });

        return view;
    }

    public static ActivosTabFragment newInstance() {
        ActivosTabFragment frag = new ActivosTabFragment();
        Bundle args = new Bundle();
        frag.setArguments(args);
        return frag;
    }


}
