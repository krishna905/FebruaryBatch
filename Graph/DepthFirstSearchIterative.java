package Graph;

import java.util.*;

public class DepthFirstSearchIterative {
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

    private void dfsTraversal(Object startingVertex, Map<Object, TreeSet<Object>> graph) {
        List<Object> visitedList = new ArrayList<>();
        Stack<Object> stack = new Stack<>();

        stack.add(startingVertex);

        while(!stack.isEmpty()) {
            Object currentNode = stack.pop();

            if(!visitedList.contains(currentNode)) {
                visitedList.add(currentNode);
                System.out.print(currentNode + " ");
            }

            TreeSet<Object> neighbours = graph.get(currentNode);

            for(Object eachNeighbour : neighbours) {
                if(!visitedList.contains(eachNeighbour)) {
                    stack.add(eachNeighbour);
                }
            }
        }
    }

    public static void main(String[] args) {
        DepthFirstSearchIterative depthFirstSearchIterative = new DepthFirstSearchIterative();
        Map<Object, TreeSet<Object>> graph = new HashMap<>();

        depthFirstSearchIterative.addEdge(graph, 1, 2);
        depthFirstSearchIterative.addEdge(graph, 2, 4);
        depthFirstSearchIterative.addEdge(graph, 4, 6);
        depthFirstSearchIterative.addEdge(graph, 6, 5);
        depthFirstSearchIterative.addEdge(graph, 5, 3);
        depthFirstSearchIterative.addEdge(graph, 3, 1);
        depthFirstSearchIterative.addEdge(graph, 2, 5);
        depthFirstSearchIterative.addEdge(graph, 4, 5);

        depthFirstSearchIterative.dfsTraversal(1, graph);
    }
}
