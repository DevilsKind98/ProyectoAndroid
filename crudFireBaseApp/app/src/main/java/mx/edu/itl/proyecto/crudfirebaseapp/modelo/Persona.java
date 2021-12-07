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
:*  Archivo     : Persona.java
:*  Autores     : Jesus Andres Muñoz Morales     17130811
:*                Roberto Mendez Cardenas        17130805
:*                Edson Alaing Cheang Gonzalez   17130775
:*                Maria Guadalupe Reza Casas     17130829
:*                Jesus Alberto Diaz de Leon     17130778
:*  Fecha       : 01/12/2021
:*  Compilador  : Android Studio Artic Fox 2020.3.1 + JDK 11
:*  Descripción : En esta clase se tendran los metodos para obtener
:*                los datos de la persona que se ingresara a la base de datos.
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.proyecto.crudfirebaseapp.modelo;

public class Persona {

    private String uid;

    private String Nombre;
    private String Correo;
    private Integer numero;
    private Double Nip;
    //----------------------------------------------------------------------------------------------

    public String getUid() {
        return uid;
    }

    //----------------------------------------------------------------------------------------------

    public void setUid(String uid) {
        this.uid = uid;
    }

    //----------------------------------------------------------------------------------------------

    public String getNombre() {
        return Nombre;
    }

    //----------------------------------------------------------------------------------------------

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    //----------------------------------------------------------------------------------------------

    public String getCorreo() {
        return Correo;
    }

    //----------------------------------------------------------------------------------------------

    public void setCorreo(String correo) {
        Correo = correo;
    }

    //----------------------------------------------------------------------------------------------

    public Integer getNumero() {
        return numero;
    }

    //----------------------------------------------------------------------------------------------

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    //----------------------------------------------------------------------------------------------

    public Double getNip() {
        return Nip;
    }

    //----------------------------------------------------------------------------------------------

    public void setNip(Double nip) {
        Nip = nip;
    }

    //----------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return Nombre;
    }

    //----------------------------------------------------------------------------------------------
}
