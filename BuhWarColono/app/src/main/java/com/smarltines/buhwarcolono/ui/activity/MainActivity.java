package com.smarltines.buhwarcolono.ui.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationView;
import com.smarltines.buhwarcolono.R;
import com.smarltines.buhwarcolono.ui.fragment.clasificar.ClasificarFragment;
import com.smarltines.buhwarcolono.ui.fragment.estadisticas.EstadisticasFragment;
import com.smarltines.buhwarcolono.ui.fragment.guardia.GuardiaFragment;
import com.smarltines.buhwarcolono.ui.fragment.helper.InfoFragment;
import com.smarltines.buhwarcolono.ui.fragment.sos.SosFragment;
import com.smarltines.buhwarcolono.ui.fragment.visita.VisitaFragment;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        DrawerLayout.DrawerListener {

    private DrawerLayout drawerLayout;
    private Button btnPanico;
    private Fragment guadiasFragment;
    private Fragment infoFragment;
    private Fragment visitaFragment;
    private Fragment clasificarFragment;
    private Fragment estadisticasFregment;
    private Fragment sosFregment;
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        infoFragment = InfoFragment.newInstance();
        guadiasFragment = GuardiaFragment.newInstance();
        visitaFragment = VisitaFragment.newInstance();
        estadisticasFregment = EstadisticasFragment.newInstance();
        clasificarFragment = ClasificarFragment.newInstance();
        sosFregment = SosFragment.newInstance();
        fragmentManager = getSupportFragmentManager();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        MenuItem menuItem = navigationView.getMenu().getItem(0);
        onNavigationItemSelected(menuItem);
        menuItem.setChecked(true);
        drawerLayout.addDrawerListener(this);
        View header = navigationView.getHeaderView(0);
        header.findViewById(R.id.header_title).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, getString(R.string.title_click),
                        Toast.LENGTH_SHORT).show();
            }
        });
        btnPanico = (Button) findViewById(R.id.btnPanico);
        btnPanico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                setTitle("ASP Solutions");
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_content,sosFregment)
                        .addToBackStack(null)
                        .commit();
                drawerLayout.closeDrawer(GravityCompat.START);

            }
        });



    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_info:
                setTitle("ASP Solutions");
                fragmentManager.beginTransaction()
                    .replace(R.id.fragment_content,infoFragment)
                    .addToBackStack(null)
                    .commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.nav_rondin:
                setTitle("Rondin");
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
          case R.id.nav_guardias:
                setTitle("Guardias");
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_content,guadiasFragment)
                        .addToBackStack(null)
                        .commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_visitas:
                setTitle("Programar vista");
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_content,visitaFragment)
                        .addToBackStack(null)
                        .commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_calificar:
                setTitle("Clasificar a mi guardia");
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_content,clasificarFragment)
                        .addToBackStack(null)
                        .commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_estdisticaas:
                setTitle("Mis estadisticas");
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_content,estadisticasFregment)
                        .addToBackStack(null)
                        .commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;


        }

        return true;
    }

    @Override
    public void onDrawerSlide(@NonNull View view, float v) {
        //cambio en la posición del drawer
    }

    @Override
    public void onDrawerOpened(@NonNull View view) {
        //el drawer se ha abierto completamente
        Toast.makeText(this, getString(R.string.navigation_drawer_open),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDrawerClosed(@NonNull View view) {
        //el drawer se ha cerrado completamente
    }

    @Override
    public void onDrawerStateChanged(int i) {
        //cambio de estado, puede ser STATE_IDLE, STATE_DRAGGING or STATE_SETTLING
    }

}
