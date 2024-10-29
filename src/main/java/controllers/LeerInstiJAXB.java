package controllers;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import models.Alumno;
import models.Instituto;


import java.nio.file.Files;
import java.nio.file.Path;

public class LeerInstiJAXB {
    public String leerXML(Path p){
        StringBuilder mensaje = new StringBuilder();
        if (Files.isReadable(p)){
            //creo la variable donde almacenar el contenido del XML
            Instituto miInstituto = new Instituto();
            //creo un contexto para cargar en memoria los datos persistidos
            JAXBContext jaxbContext = null;
            try {
                jaxbContext = JAXBContext.newInstance(Instituto.class);
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                miInstituto = (Instituto) unmarshaller.unmarshal(p.toFile());
                //devuelvo el nombre del instituto
                mensaje.append(miInstituto.getNombre()).append("\n");
                //añado al String los datos de los alumnos
                for (Alumno a : miInstituto.getAlumnos()){
                    mensaje.append("\t Alumno:").append(a.getNombre()).append(" . Curso: ").append(a.getCurso()).append("\n");
                }
            } catch (JAXBException e) {
                mensaje.append("El archivo XML no tiene la estructura adecuada." +e.getMessage());
            }
        }else{
            mensaje.append("No se puede leer el archivo");
        }
        return mensaje.toString();
    }
}
