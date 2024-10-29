package controllers;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import models.Alumno;
import models.Espacio;
import models.Espacios;
import models.Instituto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LeerEspaciosJAXB {
    EscribirEspaciosJAXB escribirEspaciosJAXB = new EscribirEspaciosJAXB();
    public String leerXML(Path p){
        StringBuilder mensaje = new StringBuilder();
        if (Files.isReadable(p)){
            //creo la variable donde almacenar el contenido del XML
            Espacios misEspacios = new Espacios();
            //creo un contexto para cargar en memoria los datos persistidos
            JAXBContext jaxbContext = null;
            try {
                jaxbContext = JAXBContext.newInstance(Espacios.class);
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                misEspacios = (Espacios) unmarshaller.unmarshal(p.toFile());
                //devuelvo el nombre del instituto
                mensaje.append("Estos son mis espacios: \n");
                //añado al String los datos de los alumnos
                for (Espacio e: misEspacios.getEspacios()){
                    e.setPais("España");
                    mensaje.append("\t Espacio:").append(e.getNombre()).append(". Tipo: ").append(e.getTipo()).append("\n");
                }

                Path pOut = Path.of("target/salidaEspacios.xml");

                if (!Files.exists(pOut)){
                    Files.createFile(pOut);
                }

                escribirEspaciosJAXB.escribirXML(pOut, misEspacios);
            } catch (JAXBException e) {
                mensaje.append("El archivo XML no tiene la estructura adecuada." +e);
            } catch (IOException e) {
                mensaje.append("No se puede crear el fichero");
            }
        }else{
            mensaje.append("No se puede leer el archivo");
        }
        return mensaje.toString();
    }
}
