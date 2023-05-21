package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grafo {
    private Map<String, Vertice> vertices;
    private ArrayList<Arista> aristas;

    public Grafo() {
        vertices = new HashMap<>();
        aristas = new ArrayList<>();
    }

    public void agregarVertice(Vertice vertice) {
        vertices.put(vertice.getName(), vertice);
    }

    public Vertice obtenerVertice(String nombre) {
        return vertices.get(nombre);
    }

    public void agregarArista(Arista arista) {
        aristas.add(arista);
    }

    public ArrayList<Vertice> getVertices() {
        return new ArrayList<>(vertices.values());
    }

    public ArrayList<Arista> getAristas() {
        return aristas;
    }
}
