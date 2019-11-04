package com.smarltines.buhwarcolono.ui.fragment.guardia;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.smarltines.buhwarcolono.R;
import com.smarltines.buhwarcolono.ui.adapter.GuardiaAdapter;
import com.smarltines.buhwarcolono.ui.fragment.guardia.tabs.ActivosTabFragment;
import com.smarltines.buhwarcolono.ui.fragment.guardia.tabs.inactivosTabFragment;

public class GuardiaFragment extends Fragment {

    ViewPager viewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = (View) inflater.inflate(R.layout.fragment_guardia, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.viewPagerGuardias);

        addTabs(viewPager);
        TabLayout tabLayout = view.findViewById(R.id.tabLayoutGuardias);
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FF0000"));
        tabLayout.setSelectedTabIndicatorHeight((int) (5 * getResources().getDisplayMetrics().density));
        tabLayout.setTabTextColors(Color.parseColor("#ED6A5A"), Color.parseColor("#ffffff"));
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

    private void addTabs(ViewPager viewPager) {
        GuardiaAdapter adapter = new GuardiaAdapter(getFragmentManager());
        adapter.addFrag(new ActivosTabFragment(), "Activos");
        adapter.addFrag(new inactivosTabFragment(), "Inactivos");

        viewPager.setAdapter(adapter);
    }

    public static GuardiaFragment newInstance() {
        GuardiaFragment frag = new GuardiaFragment();
        Bundle args = new Bundle();
        frag.setArguments(args);
        return frag;
    }
}