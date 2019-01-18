package com.example.vortan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button botaoEncontrarLetra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoEncontrarLetra = (Button) findViewById(R.id.botaoEncontrarLetra);

        botaoEncontrarLetra.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
        case R.id.botaoEncontrarLetra:
        startActivity(new Intent(MainActivity.this, EncontrarLetraActivity.class));
        break;
        }
    }
}
