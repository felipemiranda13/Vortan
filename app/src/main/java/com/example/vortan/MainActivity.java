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
    private Button botaoFormarSilabaPalavra;
    private Button botaoEncontrarRima;
    private Button botaoEncontrarPalavra;
    private Button botaoEncontrarSilaba;
    private Button botaoEncontrarPar;
    private Button botaoEncontrarPalavraEscondida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoEncontrarLetra = (Button) findViewById(R.id.botaoEncontrarLetra);
        botaoFormarSilaba = (Button) findViewById(R.id.botaoFormarSilaba);
        botaoEncontrarPalavraRima = (Button) findViewById(R.id.botaoEncontrarPalavraRima);
        botaoFormarSilabaPalavra = (Button) findViewById(R.id.botaoFormarSilabaPalavra);
        botaoEncontrarRima = (Button) findViewById(R.id.botaoEncontrarRima);
        botaoEncontrarPalavra = (Button) findViewById(R.id.botaoEncontrarPalavra);
        botaoEncontrarSilaba = (Button) findViewById(R.id.botaoEncontrarSilaba);
        botaoEncontrarPar = (Button) findViewById(R.id.botaoEncontrarPar);
        botaoEncontrarPalavraEscondida = (Button) findViewById(R.id.botaoEncontrarPalavraEscondida);

        botaoEncontrarLetra.setOnClickListener(this);
        botaoFormarSilaba.setOnClickListener(this);
        botaoEncontrarPalavraRima.setOnClickListener(this);
        botaoFormarSilabaPalavra.setOnClickListener(this);
        botaoEncontrarRima.setOnClickListener(this);
        botaoEncontrarPalavra.setOnClickListener(this);
        botaoEncontrarSilaba.setOnClickListener(this);
        botaoEncontrarPar.setOnClickListener(this);
        botaoEncontrarPalavraEscondida.setOnClickListener(this);
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
            case R.id.botaoFormarSilabaPalavra:
                startActivity(new Intent(MainActivity.this, FormarSilabaPalavraActivity.class));
                break;
            case R.id.botaoEncontrarRima:
                startActivity(new Intent(MainActivity.this, EncontrarRimaActivity.class));
                break;
            case R.id.botaoEncontrarPalavra:
                startActivity(new Intent(MainActivity.this, EncontrarPalavraActivity.class));
                break;
            case R.id.botaoEncontrarSilaba:
                startActivity(new Intent(MainActivity.this, EncontrarSilabaActivity.class));
                break;
            case R.id.botaoEncontrarPar:
                startActivity(new Intent(MainActivity.this, EncontrarParActivity.class));
                break;
            case R.id.botaoEncontrarPalavraEscondida:
                startActivity(new Intent(MainActivity.this, EncontrarPalavraEscondidaActivity.class));
                break;
        }
    }
}

