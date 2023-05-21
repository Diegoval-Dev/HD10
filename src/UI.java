import model.Ruta;

import java.util.Scanner;

public class UI {
    Scanner sc = new Scanner(System.in);
    public String printMenu() {
        String inicio = null;
        String destino = null;
        String clima = null;
        try {
            System.out.println("----Bienvenidos----");
            System.out.println("Ingrese su destino: ");
            printCities();
            destino = sc.nextLine();
            System.out.println("Ingrese su punto de partida: ");
            printCities();
            inicio = sc.nextLine();
            System.out.println("Ingrese el clima: ");
            printClima();
            clima = sc.nextLine();

        } catch (Exception e) {
            printMenu();
        }
        return inicio + " " + destino + " " + clima;
    }
    public void printCities(){
        System.out.println("Guatemala");
        System.out.println("AntiguaGuatemala");
        System.out.println("Chimaltenango");
        System.out.println("Escuintla");
        System.out.println("Quetzaltenango");
        System.out.println("Huehuetenango");
        System.out.println("Retalhuleu");
        System.out.println("Solola");
        System.out.println("Zacapa");
        System.out.println("Coban");
        System.out.println("PuertoBarrios");
    }
    public void printClima(){
        System.out.println("Normal");
        System.out.println("Lluvia");
        System.out.println("Nevado");
        System.out.println("Tormenta");
    }
}
