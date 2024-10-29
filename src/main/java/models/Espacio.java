package models;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name="espacio")
//aquí se introduce el nombre de los atributos y en el getter el nombre de la etiqueta
@XmlType(propOrder = {"nombre", "municipios"})
public class Espacio {
    private String nombre;
    private String tipo;
    private String municipios;
    private String pais;

    public Espacio() {
    }

    @XmlElement(name="nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlAttribute(name="tipo")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlElement(name="municipios")
    public String getMunicipios() {
        return municipios;
    }

    public void setMunicipios(String municipios) {
        this.municipios = municipios;
    }

    //aquí se introduce el nombre de la etiqueta
    //@XmlElement(name="country")
    //Si no la cojo del xml, la etiqueto para que se la salte
    @XmlTransient
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
