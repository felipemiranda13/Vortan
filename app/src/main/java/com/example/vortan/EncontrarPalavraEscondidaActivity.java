package com.example.vortan;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class EncontrarPalavraEscondidaActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView texto1;
    private TextView texto2;
    private Button botaoImagemPrincipal;
    private RadioGroup radioGroup;
    private MediaPlayer mediaPlayer;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private Button botaoOpcao1;
    private Button botaoOpcao2;
    private Button botaoOpcao3;
    private Button botaoConfirmar;
    private Button botaoProximo;
    private Button botaoVoltar;
    private AlertDialog.Builder dialog;
    int cont = 0;
    boolean op;

    AtividadeTipo1 atividadeAtual;
    ArrayList<AtividadeTipo1> atividades;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_tipo_1);

        texto1 = findViewById(R.id.texto1);
        texto2 = findViewById(R.id.texto2);
        botaoImagemPrincipal = (Button) findViewById(R.id.botaoImagemPrincipal1);
        botaoOpcao1 = (Button) findViewById(R.id.botaoOpcao1);
        botaoOpcao2 = (Button) findViewById(R.id.botaoOpcao2);
        botaoOpcao3 = (Button) findViewById(R.id.botaoOpcao3);
        radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        botaoConfirmar = (Button) findViewById(R.id.botaoConfirmar);
        botaoProximo = (Button) findViewById(R.id.botaoProximo);
        botaoVoltar = (Button) findViewById(R.id.botaoVoltar);

        botaoImagemPrincipal.setOnClickListener(this);
        botaoOpcao1.setOnClickListener(this);
        botaoOpcao2.setOnClickListener(this);
        botaoOpcao3.setOnClickListener(this);
        botaoConfirmar.setOnClickListener(this);
        botaoProximo.setOnClickListener(this);
        botaoVoltar.setOnClickListener(this);

        //lista das atividades
        atividades = new ArrayList<>();

        //botaoProximo.setBackground(getResources().getDrawable(R.drawable.botao_proximo));

        //lista das atividades
        atividades = new ArrayList<>();

        //atividade 1
        AtividadeTipo1 atv = new AtividadeTipo1();
        atv.texto1 = "LEIA ESSA PALAVRA ABAIXO:";
        atv.texto2 = "QUAL DAS OPÇÕES CONTÉM A PALAVRA ACIMA?";
        atv.imgPrincipal = R.drawable.palavra_bola_principal_n;
        atv.somPrincipal = R.raw.palavra_bola;
        atv.imgOpcao1 = R.drawable.palavra_escondida_ogfder;
        atv.imgOpcao2 = R.drawable.palavra_escondida_abolah;
        atv.imgOpcao3 = R.drawable.palavra_escondida_adoiah;
        atv.imgOpcao1Erro = R.drawable.palavra_escondida_ogfder_erro;
        atv.imgOpcao2Erro = R.drawable.palavra_escondida_abolah_erro;
        atv.imgOpcao3Erro = R.drawable.palavra_escondida_adoiah_erro;
        atv.opcaoCorreta = R.drawable.palavra_escondida_abolah;
        atv.opcaoCerto = R.drawable.palavra_escondida_abolah_certo;
        //atv.somOpcao1 = R.raw.letra_a;
        //atv.somOpcao2 = R.raw.letra_a;
        //atv.somOpcao3 = R.raw.letra_a;

        atividades.add(atv);

        //atividade 2
        atv = new AtividadeTipo1();
        atv.texto1 = "LEIA ESSA PALAVRA ABAIXO:";
        atv.texto2 = "QUAL DAS OPÇÕES CONTÉM A PALAVRA ACIMA?";
        atv.imgPrincipal = R.drawable.palavra_casa_principal_n;
        atv.somPrincipal = R.raw.palavra_casa;
        atv.imgOpcao1 = R.drawable.palavra_escondida_bcasay;
        atv.imgOpcao2 = R.drawable.palavra_escondida_dbapoi;
        atv.imgOpcao3 = R.drawable.palavra_escondida_bcazay;
        atv.imgOpcao1Erro = R.drawable.palavra_escondida_bcasay_erro;
        atv.imgOpcao2Erro = R.drawable.palavra_escondida_dbapoi_erro;
        atv.imgOpcao3Erro = R.drawable.palavra_escondida_bcazay_erro;
        atv.opcaoCorreta = R.drawable.palavra_escondida_bcasay;
        atv.opcaoCerto = R.drawable.palavra_escondida_bcasay_certo;
        //atv.somOpcao1 = R.raw.letra_a;
        //atv.somOpcao2 = R.raw.letra_a;
        //atv.somOpcao3 = R.raw.letra_a;

        atividades.add(atv);

        //exibir atividade 1
        exibirAtividade(atividades.get(0)); //posteriormente usar get random

    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.botaoImagemPrincipal1:
                mediaPlayer = MediaPlayer.create(EncontrarPalavraEscondidaActivity.this, atividadeAtual.somPrincipal);
                tocarSom();
                break;
            case R.id.botaoOpcao1:
                radioButton1.setChecked(true);
               // mediaPlayer = MediaPlayer.create(EncontrarPalavraEscondidaActivity.this, atividadeAtual.somOpcao1);
                //tocarSom();
                break;
            case R.id.botaoOpcao2:
                radioButton2.setChecked(true);
                //mediaPlayer = MediaPlayer.create(EncontrarPalavraEscondidaActivity.this, atividadeAtual.somOpcao2);
                //tocarSom();
                break;
            case R.id.botaoOpcao3:
                radioButton3.setChecked(true);
                //mediaPlayer = MediaPlayer.create(EncontrarPalavraEscondidaActivity.this, atividadeAtual.somOpcao3);
                //tocarSom();
                break;
            case R.id.botaoConfirmar:
                if (radioButton1.isChecked()) {
                    checar(atividadeAtual.imgOpcao1);
//
//                    dialog.show();
                } else if (radioButton2.isChecked()) {
                    checar(atividadeAtual.imgOpcao2);
//
                } else if (radioButton3.isChecked()) {
                    checar(atividadeAtual.imgOpcao3);

                } else {
                    Toast.makeText(EncontrarPalavraEscondidaActivity.this, "Escolha alguma opção.", Toast.LENGTH_SHORT).show();
                } if (op == true){
                botaoProximo.setBackground(getResources().getDrawable(R.drawable.botao_proximo_verde));
                //exibirAtividade(atividades.get(1));
            }
                break;
            case R.id.botaoProximo:
                if (op == true){
                    cont++;
                    if (cont>1){
                        startActivity(new Intent(EncontrarPalavraEscondidaActivity.this, TelaFimActivity.class));
                    }else{
                        exibirAtividade(atividades.get(cont));
                        botaoProximo.setBackground(getResources().getDrawable(R.drawable.botao_proximo));
                    }


                }
                break;

            case R.id.botaoVoltar:
                startActivity(new Intent(EncontrarPalavraEscondidaActivity.this, MainActivity.class));
                break;
        }
    }

    public void tocarSom(){
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
            }
        });
        mediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void exibirAtividade(AtividadeTipo1 atv){
        atividadeAtual = atv;
        texto1.setText(atividadeAtual.texto1);
        texto2.setText(atividadeAtual.texto2);
        botaoImagemPrincipal.setBackground(getDrawable(atividadeAtual.imgPrincipal));
        botaoOpcao1.setBackground(getDrawable(atividadeAtual.imgOpcao1));
        botaoOpcao2.setBackground(getDrawable(atividadeAtual.imgOpcao2));
        botaoOpcao3.setBackground(getDrawable(atividadeAtual.imgOpcao3));
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void checar(int Opcao) {

        if (Opcao != atividadeAtual.opcaoCorreta) { //acertou
            op = false;

            mediaPlayer = MediaPlayer.create(EncontrarPalavraEscondidaActivity.this, R.raw.efeito_errar);
            tocarSom();

            if (Opcao == atividadeAtual.imgOpcao1) {
                botaoOpcao1.setBackground(getResources().getDrawable(atividadeAtual.imgOpcao1Erro));
            } else if (Opcao == atividadeAtual.imgOpcao2) {
                botaoOpcao2.setBackground(getResources().getDrawable(atividadeAtual.imgOpcao2Erro));
            } else if (Opcao == atividadeAtual.imgOpcao3) {
                botaoOpcao3.setBackground(getResources().getDrawable(atividadeAtual.imgOpcao3Erro));
            }

        } else {
            op=true;
            mediaPlayer = MediaPlayer.create(EncontrarPalavraEscondidaActivity.this, R.raw.efeito_acertar);
            tocarSom();
            if (Opcao == atividadeAtual.imgOpcao1) {
                botaoOpcao1.setBackground(getResources().getDrawable(atividadeAtual.opcaoCerto));
            } else if (Opcao == atividadeAtual.imgOpcao2) {
                botaoOpcao2.setBackground(getResources().getDrawable(atividadeAtual.opcaoCerto));
            } else if (Opcao == atividadeAtual.imgOpcao3) {
                botaoOpcao3.setBackground(getResources().getDrawable(atividadeAtual.opcaoCerto));
            }

        }

    }
}