package com.example.vortan;

import android.annotation.TargetApi;
import android.content.DialogInterface;
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

        botaoImagemPrincipal1.setOnClickListener(this);
        botaoImagemPrincipal2.setOnClickListener(this);
        botaoOpcao1.setOnClickListener(this);
        botaoOpcao2.setOnClickListener(this);
        botaoConfirmar.setOnClickListener(this);


        //lista das atividades
        atividades = new ArrayList<>();

        //atividade 1
        AtividadeTipo2 atv = new AtividadeTipo2();
        atv.texto1 = "Olhe essas duas letras abaixo e escute seu som";
        atv.texto2 = "Se juntarmos as duas letras a cima se formara uma silaba, qual o som dessa silaba?";
        atv.imgPrincipal1 = R.drawable.letra_b;
        atv.imgPrincipal2 = R.drawable.letra_o;
        atv.somPrincipal1 = R.raw.letra_b;
        atv.somPrincipal2 = R.raw.letra_o;
        atv.imgOpcao1 = R.drawable.som_1;
        atv.imgOpcao2 = R.drawable.som_2;
        atv.opcaoCorreta = R.drawable.som_1;
        atv.somOpcao1 = R.raw.silaba_bo;
        atv.somOpcao2 = R.raw.silaba_po;

        atividades.add(atv);

        /*atividade 2
        atv = new Atividade();
        atv.texto = "Segunda questão: bla bla...";
        atv.imgPrincipal = R.drawable.abcd;
        atv.somPrincipal = R.raw.som_abcd;
        atv.imgOpcao1 = R.drawable.bola_modelo2;
        atv.imgOpcao2 = R.drawable.bola;
        atv.imgOpcao3 = R.drawable.bola_rima;
        atv.opcaoCorreta = R.drawable.bola_rima;
        atv.somOpcao1 = R.raw.som_bo;
        atv.somOpcao2 = R.raw.som_bola;
        atv.somOpcao3 = R.raw.som_abcd;

        atividades.add(atv);*/

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
                }

                else {
                    Toast.makeText(FormarSilabaActivity.this, "Escolha alguma opção.", Toast.LENGTH_SHORT).show();
                }
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
            //criar alert dialog
            dialog = new AlertDialog.Builder(FormarSilabaActivity.this);

            //configurar o titulo
            dialog.setTitle("Ops... ");

            //configurar a mensagem
            dialog.setMessage("Escolha outra opção!");

            dialog.create();
            dialog.show();

            if (Opcao == atividadeAtual.imgOpcao1){
              //  imgOpcao1.setBackground(getResources().getDrawable(R.drawable.x_negar));
                botaoOpcao1.setBackground(getResources().getDrawable(R.drawable.som_1_erro));
            }else if(Opcao == atividadeAtual.imgOpcao2){
                botaoOpcao2.setBackground(getResources().getDrawable(R.drawable.som_2_erro));
            }
        } else {
            mediaPlayer = MediaPlayer.create(FormarSilabaActivity.this, R.raw.palmas);
            tocarSom();
            //criar alert dialog
            dialog = new AlertDialog.Builder(FormarSilabaActivity.this);

            //configurar o titulo
            dialog.setTitle("Parabéns!");

            //configurar a mensagem
            dialog.setMessage("Muito bem! agora vá para a próxima atividade.");

            //configurar botao
            dialog.setNeutralButton("OK",
                    new DialogInterface.OnClickListener() {
                        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
//                                  //talvez exibir alguma animaçãp
                            exibirAtividade(atividades.get(1)); //pegar numero aleatorio
                        }
                    });

            dialog.create();
            dialog.show();
        }
    }




    }

