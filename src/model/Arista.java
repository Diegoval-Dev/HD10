package model;

public class Arista {
    private Vertice origen;
    private Vertice destino;
    private int peso;

    public Arista(Vertice origen, Vertice destino, int peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }
}
