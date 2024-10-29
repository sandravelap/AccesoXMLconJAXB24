package menus;

import controllers.LeerEspaciosJAXB;
import controllers.LeerInstiJAXB;

import java.nio.file.Path;
import java.util.Scanner;

import static libs.UserData.pedirRutaXML;

public class MenuPrincipal {
    private boolean salir = false;
    private Scanner sc = new Scanner(System.in);
    LeerInstiJAXB leerInstiJAXB = new LeerInstiJAXB();
    LeerEspaciosJAXB leerEspaciosJAXB = new LeerEspaciosJAXB();

    public void muestraMenu() {
        String opcion;
        do {
            System.out.println("Elige una opcion:");
            System.out.println("1. Leer insti.XML con JAXB.");
            System.out.println("2. Leer espacios.XML con JAXB.");
            System.out.println("0. Salir");
            opcion = this.pideOpcion();
            this.procesaOpcion(opcion);
        } while (!salir);
    }

    private String pideOpcion() {
        return this.sc.nextLine();
    }

    private void procesaOpcion(String opcion) {
        switch (opcion) {
            case "0" -> salir = true;
            case "1" -> {
                Path p = pedirRutaXML("Introduce la ruta del archivo XML");
                System.out.println(leerInstiJAXB.leerXML(p));
                }
            case "2" -> {
                Path p = pedirRutaXML("Introduce la ruta del archivo XML");
                System.out.println(leerEspaciosJAXB.leerXML(p));
            }
            default -> System.out.println("Opción incorrecta");
        }
    }
}
