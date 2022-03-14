package com.company.model;

import java.util.*;
import java.util.stream.Collectors;

public class Graph<T> {

    private List<Vertex> nodes;
    private boolean isDirectionnal = false;
    private List<Vertex> path = new ArrayList<>();

    public List<Vertex> getPath() {
        for (Vertex vertex : path) {
            System.out.println(vertex.getData());
        }
        return path;
    }

    public Graph() {
        this.nodes = new ArrayList<>();
    }


    public void addEdge(Vertex source, Vertex destination) {
        source.getEdgeList().add(new Edge(destination));

        if (!isDirectionnal) {
            destination.getEdgeList().add(new Edge(source));
        }
    }

    public void addEdge(Vertex source, Vertex destination, int weight) {
        source.getEdgeList().add(new Edge(weight, destination));

        if (!isDirectionnal) {
            destination.getEdgeList().add(new Edge(weight, source));
        }
    }

    public boolean addVertex(Vertex vertex) {
        return nodes.add(vertex);
    }

    public List<Vertex> getNodes() {
        return nodes;
    }

    public void printGraph() {
        for (Vertex v : nodes) {
            System.out.print("vertex name: " + v.getData() + ": ");
            LinkedList<Edge> edges = v.getEdgeList();
            for (Edge e : edges) {
                System.out.print("destVertex: " + e.getDestination().getData() + " weight: " + e.getWeight() + " | ");
            }
            System.out.print("\n");
        }
    }

    public void DFS(Vertex vertex) {
        vertex.setVisited();
        System.out.print(vertex.getData() + " ");

        LinkedList<Edge> edges = vertex.getEdgeList();

        for (Edge edge : edges) {
            Vertex edgeVertex = edge.getDestination();
            if (!edgeVertex.isVisited()) {
                DFS(edgeVertex);
            }
        }
    }

    public void resetAllNodeVisited() {

        for (Vertex vertex : nodes) {
            vertex.unvisite();
        }
    }

    public LinkedList<Vertex> BFS(Vertex depart, Vertex arrive) {

        Map<Vertex, Vertex> previous = new HashMap<Vertex, Vertex>();
        LinkedList<Vertex> path = new LinkedList<>();
        LinkedList<Vertex> queue = new LinkedList<>();
        queue.add(depart);

        while(!queue.isEmpty()) {
            Vertex currentFirst = queue.removeFirst();

            if (currentFirst.equals(arrive)) {

                while (currentFirst != null) {
                    path.addFirst(currentFirst);
                    currentFirst = previous.get(currentFirst);
                }

                return path;

            }

            currentFirst.setVisited();

            LinkedList<Edge> edges = currentFirst.getEdgeList();

            if(edges == null)
                continue;

            for(Edge edge : edges) {
                Vertex vertex = edge.getDestination();

                if (!vertex.isVisited()) {
                    previous.put(edge.getDestination(), currentFirst);
                    queue.add(vertex);
                }
            }

        }
        return null;

    }

    public Vertex getLowestDistanceNode(List<Vertex> nodes) {
        Vertex lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;

        for (Vertex node: nodes) {
            int nodeDistance = node.getDistanceFromSource();
            if (nodeDistance < lowestDistance && node.isVisited() == false) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }

        return lowestDistanceNode;
    }
    public void findPathDijkstra(Vertex depart) {
        Vertex currentNode = null;

        for (Vertex vertex : nodes) {
            if (vertex.equals(depart)) {
                vertex.setDistanceFromSource(0);
                currentNode = vertex;
            }
        }

        while (currentNode != null ) {
            currentNode.setVisited();
            List<Edge> edges = currentNode.getEdgeList();
            for (Edge edge : edges) {
                if (edge.getDestination().getDistanceFromSource() > currentNode.getDistanceFromSource() + edge.getWeight()) {
                    edge.getDestination().setDistanceFromSource(currentNode.getDistanceFromSource() + edge.getWeight());
                    edge.getDestination().setBestParentFromSource(currentNode);
                }
            }
            currentNode = getLowestDistanceNode(nodes);
        }
    }

    public void distanceFromVertex(Vertex vertex) {
        System.out.println(this.getNodes().stream().filter(data -> data.equals(vertex)).collect(Collectors.toList()));
    }

    public Vertex getNodeByName(char name) {
        return this.getNodes().stream().filter(data -> data.getCode() == name).findFirst().orElse(null);
    }
}


