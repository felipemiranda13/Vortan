package com.example.vortan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaFimActivity extends AppCompatActivity {

    private Button botaoVoltarMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_fim);

        botaoVoltarMenu = (Button) findViewById(R.id.botaoVoltarMenu);

        botaoVoltarMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaFimActivity.this, MainActivity.class));
            }
        });

    }
}
