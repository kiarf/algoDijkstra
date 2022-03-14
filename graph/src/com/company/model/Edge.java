package com.company.model;

public class Edge {
    private int weight;
    private Vertex destination;

    public Edge(Vertex destination) {
        this.destination = destination;
    }

    public Edge(int weight, Vertex destination) {
        this.weight = weight;
        this.destination = destination;
    }

    public int getWeight() {
        return weight;
    }

    public Vertex getDestination() {
        return destination;
    }
}
