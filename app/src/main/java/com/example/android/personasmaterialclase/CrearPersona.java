package com.example.android.personasmaterialclase;

import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class CrearPersona extends AppCompatActivity {
    private EditText txtcedula;
    private EditText txtnombre;
    private EditText txtapellido;
    private ArrayList<Integer> fotos;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_persona);
        txtcedula = (EditText) findViewById(R.id.txtcedula);
        txtnombre = (EditText) findViewById(R.id.txtnombre);
        txtapellido = (EditText) findViewById(R.id.txtapellido);

        res = this.getResources();
        inicializarFotos();
    }

    public  void inicializarFotos(){
        fotos = new ArrayList<>();
        fotos.add(R.drawable.images);
        fotos.add(R.drawable.images2);
        fotos.add(R.drawable.images3);
    }

    public boolean validar(){
        String aux = res.getString(R.string.mensaje_error_vacio);
        if (Metodos.validar_aux(txtcedula,aux))return false;
                else if (Metodos.validar_aux(txtapellido,aux))return false;
                    else if (Metodos.validar_aux(txtnombre,aux))return false;
        return true;
    }

    public void agregar(View v){
        if (validar()){
            Persona p = new Persona(
                    Metodos.intfotoAleatoria(fotos),
                    txtcedula.getText().toString(),
                    txtnombre.getText().toString(),
                    txtapellido.getText().toString()
                    );
            p.guardar();
            Snackbar.make(v,res.getString(R.string.mensaje_aviso_agregar),Snackbar.LENGTH_SHORT).setAction("Action",null).show();
            Limpiar();
        }
    }

    public void Limpiar(View v){
        Limpiar();
    }
    public void  onBackPressed(){
        finish();
        Intent i = new Intent(CrearPersona.this, Principal.class);
        startActivity(i);
    }

    public void Limpiar(){
        txtcedula.setText("");
        txtnombre.setText("");
        txtapellido.setText("");
        txtcedula.requestFocus();
    }
}
