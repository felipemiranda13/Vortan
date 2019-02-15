package com.example.vortan;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
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

public class FormarSilabaActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView texto1;
    private TextView texto2;
    private Button botaoImagemPrincipal1;
    private Button botaoImagemPrincipal2;
    private RadioGroup radioGroup;
    private MediaPlayer mediaPlayer;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private Button botaoOpcao1;
    private Button botaoOpcao2;
    private Button botaoConfirmar;
    private AlertDialog.Builder dialog;
    int cont=0;
    boolean op;
    private Button botaoProximo;
    private Button botaoVoltar;

    AtividadeTipo2 atividadeAtual;
    ArrayList<AtividadeTipo2> atividades;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_2);

        texto1 = findViewById(R.id.texto1);
        texto2 = findViewById(R.id.texto2);
        botaoImagemPrincipal1 = (Button) findViewById(R.id.botaoImagemPrincipal1);
        botaoImagemPrincipal2 = (Button) findViewById(R.id.botaoImagemPrincipal2);
        botaoOpcao1 = (Button) findViewById(R.id.botaoOpcao1);
        botaoOpcao2 = (Button) findViewById(R.id.botaoOpcao2);
        radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        botaoConfirmar = (Button) findViewById(R.id.botaoConfirmar);
        botaoProximo = (Button) findViewById(R.id.botaoProximo);
        botaoVoltar = (Button) findViewById(R.id.botaoVoltar);

        botaoImagemPrincipal1.setOnClickListener(this);
        botaoImagemPrincipal2.setOnClickListener(this);
        botaoOpcao1.setOnClickListener(this);
        botaoOpcao2.setOnClickListener(this);
        botaoConfirmar.setOnClickListener(this);
        botaoProximo.setOnClickListener(this);
        botaoVoltar.setOnClickListener(this);


        //lista das atividades
        atividades = new ArrayList<>();

        //atividade 1
        AtividadeTipo2 atv = new AtividadeTipo2();
        atv.texto1 = "OLHE ESSAS DUAS LETRAS ABAIXO E ESCUTE SEU SOM:";
        atv.texto2 = "SE JUNTARMOS AS DUAS LETRAS ACIMA SE FORMARÁ UMA SÍLABA, QUAL O SOM DESSA SÍLABA?";
        atv.imgPrincipal1 = R.drawable.letra_b;
        atv.imgPrincipal2 = R.drawable.letra_o;
        atv.somPrincipal1 = R.raw.letra_b;
        atv.somPrincipal2 = R.raw.letra_o;
        atv.imgOpcao1 = R.drawable.som_1;
        atv.imgOpcao1Erro = R.drawable.som_1_erro;
        atv.imgOpcao2 = R.drawable.som_2;
        atv.imgOpcao2Erro = R.drawable.som_2_erro;
        atv.opcaoCorreta = R.drawable.som_1;
        atv.opcaoCerto = R.drawable.som_1_certo;
        atv.somOpcao1 = R.raw.silaba_bo;
        atv.somOpcao2 = R.raw.silaba_po;


        atividades.add(atv);

        //atividade 2
        atv = new AtividadeTipo2();
        atv.texto1 = "OLHE ESSAS DUAS LETRAS ABAIXO E ESCUTE SEU SOM:";
        atv.texto2 = "SE JUNTARMOS AS DUAS LETRAS ACIMA SE FORMARÁ UMA SÍLABA, QUAL O SOM DESSA SÍLABA?";
        atv.imgPrincipal1 = R.drawable.letra_m;
        atv.imgPrincipal2 = R.drawable.letra_a;
        atv.somPrincipal1 = R.raw.letra_m;
        atv.somPrincipal2 = R.raw.letra_a;
        atv.imgOpcao1 = R.drawable.som_1;
        atv.imgOpcao1Erro = R.drawable.som_1_erro;
        atv.imgOpcao2 = R.drawable.som_2;
        atv.imgOpcao2Erro = R.drawable.som_2_erro;
        atv.opcaoCorreta = R.drawable.som_2;
        atv.opcaoCerto = R.drawable.som_2_certo;
        atv.somOpcao1 = R.raw.silaba_ma;
        atv.somOpcao2 = R.raw.silaba_na;
        atividades.add(atv);

        //exibir atividade 1
        exibirAtividade(atividades.get(0)); //posteriormente usar get random

    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.botaoImagemPrincipal1:
                mediaPlayer = MediaPlayer.create(FormarSilabaActivity.this, atividadeAtual.somPrincipal1);
                tocarSom();
                break;
            case R.id.botaoImagemPrincipal2:
                mediaPlayer = MediaPlayer.create(FormarSilabaActivity.this, atividadeAtual.somPrincipal2);
                tocarSom();
                break;
            case R.id.botaoOpcao1:
                radioButton1.setChecked(true);
                mediaPlayer = MediaPlayer.create(FormarSilabaActivity.this, atividadeAtual.somOpcao1);
                tocarSom();
                break;
            case R.id.botaoOpcao2:
                radioButton2.setChecked(true);
                mediaPlayer = MediaPlayer.create(FormarSilabaActivity.this, atividadeAtual.somOpcao2);
                tocarSom();
                break;
            case R.id.botaoConfirmar:
                if (radioButton1.isChecked()) {
                    checar(atividadeAtual.imgOpcao1);
//
//                    dialog.show();
                } else if (radioButton2.isChecked()) {
                    checar(atividadeAtual.imgOpcao2);
//
                }  else {
                    Toast.makeText(FormarSilabaActivity.this, "Escolha alguma opção.", Toast.LENGTH_SHORT).show();
                } if (op == true){
                botaoProximo.setBackground(getResources().getDrawable(R.drawable.botao_proximo_verde));
                //exibirAtividade(atividades.get(1));
            }
                break;
            case R.id.botaoProximo:
                if (op == true){
                    cont++;
                    if (cont>1){
                        startActivity(new Intent(FormarSilabaActivity.this, TelaFimActivity.class));
                    }else{
                        exibirAtividade(atividades.get(cont));
                        botaoProximo.setBackground(getResources().getDrawable(R.drawable.botao_proximo));
                    }


                }
                break;

            case R.id.botaoVoltar:
                startActivity(new Intent(FormarSilabaActivity.this, MainActivity.class));
                break;
        }
    }

    public void tocarSom() {
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
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void exibirAtividade(AtividadeTipo2 atv) {
        atividadeAtual = atv;
        texto1.setText(atividadeAtual.texto1);
        texto2.setText(atividadeAtual.texto2);
        botaoImagemPrincipal1.setBackground(getDrawable(atividadeAtual.imgPrincipal1));
        botaoImagemPrincipal2.setBackground(getDrawable(atividadeAtual.imgPrincipal2));
        botaoOpcao1.setBackground(getDrawable(atividadeAtual.imgOpcao1));
        botaoOpcao2.setBackground(getDrawable(atividadeAtual.imgOpcao2));

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void checar(int Opcao) {

        if (Opcao != atividadeAtual.opcaoCorreta) { //acertou
            op = false;

            mediaPlayer = MediaPlayer.create(FormarSilabaActivity.this, R.raw.efeito_errar);
            tocarSom();

            if (Opcao == atividadeAtual.imgOpcao1) {
                botaoOpcao1.setBackground(getResources().getDrawable(atividadeAtual.imgOpcao1Erro));
            } else if (Opcao == atividadeAtual.imgOpcao2) {
                botaoOpcao2.setBackground(getResources().getDrawable(atividadeAtual.imgOpcao2Erro));
            }

        } else {
            op=true;
            mediaPlayer = MediaPlayer.create(FormarSilabaActivity.this, R.raw.efeito_acertar);
            tocarSom();
            if (Opcao == atividadeAtual.imgOpcao1) {
                botaoOpcao1.setBackground(getResources().getDrawable(atividadeAtual.opcaoCerto));
            } else if (Opcao == atividadeAtual.imgOpcao2) {
                botaoOpcao2.setBackground(getResources().getDrawable(atividadeAtual.opcaoCerto));
            }
        }
    }
}