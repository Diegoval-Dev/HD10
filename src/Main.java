import model.*;

import java.util.ArrayList;

public class Main {
    static UI ui = new UI();
    static txtReader txtreader = new txtReader();
    public static void main(String[] args) {

        Grafo grafo = createGrafo();

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