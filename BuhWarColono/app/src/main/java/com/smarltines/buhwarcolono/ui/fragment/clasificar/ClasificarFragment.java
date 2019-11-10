package com.smarltines.buhwarcolono.ui.fragment.clasificar;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.smarltines.buhwarcolono.R;
import com.smarltines.buhwarcolono.ui.activity.DeatailGuardiaActivity;
import com.smarltines.buhwarcolono.ui.activity.LoginActivity;
import com.smarltines.buhwarcolono.ui.activity.MainActivity;

public class ClasificarFragment extends Fragment {

    private CardView c1;
    private CardView c2;
    private CardView c3;
    private CardView c4;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.fragment_clasificar, container, false);
        c1 = (CardView) view.findViewById(R.id.califica1);
        c2 = (CardView) view.findViewById(R.id.califica2);
        c3 = (CardView) view.findViewById(R.id.califica3);
        c4 = (CardView) view.findViewById(R.id.califica4);
        c1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(), DeatailGuardiaActivity.class);
                startActivity(intent);
            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(), DeatailGuardiaActivity.class);
                startActivity(intent);
            }
        });

        c3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(), DeatailGuardiaActivity.class);
                startActivity(intent);
            }
        });

        c4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(), DeatailGuardiaActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    public static ClasificarFragment newInstance() {
        ClasificarFragment frag = new ClasificarFragment();
        Bundle args = new Bundle();
        frag.setArguments(args);
        return frag;
    }


}
