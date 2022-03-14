package com.company.model;

import java.util.LinkedList;

public class Vertex<T> {

    private T data;
    private LinkedList<Edge> edgeList;
    private boolean visited;

    public char getCode() {
        return code;
    }

    public void setCode(char code) {
        this.code = code;
    }

    private char code;
    public int getDistanceFromSource() {
        return distanceFromSource;
    }

    public void setDistanceFromSource(int distanceFromSource) {
        this.distanceFromSource = distanceFromSource;
    }

    public Vertex getBestParentFromSource() {
        return bestParentFromSource;
    }

    public void setBestParentFromSource(Vertex bestParentFromSource) {
        this.bestParentFromSource = bestParentFromSource;
    }

    private int distanceFromSource;
    private Vertex bestParentFromSource;

    public Vertex(T data, char code) {
        this.code = code;
        this.data = data;
        this.edgeList = new LinkedList<>();
        distanceFromSource = Integer.MAX_VALUE;
        visited = false;
    }

    public T getData() {
        return data;
    }

    public LinkedList<Edge> getEdgeList() {
        return edgeList;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited() {
        this.visited = true;
    }

    public void unvisite() {
        this.visited = false;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;

        if (!(obj instanceof Vertex))
            return false;
        Vertex pn = (Vertex) obj;

        return this.data == pn.data;
    }

    @Override
    public String toString() {
        return "Arrêt : " + data +" Distance=" + distanceFromSource + "min";
    }
}

