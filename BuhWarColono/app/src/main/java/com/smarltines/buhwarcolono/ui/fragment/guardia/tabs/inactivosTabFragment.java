package com.smarltines.buhwarcolono.ui.fragment.guardia.tabs;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.smarltines.buhwarcolono.R;
import com.smarltines.buhwarcolono.ui.activity.GuardiaActivity;
import com.smarltines.buhwarcolono.ui.activity.LoginActivity;
import com.smarltines.buhwarcolono.ui.activity.MainActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class inactivosTabFragment extends Fragment {
    private CardView ina1;
    private CardView ina2;
    private CardView ina3;
    private CardView ina4;
    private CardView ina5;
    private TextView txtDateVisita;
    private Spinner spinnerVisita;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.fragment_tab_inactivos, container, false);

        ina1 = (CardView) view.findViewById(R.id.Ina1);
        ina2 = (CardView) view.findViewById(R.id.Ina2);
        ina3 = (CardView) view.findViewById(R.id.Ina3);
        ina4 = (CardView) view.findViewById(R.id.Ina4);
        ina5 = (CardView) view.findViewById(R.id.Ina5);

        ina1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GuardiaActivity.class);
                startActivity(intent);
            }

        });

        ina2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GuardiaActivity.class);
                startActivity(intent);
            }

        });

        ina3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GuardiaActivity.class);
                startActivity(intent);
            }

        });

        ina4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GuardiaActivity.class);
                startActivity(intent);
            }

        });

        ina5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GuardiaActivity.class);
                startActivity(intent);
            }

        });

        return view;
    }

    public static inactivosTabFragment newInstance() {
        inactivosTabFragment frag = new inactivosTabFragment();
        Bundle args = new Bundle();
        frag.setArguments(args);
        return frag;
    }


}
