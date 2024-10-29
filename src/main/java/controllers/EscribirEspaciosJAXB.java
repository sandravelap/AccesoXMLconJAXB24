package controllers;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import models.Espacios;

import java.nio.file.Path;

public class EscribirEspaciosJAXB {
    public String escribirXML(Path p, Espacios espacios){
        //devolveremos un mensaje si se puede o no escribir
        String mensaje = "";
        //para escribir hacemos uso de las clases de la API
        try {
            //En primer lugar se crea el contexto a partir de las anotaciones de la clase
            JAXBContext contextOut = JAXBContext.newInstance(Espacios.class);
            //instanciar un Marshaller
            Marshaller marshaller = contextOut.createMarshaller();
            //dar formato a la salida
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(espacios, p.toFile());
            mensaje ="Archivo generado correctamente. ";
        } catch (JAXBException e) {
            mensaje ="Error al generar el archivo. "+e;
        }
        return mensaje;
    }
}
