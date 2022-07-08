package Graph;

import java.util.*;

public class BreadthFirstSearch {
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

    private void bfsTraversal(Object startingVertex, Map<Object, TreeSet<Object>> graph) {
        List<Object> visitedList = new ArrayList<>();
        Queue<Object> queue = new LinkedList<>();

        visitedList.add(startingVertex);
        queue.add(startingVertex);

        while(!queue.isEmpty()) {
            Object currentNode = queue.poll();
            System.out.print(currentNode + " ");

            TreeSet<Object> neighbours = graph.get(currentNode);

            for(Object eachNeighbour : neighbours) {
                if(!visitedList.contains(eachNeighbour)) {
                    queue.add(eachNeighbour);
                    visitedList.add(eachNeighbour);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
        Map<Object, TreeSet<Object>> graph = new HashMap<>();

        breadthFirstSearch.addEdge(graph, 1, 2);
        breadthFirstSearch.addEdge(graph, 2, 4);
        breadthFirstSearch.addEdge(graph, 4, 6);
        breadthFirstSearch.addEdge(graph, 6, 5);
        breadthFirstSearch.addEdge(graph, 5, 3);
        breadthFirstSearch.addEdge(graph, 3, 1);
        breadthFirstSearch.addEdge(graph, 2, 5);
        breadthFirstSearch.addEdge(graph, 4, 5);

        breadthFirstSearch.bfsTraversal(6, graph);
    }
}
