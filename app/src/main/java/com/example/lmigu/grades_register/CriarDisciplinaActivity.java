package com.example.lmigu.grades_register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CriarDisciplinaActivity extends AppCompatActivity {
    EditText    nome;
    EditText    semestre;
    String      novoNome ="";
    int         novoSemestre;
    Button ButtonCriarDisciplina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_disciplina);

        nome            = findViewById(R.id.className);
        semestre        = findViewById(R.id.semestre);


        ButtonCriarDisciplina = findViewById(R.id.buttonAdicionarDisciplina);
        ButtonCriarDisciplina.setOnClickListener(new View.OnClickListener(){
        public void onClick (View v) {
            novoNome        = nome.getText().toString();
            novoSemestre    = Integer.parseInt(semestre.getText().toString());
            Disciplina novaDisciplina = new Disciplina(novoNome,novoSemestre);


            Intent intent = new Intent(CriarDisciplinaActivity.this, MenuActivity.class);
            intent.putExtra("novaDisciplina",novaDisciplina);
            startActivity(intent);
        }
        });
    }

}
