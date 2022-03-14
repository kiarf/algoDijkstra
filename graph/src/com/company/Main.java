package com.company;

import com.company.model.Graph;
import com.company.model.Vertex;

import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.println("bouh");

        Graph<String> graph = new Graph<String>();

        Vertex a = new Vertex("Les vergnes", 'a');
        Vertex b = new Vertex("Stade G.MontPied", 'b');
        Vertex c = new Vertex("Lycée Lafayette", 'c');
        Vertex d = new Vertex("Stade M.Michelin", 'd');
        Vertex e = new Vertex("1er Mai", 'e');
        Vertex f = new Vertex("Gare SNCF", 'f');
        Vertex g = new Vertex("Carnot", 'g');
        Vertex h = new Vertex("Ballainvilliers", 'h');
        Vertex i = new Vertex("Jaude", 'i');
        Vertex j = new Vertex("Université", 'j');
        Vertex k = new Vertex("CHU G. Montpied", 'k');
        Vertex l = new Vertex("La Part-Dieu Gare", 'l');
        Vertex m = new Vertex("Royat", 'm');

        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);
        graph.addVertex(e);
        graph.addVertex(f);
        graph.addVertex(g);
        graph.addVertex(h);
        graph.addVertex(i);
        graph.addVertex(j);
        graph.addVertex(k);
        graph.addVertex(l);
        graph.addVertex(m);

        // Ligne A
        graph.addEdge(a, b, 1); // Les vergnes - Stade GM
        graph.addEdge(b, d, 18); // Stade GM - Stade MM
        graph.addEdge(d, e, 2); // Stade MM - 1er Mai
        graph.addEdge(e, i, 7); // 1er Mai - Jaude
        graph.addEdge(i, j, 13); // Jaude - Université
        graph.addEdge(j, k,10); // Universités - CHU GM
        graph.addEdge(k, c, 12); // CHU GM - Lycée Lafayette
        graph.addEdge(c ,l, 2); // Lycée Lafayette - La Part-Dieu Gare
        // Ligne B
        graph.addEdge(d, f, 2); //Stade MM - Gare SNCF
        graph.addEdge(f, g, 1); // Gare SNCF - Carnot
        graph.addEdge(g, h, 2); // Carnot - Ballainvilliers
        graph.addEdge(h, i, 2); // Ballainvilliers - Jaude
        graph.addEdge(i, m, 7); // Jaude - Royat
        // Ligne 3
        graph.addEdge(b, f, 16); // Stade GM - Gare SNCF
        graph.addEdge(f, h, 6); // Gare SNCF - Ballainvilliers
        graph.addEdge(h, j, 2); // Ballainvilliers - Universités
        // Ligne C
        graph.addEdge(g, c, 11); // Carnot - Lycée Lafayette

        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez le code de l'arrêt de départ");
        char source = sc.next().charAt(0);
        System.out.println("Entrez le code de l'arrêt d'arrivée");
        char dest = sc.next().charAt(0);

        graph.resetAllNodeVisited();
        graph.findPathDijkstra(graph.getNodeByName(source));
        graph.distanceFromVertex(graph.getNodeByName(dest));
    }


}
