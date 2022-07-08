package Graph;

import java.util.*;

public class DepthFirstSearchRecursive {
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

    private void dfsTraversalUtil(Object startingVertex, Map<Object, TreeSet<Object>> graph, List<Object> visitedList) {
        visitedList.add(startingVertex);
        System.out.print(startingVertex + " ");

        TreeSet<Object> neighbours = graph.get(startingVertex);

        for(Object eachNeighbour : neighbours) {
            if(!visitedList.contains(eachNeighbour)) {
                dfsTraversalUtil(eachNeighbour, graph, visitedList);
            }
        }
    }

    private void dfsTraversal(Object startingVertex, Map<Object, TreeSet<Object>> graph) {
        List<Object> visitedList = new ArrayList<>();

        dfsTraversalUtil(startingVertex, graph, visitedList);
    }

    public static void main(String[] args) {
        DepthFirstSearchRecursive depthFirstSearchRecursive = new DepthFirstSearchRecursive();
        Map<Object, TreeSet<Object>> graph = new HashMap<>();

        depthFirstSearchRecursive.addEdge(graph, 1, 2);
        depthFirstSearchRecursive.addEdge(graph, 2, 4);
        depthFirstSearchRecursive.addEdge(graph, 4, 6);
        depthFirstSearchRecursive.addEdge(graph, 6, 5);
        depthFirstSearchRecursive.addEdge(graph, 5, 3);
        depthFirstSearchRecursive.addEdge(graph, 3, 1);
        depthFirstSearchRecursive.addEdge(graph, 2, 5);
        depthFirstSearchRecursive.addEdge(graph, 4, 5);

        depthFirstSearchRecursive.dfsTraversal(1, graph);
    }
}
