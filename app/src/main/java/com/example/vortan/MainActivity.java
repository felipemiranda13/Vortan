package com.example.vortan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button botaoEncontrarLetra;
    private Button botaoFormarSilaba;
    private Button botaoEncontrarPalavraRima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoEncontrarLetra = (Button) findViewById(R.id.botaoEncontrarLetra);
        botaoFormarSilaba = (Button) findViewById(R.id.botaoFormarSilaba);
        botaoEncontrarPalavraRima = (Button) findViewById(R.id.botaoEncontrarPalavraRima);

        botaoEncontrarLetra.setOnClickListener(this);
        botaoFormarSilaba.setOnClickListener(this);
        botaoEncontrarPalavraRima.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.botaoEncontrarLetra:
                startActivity(new Intent(MainActivity.this, EncontrarLetraActivity.class));
                break;

            case R.id.botaoFormarSilaba:
                startActivity(new Intent(MainActivity.this, FormarSilabaActivity.class));
                break;

            case R.id.botaoEncontrarPalavraRima:
                startActivity(new Intent(MainActivity.this, EncontrarPalavraRimaActivity.class));
                break;
        }
    }
}
