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

public class EncontrarLetraActivity extends AppCompatActivity implements View.OnClickListener {

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
    private AlertDialog.Builder dialog;
    int cont = 0;

    AtividadeTipo1 atividadeAtual;
    ArrayList<AtividadeTipo1> atividades;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        botaoImagemPrincipal.setOnClickListener(this);
        botaoOpcao1.setOnClickListener(this);
        botaoOpcao2.setOnClickListener(this);
        botaoOpcao3.setOnClickListener(this);
        botaoConfirmar.setOnClickListener(this);


        //lista das atividades
        atividades = new ArrayList<>();

        //atividade 1
        AtividadeTipo1 atv = new AtividadeTipo1();
        atv.texto1 = "Olhe e escute a letra abaixo";
        atv.texto2 = "Qual das opcões é igual a letra acima?";
        atv.imgPrincipal = R.drawable.letra_b_principal;
        atv.somPrincipal = R.raw.letra_b;
        atv.imgOpcao1 = R.drawable.letra_d;
        atv.imgOpcao2 = R.drawable.letra_a;
        atv.imgOpcao3 = R.drawable.letra_b;
        atv.imgOpcao1Erro = R.drawable.letra_d_erro;
        atv.imgOpcao2Erro = R.drawable.letra_a_erro;
        atv.imgOpcao3Erro = R.drawable.letra_b_erro;
        atv.opcaoCorreta = R.drawable.letra_b;
        atv.somOpcao1 = R.raw.letra_d;
        atv.somOpcao2 = R.raw.letra_a;
        atv.somOpcao3 = R.raw.letra_b;

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
                mediaPlayer = MediaPlayer.create(EncontrarLetraActivity.this, atividadeAtual.somPrincipal);
                tocarSom();
                break;
            case R.id.botaoOpcao1:
                radioButton1.setChecked(true);
                mediaPlayer = MediaPlayer.create(EncontrarLetraActivity.this, atividadeAtual.somOpcao1);
                tocarSom();
                break;
            case R.id.botaoOpcao2:
                radioButton2.setChecked(true);
                mediaPlayer = MediaPlayer.create(EncontrarLetraActivity.this, atividadeAtual.somOpcao2);
                tocarSom();
                break;
            case R.id.botaoOpcao3:
                radioButton3.setChecked(true);
                mediaPlayer = MediaPlayer.create(EncontrarLetraActivity.this, atividadeAtual.somOpcao3);
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
                } else if (radioButton3.isChecked()) {
                    checar(atividadeAtual.imgOpcao3);

                } else {
                    Toast.makeText(EncontrarLetraActivity.this, "Escolha alguma opção.", Toast.LENGTH_SHORT).show();
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
    private void exibirAtividade(AtividadeTipo1 atv) {
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
            //criar alert dialog
            dialog = new AlertDialog.Builder(EncontrarLetraActivity.this);

            //configurar o titulo
            dialog.setTitle("Ops... ");

            //configurar a mensagem
            dialog.setMessage("Escolha outra opção!");

            dialog.create();
            dialog.show();

            if (Opcao == atividadeAtual.imgOpcao1) {
                //  imgOpcao1.setBackground(getResources().getDrawable(R.drawable.x_negar));
                botaoOpcao1.setBackground(getResources().getDrawable(atividadeAtual.imgOpcao1Erro));
            } else if (Opcao == atividadeAtual.imgOpcao2) {
                botaoOpcao2.setBackground(getResources().getDrawable(atividadeAtual.imgOpcao2Erro));
            } else if (Opcao == atividadeAtual.imgOpcao3) {
                botaoOpcao3.setBackground(getResources().getDrawable(atividadeAtual.imgOpcao3Erro));
            }
        } else {
            cont++;
            if (cont > 0) {
                mediaPlayer = MediaPlayer.create(EncontrarLetraActivity.this, R.raw.palmas);
                tocarSom();
                //criar alert dialog
                dialog = new AlertDialog.Builder(EncontrarLetraActivity.this);

                //configurar o titulo
                dialog.setTitle("Parabéns!");

                //configurar a mensagem
                dialog.setMessage("Você terminou todas as atividades desse módulo, escolha outro módulo no menu.");

                //configurar botao
                dialog.setNeutralButton("OK",
                        new DialogInterface.OnClickListener() {
                            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
//                                  //talvez exibir alguma animaçãp
                                startActivity(new Intent(EncontrarLetraActivity.this, MainActivity.class));

                            }
                        });

                dialog.create();
                dialog.show();
            } else {
                mediaPlayer = MediaPlayer.create(EncontrarLetraActivity.this, R.raw.palmas);
                tocarSom();
                //criar alert dialog
                dialog = new AlertDialog.Builder(EncontrarLetraActivity.this);

                //configurar o titulo
                dialog.setTitle("Muito bem!");

                //configurar a mensagem
                dialog.setMessage("Agora vá para a próxima atividade.");

                //configurar botao
                dialog.setNeutralButton("OK",
                        new DialogInterface.OnClickListener() {
                            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
//                                  //talvez exibir alguma animaçãp
                                exibirAtividade(atividades.get(cont)); //pegar numero aleatorio
                            }
                        });

                dialog.create();
                dialog.show();
                cont++;

            }
        }
    }


}