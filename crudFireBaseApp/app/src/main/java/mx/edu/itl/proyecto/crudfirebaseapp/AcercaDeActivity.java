/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2021    HORA: 10-11 HRS
:*
:*             Clase que contiene la vista hacia el acerca de
:*
:*  Archivo     : AcercaDeActivity.java
:*  Autores     : Jesus Andres Muñoz Morales     17130811
:*                Roberto Mendez Cardenas        17130805
:*                Edson Alaing Cheang Gonzalez   17130775
:*                Maria Guadalupe Reza Casas     17130829
:*                Jesus Alberto Diaz de Leon     17130778
:*  Fecha       : 01/12/2021
:*  Compilador  : Android Studio Artic Fox 2020.3.1 + JDK 11
:*  Descripción : En esta clase que almacena el metodo para visualisar el acerda de.
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.proyecto.crudfirebaseapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class AcercaDeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acercade);
    }
}