package com.smarltines.buhwarcolono.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.smarltines.buhwarcolono.R;
import com.smarltines.buhwarcolono.ui.adapter.GuardiaAdapter;
import com.smarltines.buhwarcolono.ui.fragment.estadisticas.EstadisticasFragment;
import com.smarltines.buhwarcolono.ui.fragment.guardia.tabs.ActivosTabFragment;
import com.smarltines.buhwarcolono.ui.fragment.guardia.tabs.DatosTabFragment;
import com.smarltines.buhwarcolono.ui.fragment.guardia.tabs.EstaditicasTabFragment;
import com.smarltines.buhwarcolono.ui.fragment.guardia.tabs.inactivosTabFragment;

public class GuardiaActivity extends AppCompatActivity {
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guardia);
        viewPager = (ViewPager) findViewById(R.id.viewPagerGuardias);

        addTabs(viewPager);
        TabLayout tabLayout = findViewById(R.id.tabLayoutGuardias);
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FF0000"));
        tabLayout.setSelectedTabIndicatorHeight((int) (5 * getResources().getDisplayMetrics().density));
        tabLayout.setTabTextColors(Color.parseColor("#ED6A5A"), Color.parseColor("#ffffff"));
        tabLayout.setupWithViewPager(viewPager);
    }

    private void addTabs(ViewPager viewPager) {
        GuardiaAdapter adapter = new GuardiaAdapter(getSupportFragmentManager());
        adapter.addFrag(new DatosTabFragment(), "Datos");
        adapter.addFrag(new EstadisticasFragment(), "Estadisticas");

        viewPager.setAdapter(adapter);
    }
}
