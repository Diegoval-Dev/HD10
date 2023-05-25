package model;

public class VerticeDistancia implements Comparable<VerticeDistancia> {
    private Vertice vertice;
    private int distancia;

    public VerticeDistancia(Vertice vertice, int distancia) {
        this.vertice = vertice;
        this.distancia = distancia;
    }

    public Vertice getVertice() {
        return vertice;
    }

    public int getDistancia() {
        return distancia;
    }

    @Override
    public int compareTo(VerticeDistancia otro) {
        return Integer.compare(distancia, otro.distancia);
    }

}
