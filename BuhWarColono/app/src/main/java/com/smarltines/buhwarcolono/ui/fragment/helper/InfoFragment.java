package com.smarltines.buhwarcolono.ui.fragment.helper;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.smarltines.buhwarcolono.R;

import static com.smarltines.buhwarcolono.utils.Constanst.INFO;
import static com.smarltines.buhwarcolono.utils.Constanst.MISION;
import static com.smarltines.buhwarcolono.utils.Constanst.PERSONA;
import static com.smarltines.buhwarcolono.utils.Constanst.VISION;

public class InfoFragment extends Fragment {

    private Button btnInfo;
    private Button btnMision;
    private Button btnVision;
    private Button btnPersonal;
    private TextView txtInfo;
    private TextView txtMision;
    private TextView txtVision;
    private TextView txtPersonal;
    private boolean flagInfo = false;
    private boolean flagMision = false;
    private boolean flagVision = false;
    private boolean flagPersonal = false;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.fragment_info, container, false);
        btnInfo = (Button) view.findViewById(R.id.btnInfo);
        btnMision = (Button) view.findViewById(R.id.btnMision);
        btnVision = (Button) view.findViewById(R.id.btnVsion);
        btnPersonal = (Button) view.findViewById(R.id.btnPersonal);

        txtInfo = (TextView) view.findViewById(R.id.txtInfo);


        txtMision = (TextView) view.findViewById(R.id.txtMision);
        txtVision = (TextView) view.findViewById(R.id.txtVision);
        txtPersonal = (TextView) view.findViewById(R.id.txtPerosnal);


        btnInfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!flagInfo){
                    txtInfo.setText(INFO);
                    flagInfo = true;
                }else {
                    txtInfo.setText("");
                    flagInfo = false;
                }
            }
        }); btnMision.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!flagMision){
                    txtMision.setText(MISION);
                    flagMision = true;
                }else {
                    txtMision.setText("");
                    flagMision = false;


                }
            }
        }); btnVision.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!flagVision){
                    txtVision.setText(VISION);

                    flagVision = true;
                }else {
                    txtVision.setText("");
                    flagVision = false;


                }
            }
        }); btnPersonal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!flagPersonal){
                    txtPersonal.setText(PERSONA);
                    flagPersonal = true;
                }else {
                    txtPersonal.setText("");
                    flagPersonal = false;


                }
            }
        });

        return view;
    }

    public static InfoFragment newInstance() {
        InfoFragment frag = new InfoFragment();
        Bundle args = new Bundle();
        frag.setArguments(args);
        return frag;
    }


}
