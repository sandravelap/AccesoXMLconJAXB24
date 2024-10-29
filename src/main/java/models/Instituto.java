package models;


import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;

@XmlRootElement(name = "instituto")
//aquí definimos los atributos de la clase cuyo valor vamos a coger del xml
@XmlType(propOrder = {"nombre", "alumnos"})
public class Instituto {
    private String nombre;
    private ArrayList<Alumno> alumnos;

    public Instituto() {
    }

    //name es el nombre de la etiqueta del xml cuyo valor cargaremos en el atributo.
    @XmlElement(name="nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //cuando un elemento hijo es un array lo definimos como wrapper y definimos la etiqueta
    //del elemento que envuelve y el elemento envuelto
    @XmlElementWrapper(name="alumnos")
    @XmlElement(name="alumno")
    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
