package com.example.lmigu.grades_register;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class MenuActivity extends AppCompatActivity {
    Button criarDisciplina;
    String nomeDisciplina;
    public ArrayList<Disciplina> disciplinas;
    public ArrayList <Button> buttons = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //carrega os dados do array
        loadData();

        //teste nova disciplina
        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        //verifica se o bundle não está vazio
        if(b != null){
            Disciplina novaDisciplina = (Disciplina) intent.getExtras().getSerializable("novaDisciplina");
            disciplinas.add(novaDisciplina);
            saveData();
            //Toast.makeText(getApplicationContext(),"nome da disciplina="+novaDisciplina.getNome(),Toast.LENGTH_LONG).show();
            //Toast.makeText(getApplicationContext(),"semestre="+novaDisciplina.getSemestre(),Toast.LENGTH_LONG).show();
        }

        //colocar as disciplinas do array como botões
        if(!disciplinas.isEmpty()){
           int i=0;
           while(i < disciplinas.size()){
               Button button = new Button(this);
               button.setText(disciplinas.get(i).getNome());
               buttons.add(button);
               i++;
           }
           for(int x = 0;x<buttons.size();x++){
            LinearLayout layout = findViewById(R.id.layoutMenu2);
            layout.addView(buttons.get(x));
           }
        }
        //Listenner do botao criar disciplina
        criarDisciplina = findViewById(R.id.Button_criarDisciplina);
        criarDisciplina.setOnClickListener(new View.OnClickListener(){

            public void onClick (View v){

                changeActivity(new CriarDisciplinaActivity () );
            }
        });

        //Listener das disciplinas
        for(int i = 0;i<buttons.size();i++){

            buttons.get(i).setOnClickListener( new View.OnClickListener(){
                public void onClick (View v){
                    changeActivity(new NotasActivity());
                }
            });
        }
    }

    private void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences",MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        Gson  gson = new Gson();
        String json = gson.toJson(disciplinas);
        editor.putString("sub list",json);
        editor.apply();
    }

    private void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson  gson = new Gson();
        String json = sharedPreferences.getString("sub list", null);
        Type type = new TypeToken<ArrayList<Disciplina>>() {}.getType();
        disciplinas = gson.fromJson(json,type);

        if(disciplinas == null){
            disciplinas = new ArrayList<>();
        }

    }

    public void changeActivity(Activity activity){//função para mudar de atividade
        Class myActivity = activity.getClass();
        Intent intent = new Intent(MenuActivity.this, myActivity);
        startActivity(intent);

    }
}
