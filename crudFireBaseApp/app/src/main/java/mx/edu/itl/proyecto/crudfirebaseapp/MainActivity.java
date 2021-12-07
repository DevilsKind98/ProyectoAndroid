/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2021    HORA: 10-11 HRS
:*
:*             Clase que contiene los metodos getter y setter
:*
:*  Archivo     : MainActivity.java
:*  Autores     : Jesus Andres Muñoz Morales     17130811
:*                Roberto Mendez Cardenas        17130805
:*                Edson Alaing Cheang Gonzalez   17130775
:*                Maria Guadalupe Reza Casas     17130829
:*                Jesus Alberto Diaz de Leon     17130778
:*  Fecha       : 01/12/2021
:*  Compilador  : Android Studio Artic Fox 2020.3.1 + JDK 11
:*  Descripción : En esta clase se tendran los metodos necesarios para
:*                la ejecucion de la actividad principal.
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.proyecto.crudfirebaseapp;

import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import mx.edu.itl.proyecto.crudfirebaseapp.modelo.Persona;


public class MainActivity extends AppCompatActivity {

    private List<Persona> listaPersonas = new ArrayList<Persona>();
    ArrayAdapter<Persona> arrayAdapterPersona;

    EditText nomP, numP,correoP, nipP;
    ListView listV_personas;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    Persona personaSeleccionada;
    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomP = findViewById(R.id.txt_nombrePersona);
        numP = findViewById(R.id.txt_numeroPersona);
        correoP = findViewById(R.id.txt_correoPersona);
        nipP = findViewById(R.id.txt_nip);

        listV_personas = findViewById(R.id.lv_datosPersonas);
        inicializarFirebase();
        listarDatos();

        listV_personas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                personaSeleccionada = (Persona) parent.getItemAtPosition(position);
                nomP.setText(personaSeleccionada.getNombre());
                correoP.setText(personaSeleccionada.getCorreo());
                numP.setText(personaSeleccionada.getNumero().toString());
                nipP.setText(personaSeleccionada.getNip().toString());
            }
        });

    }

    //----------------------------------------------------------------------------------------------

    private void listarDatos() {
        databaseReference.child("Persona").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listaPersonas.clear();
                for (DataSnapshot objSnaptshot : dataSnapshot.getChildren()){
                    Persona p = objSnaptshot.getValue(Persona.class);
                    listaPersonas.add(p);

                    arrayAdapterPersona = new ArrayAdapter<Persona>(MainActivity.this,
                            android.R.layout.simple_list_item_1, listaPersonas);
                    listV_personas.setAdapter(arrayAdapterPersona);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
    //----------------------------------------------------------------------------------------------
    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        //firebaseDatabase.setPersistenceEnabled(true);
        databaseReference = firebaseDatabase.getReference();
    }
    //----------------------------------------------------------------------------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }
    //----------------------------------------------------------------------------------------------
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String nombre = nomP.getText().toString();
        String correo = correoP.getText().toString();
        String numero = numP.getText().toString();
        String nip    = nipP.getText().toString();

        switch (item.getItemId()){

            case R.id.icon_add:{

                if (nombre.length()==0){
                    nomP.setError("Ingrese un nombre");
                }
                if (correo.length()==0){
                    correoP.setError("Ingrese un Correo");
                }
                if(numero.length()==0){
                    numP.setError("Ingrese su numero");
                }
                if (nip.length()==0){
                    nipP.setError("Ingrese un numero");
                }
                else {
                    Persona p = new Persona();
                    p.setUid(UUID.randomUUID().toString());
                    p.setNombre(nombre);
                    p.setCorreo(correo);
                    p.setNumero(Integer.parseInt(numero));
                    p.setNip(Integer.parseInt(nip));
                    databaseReference.child("Persona").child(p.getUid()).setValue(p);
                    Toast.makeText(this, "Agregado", Toast.LENGTH_LONG).show();
                    limpiarCajas();
                }
                break;
            }

            case R.id.icon_save:{

                if (nombre.length()==0){
                    nomP.setError("Ingrese un nombre");
                }
                if (correo.length()==0){
                    correoP.setError("Ingrese un Correo");
                }
                if(numero.length()==0){
                    numP.setError("Ingrese su numero");
                }
                if (nip.length()==0){
                    nipP.setError("Ingrese un numero");
                }
                else {

                    Persona p = new Persona();
                    p.setUid(personaSeleccionada.getUid());
                    p.setNombre(nomP.getText().toString().trim());
                    p.setCorreo(correoP.getText().toString().trim());
                    p.setNumero(Integer.parseInt(numP.getText().toString().trim()));
                    p.setNip(Integer.parseInt(nipP.getText().toString().trim()));
                    databaseReference.child("Persona").child(p.getUid()).setValue(p);
                    Toast.makeText(this, "Actualizado", Toast.LENGTH_LONG).show();
                    limpiarCajas();
                }
                break;
            }
            case R.id.icon_delete:{

                Persona p = new Persona();
                p.setUid(personaSeleccionada.getUid());
                databaseReference.child("Persona").child(p.getUid()).removeValue();
                Toast.makeText(this,"Eliminado", Toast.LENGTH_LONG).show();
                limpiarCajas();
                break;
            }
            case R.id.acercaDe:
                Intent intent = new Intent(this,AcercaDeActivity.class);
                startActivity(intent);
                break;
            default:break;
        }
        return true;
    }
    //----------------------------------------------------------------------------------------------

    private void limpiarCajas() {
        nomP.setText("");
        correoP.setText("");
        nipP.setText("");
        numP.setText("");
    }
    //----------------------------------------------------------------------------------------------
}
