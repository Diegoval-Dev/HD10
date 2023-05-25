package model;

import java.util.*;

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
    public List<Arista> getAristasSalientes(Vertice vertice) {
        List<Arista> aristasSalientes = new ArrayList<>();

        for (Arista arista : aristas) {
            if (arista.getOrigen().equals(vertice)) {
                aristasSalientes.add(arista);
            }
        }

        return aristasSalientes;
    }
    public List<Vertice> encontrarRutaMasCorta(Vertice origen, Vertice destino) {
        Map<Vertice, Integer> distancias = new HashMap<>();
        Map<Vertice, Vertice> predecesores = new HashMap<>();
        PriorityQueue<VerticeDistancia> colaPrioridad = new PriorityQueue<>();
        Set<Vertice> visitados = new HashSet<>();

        // Inicializar las distancias con un valor infinito, excepto el vértice de origen
        for (Vertice vertice : getVertices()) {
            if (vertice.equals(origen)) {
                distancias.put(vertice, 0);
            } else {
                distancias.put(vertice, Integer.MAX_VALUE);
            }
        }

        colaPrioridad.offer(new VerticeDistancia(origen, 0));

        while (!colaPrioridad.isEmpty()) {
            VerticeDistancia actual = colaPrioridad.poll();
            Vertice verticeActual = actual.getVertice();
            int distanciaActual = actual.getDistancia();

            if (visitados.contains(verticeActual)) {
                continue;
            }

            visitados.add(verticeActual);

            if (verticeActual.equals(destino)) {
                break;
            }

            for (Arista arista : getAristasSalientes(verticeActual)) {
                Vertice verticeVecino = arista.getDestino();
                int pesoArista = arista.getPeso();
                int distanciaNueva = distanciaActual + pesoArista;

                if (distanciaNueva < distancias.get(verticeVecino)) {
                    distancias.put(verticeVecino, distanciaNueva);
                    predecesores.put(verticeVecino, verticeActual);
                    colaPrioridad.offer(new VerticeDistancia(verticeVecino, distanciaNueva));
                }
            }
        }

        return construirRuta(predecesores, origen, destino);
    }

    // Método para construir la ruta a partir de los predecesores encontrados por Dijkstra
    private List<Vertice> construirRuta(Map<Vertice, Vertice> predecesores, Vertice origen, Vertice destino) {
        List<Vertice> ruta = new ArrayList<>();
        Vertice verticeActual = destino;

        while (verticeActual != null) {
            ruta.add(0, verticeActual);
            verticeActual = predecesores.get(verticeActual);
        }

        if (!ruta.isEmpty() && ruta.get(0).equals(origen)) {
            return ruta;
        } else {
            return new ArrayList<>();
        }
    }
    public int calcularPesoTotalRuta(List<Vertice> ruta) {
        int pesoTotal = 0;

        for (int i = 0; i < ruta.size() - 1; i++) {
            Vertice origen = ruta.get(i);
            Vertice destino = ruta.get(i + 1);

            for (Arista arista : getAristas()) {
                if (arista.getOrigen().equals(origen) && arista.getDestino().equals(destino)) {
                    pesoTotal += arista.getPeso();
                    break;
                }
            }
        }

        return pesoTotal;
    }
    public Vertice encontrarCentroGrafo() {
        Map<Vertice, Integer> sumasDistancias = new HashMap<>();

        // Inicializar las sumas de distancias con valor cero para cada vértice
        for (Vertice vertice : getVertices()) {
            sumasDistancias.put(vertice, 0);
        }

        // Calcular las sumas de distancias desde cada vértice hacia todos los demás vértices
        for (Vertice vertice : getVertices()) {
            Map<Vertice, Integer> distancias = calcularDistancias(vertice);

            for (Map.Entry<Vertice, Integer> distancia : distancias.entrySet()) {
                Vertice destino = distancia.getKey();
                int distanciaActual = distancia.getValue();

                sumasDistancias.put(destino, sumasDistancias.get(destino) + distanciaActual);
            }
        }

        // Encontrar el vértice con la menor suma de distancias
        Vertice centro = null;
        int menorSuma = Integer.MAX_VALUE;

        for (Map.Entry<Vertice, Integer> sumaDistancia : sumasDistancias.entrySet()) {
            Vertice vertice = sumaDistancia.getKey();
            int suma = sumaDistancia.getValue();

            if (suma < menorSuma) {
                menorSuma = suma;
                centro = vertice;
            }
        }

        return centro;
    }
    private Map<Vertice, Integer> calcularDistancias(Vertice origen) {
        Map<Vertice, Integer> distancias = new HashMap<>();
        Set<Vertice> visitados = new HashSet<>();

        // Inicializar todas las distancias con valor infinito, excepto el vértice de origen
        for (Vertice vertice : getVertices()) {
            if (vertice.equals(origen)) {
                distancias.put(vertice, 0);
            } else {
                distancias.put(vertice, Integer.MAX_VALUE);
            }
        }

        PriorityQueue<VerticeDistancia> colaPrioridad = new PriorityQueue<>();
        colaPrioridad.offer(new VerticeDistancia(origen, 0));

        while (!colaPrioridad.isEmpty()) {
            VerticeDistancia actual = colaPrioridad.poll();
            Vertice verticeActual = actual.getVertice();
            int distanciaActual = actual.getDistancia();

            if (visitados.contains(verticeActual)) {
                continue;
            }

            visitados.add(verticeActual);

            for (Arista arista : getAristasSalientes(verticeActual)) {
                Vertice verticeVecino = arista.getDestino();
                int pesoArista = arista.getPeso();
                int distanciaNueva = distanciaActual + pesoArista;

                if (distanciaNueva < distancias.get(verticeVecino)) {
                    distancias.put(verticeVecino, distanciaNueva);
                    colaPrioridad.offer(new VerticeDistancia(verticeVecino, distanciaNueva));
                }
            }
        }

        return distancias;
    }
}


