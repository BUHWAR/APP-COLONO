package com.smarltines.buhwarcolono.ui.fragment.estadisticas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.smarltines.buhwarcolono.R;

import java.util.ArrayList;


public class EstadisticasFragment extends Fragment {

    BarChart pieChart;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.fragment_estadisticas, container, false);
        pieChart = (BarChart) inflatedView.findViewById(R.id.grafico_pastel);
        fillGraphic();
        return inflatedView;
    }

    private void fillGraphic() {
        Description description = new Description();
        description.setText("Progreso mensual");
        description.setTextSize(28
        );

        pieChart.setDescription(description);

        ArrayList<BarEntry> pieEntrys = new ArrayList<BarEntry>();
        pieEntrys.add(new BarEntry(1,2,"Octubre"));
        pieEntrys.add(new BarEntry(2,3));
        pieEntrys.add(new BarEntry(3,4));
        pieEntrys.add(new BarEntry(4,5));
        BarDataSet pieDataSet =new BarDataSet(pieEntrys,"Meses");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        BarData pieData =new BarData(pieDataSet);

        pieChart.setData(pieData);
    }


    public static EstadisticasFragment newInstance() {
        EstadisticasFragment frag = new EstadisticasFragment();
        Bundle args = new Bundle();
        frag.setArguments(args);
        return frag;
    }


}
