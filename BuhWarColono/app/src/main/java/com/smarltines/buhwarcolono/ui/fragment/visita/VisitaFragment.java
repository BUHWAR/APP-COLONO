package com.smarltines.buhwarcolono.ui.fragment.visita;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.smarltines.buhwarcolono.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class VisitaFragment extends Fragment {
    private TextView txtDateVisita;
    private Spinner spinnerVisita;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.fragment_visita, container, false);
        spinnerVisita = view.findViewById(R.id.spinnerVisita);
        txtDateVisita = view.findViewById(R.id.txtDateVisita);


        Calendar calender = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String strDate = "Fecha : "+dateFormat.format(calender.getTime());

        String[] opcVisita = {"Familiar","Eventos","Personal"};

        ArrayAdapter adapterVisita = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, opcVisita);
        spinnerVisita.setAdapter(adapterVisita);
        txtDateVisita.setText(strDate);

        return view;
    }

    public static VisitaFragment newInstance() {
        VisitaFragment frag = new VisitaFragment();
        Bundle args = new Bundle();
        frag.setArguments(args);
        return frag;
    }


}
