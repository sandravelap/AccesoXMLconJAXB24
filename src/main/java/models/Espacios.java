package models;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;

//cuando el elemento raíz es en sí mismo un wrapper no hace falta poner nada
@XmlRootElement(name="espacios")
public class Espacios {
    private ArrayList<Espacio> espacios;

    public Espacios() {}

    //únicamente se define el elemento hijo
    @XmlElement(name="espacio")
    public ArrayList<Espacio> getEspacios() {
        return espacios;
    }

    public void setEspacios(ArrayList<Espacio> espacios) {
        this.espacios = espacios;
    }
}
