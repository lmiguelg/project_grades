package com.example.lmigu.grades_register;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class NotasActivity extends AppCompatActivity {

    public ArrayList<Avaliacao>notas;
    ImageButton novaNota;
    Dialog myDialog;
    Button addNota;
    Button cancel;
    EditText nomeAvaliacao, score, balance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);


        novaNota = findViewById(R.id.Button_novaNota);
        novaNota.setOnClickListener(new View.OnClickListener(){

            public void onClick (View v){

               //abrir popup para introduzir nota
                adicionaNota();
            }
        });


    }
    public void adicionaNota(){
        myDialog = new Dialog(NotasActivity.this);
        myDialog.setContentView(R.layout.add_nota);
        myDialog.setTitle("Add grade");

        addNota = (Button)myDialog.findViewById(R.id.addNota);
        cancel = (Button) myDialog.findViewById(R.id.cancel);

        addNota.setEnabled(true);
        cancel.setEnabled(true);

        addNota.setOnClickListener(new View.OnClickListener(){

            public void onClick (View v){
                //abrir popup para introduzir nota
                Toast.makeText(getApplicationContext(),"nota adicionada",Toast.LENGTH_LONG).show();
                myDialog.cancel();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener(){

            public void onClick (View v){

                //abrir popup para introduzir nota
                myDialog.cancel();


            }
        });

        myDialog.show();
    }
    public void guardaNota(Dialog myDialog){
        nomeAvaliacao = findViewById(R.id.nomeAvaliacao);
        score = findViewById(R.id.score);
        balance = findViewById(R.id.balance);

    }
}
