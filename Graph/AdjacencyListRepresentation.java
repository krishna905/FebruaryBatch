package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class AdjacencyListRepresentation {
    private void addEdge(Map<Object, TreeSet<Object>> graph, Object u, Object v) {
        if(!graph.containsKey(u)) {
            graph.put(u, new TreeSet<>());
        }
        if(!graph.containsKey(v)) {
            graph.put(v, new TreeSet<>());
        }

        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    public static void main(String[] args) {
        AdjacencyListRepresentation adjacencyListRepresentation
                = new AdjacencyListRepresentation();

        Map<Object, TreeSet<Object>> graph = new HashMap<>();

        adjacencyListRepresentation.addEdge(graph, 0, 1);
        adjacencyListRepresentation.addEdge(graph, 0, 4);
        adjacencyListRepresentation.addEdge(graph, 1, 2);
        adjacencyListRepresentation.addEdge(graph, 1, 4);
        adjacencyListRepresentation.addEdge(graph, 2, 3);
        adjacencyListRepresentation.addEdge(graph, 3, 4);
        adjacencyListRepresentation.addEdge(graph, 0, 0);
        adjacencyListRepresentation.addEdge(graph, "Delhi", "Mumbai");

        System.out.println(graph);
    }
}
