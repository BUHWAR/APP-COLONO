package com.smarltines.buhwarcolono.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.smarltines.buhwarcolono.R;

public class DeatailGuardiaActivity extends AppCompatActivity {
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deatail_guardia);
        btn = (Button) findViewById(R.id.btnCalifica);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(DeatailGuardiaActivity.this, MainActivity.class);
                startActivity(intent);
            }

        });
    }

}
