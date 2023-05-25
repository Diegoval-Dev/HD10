import model.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static UI ui = new UI();
    static txtReader txtreader = new txtReader();
    public static void main(String[] args) {

        Grafo grafo = createGrafo();

        Vertice origen = grafo.obtenerVertice("Guatemala");
        Vertice destino = grafo.obtenerVertice("AntiguaGuatemala");
        List<Vertice> rutaMasCorta = grafo.encontrarRutaMasCorta(origen, destino);

        if (!rutaMasCorta.isEmpty()) {
            System.out.println("Ruta más corta encontrada:");
            for (Vertice vertice : rutaMasCorta) {
                System.out.println(vertice.getName());
            }

            int pesoTotal = grafo.calcularPesoTotalRuta(rutaMasCorta);
            System.out.println("Peso total de la ruta: " + pesoTotal);
        } else {
            System.out.println("No se encontró una ruta válida entre los vértices.");
        }

        Vertice centro = grafo.encontrarCentroGrafo();

        if (centro != null) {
            System.out.println("Centro del grafo: " + centro.getName());
        } else {
            System.out.println("El grafo está vacío, no se puede determinar el centro.");
        }

    }
    public static Grafo createGrafo(){
        String[] rutaACaclular = ui.printMenu().split(" ");
        ArrayList<Ruta> rutas = txtreader.returnArr();
        for (Ruta ruta: rutas) {
            ruta.setTiemo(rutaACaclular[2]);
        }
        Grafo grafo = new Grafo();
        for (Ruta ruta : rutas) {
            Vertice origen = grafo.obtenerVertice(ruta.getDesde());
            Vertice destino = grafo.obtenerVertice(ruta.getHacia());

            if (origen == null) {
                origen = new Vertice(ruta.getDesde());
                grafo.agregarVertice(origen);
            }

            if (destino == null) {
                destino = new Vertice(ruta.getHacia());
                grafo.agregarVertice(destino);
            }

            Arista arista = new Arista(origen, destino, ruta.getTiempo());
            grafo.agregarArista(arista);
        }

        // Recorrer los vértices del grafo
        for (Vertice vertice : grafo.getVertices()) {
            System.out.println("Vértice: " + vertice.getName());
        }

        // Recorrer las aristas del grafo
        for (Arista arista : grafo.getAristas()) {
            System.out.println("Arista: " + arista.getOrigen().getName() + " - " +
                    arista.getDestino().getName() + " Peso: " + arista.getPeso());
        }




        return grafo;
    }
}