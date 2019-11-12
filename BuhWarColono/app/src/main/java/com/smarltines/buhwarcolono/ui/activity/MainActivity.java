package com.smarltines.buhwarcolono.ui.activity;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
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
//                fragmentManager.beginTransaction()
//                        .replace(R.id.fragment_content,sosFregment)
//                        .addToBackStack(null)
//                        .commit();
                checkpermissioncall();
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
                Intent i = new Intent(MainActivity.this,RondinMapActivity.class);
                startActivity(i);
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
                checkpermissionwriteread();
//                fragmentManager.beginTransaction()
//                        .replace(R.id.fragment_content,visitaFragment)
//                        .addToBackStack(null)
//                        .commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_calificar:
                setTitle("Calificar a mi guardia");
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

    ////PERMISOS Y ESAS MADRES
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {
        if (requestCode == 100) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permiso concedido ahora puedes acceder a tus archivos ", Toast.LENGTH_LONG).show();
                fragmentManager.beginTransaction().replace(R.id.fragment_content,visitaFragment).addToBackStack(null).commit();
            } else {
                Toast.makeText(this, "Oops permiso denegado", Toast.LENGTH_LONG).show();
                //finish();
            }
        }
        if (requestCode == 200) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permiso concedido ahora puedes hacer llamadas ", Toast.LENGTH_LONG).show();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_content,sosFregment)
                        .addToBackStack(null)
                        .commit();
            } else {
                Toast.makeText(this, "Oops permiso denegado", Toast.LENGTH_LONG).show();
                //finish();
            }
        }
    }


    private void checkpermissionwriteread() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Permisos concedidos ahora puedes leer/escribir tus archivos ", Toast.LENGTH_LONG).show();
            fragmentManager.beginTransaction().replace(R.id.fragment_content,visitaFragment).addToBackStack(null).commit();
        } else {
            solicitarPermiso(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    "Sin el permiso de leer/escribir archivos no puedes acceder a tus archivos", 100, this);
        }
    }

    private void checkpermissioncall() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Permisos concedidos ahora puedes hacer llamadas ", Toast.LENGTH_LONG).show();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_content,sosFregment)
                    .addToBackStack(null)
                    .commit();
        } else {
            solicitarPermiso(new String[]{Manifest.permission.CALL_PHONE},
                    "Sin el permiso de llamadas no puedes hacer llamadas de panico", 200, this);
        }
    }


    private void solicitarPermiso(final String[] permisos, final String justificacion,
                                  final int requestCode, final Activity actividad) {
//        if (ActivityCompat.shouldShowRequestPermissionRationale(actividad,
//                permisos[0]) && ActivityCompat.shouldShowRequestPermissionRationale(actividad,
//                permisos[1])) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(actividad,
                permisos[0])) {
            new AlertDialog.Builder(actividad)
                    .setTitle("Solicitud de permiso")
                    .setMessage(justificacion)
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            ActivityCompat.requestPermissions(actividad,
                                    permisos, requestCode);
                        }
                    })
                    .show();
        } else {
            ActivityCompat.requestPermissions(actividad, permisos,requestCode);
        }
    }
}
