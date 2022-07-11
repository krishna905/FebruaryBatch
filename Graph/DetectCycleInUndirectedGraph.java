package Graph;

import java.util.*;

public class DetectCycleInUndirectedGraph {
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

    private boolean isCyclicUtil(Map<Object, TreeSet<Object>> graph, Object currentNode, List<Object> visitedList, Object parentNode) {
        visitedList.add(currentNode);

        TreeSet<Object> neighbours = graph.get(currentNode);

        for(Object eachNeighbour : neighbours) {
            if(!visitedList.contains(eachNeighbour)) {
                if(isCyclicUtil(graph, eachNeighbour, visitedList, currentNode)) {
                    return true;
                }
            }
            else if(eachNeighbour != parentNode) {
                return true;
            }
        }

        return false;
    }

    private boolean isCyclic(Map<Object, TreeSet<Object>> graph) {
        List<Object> visitedList = new ArrayList<>();

        for(Object key : graph.keySet()) {
            if(!visitedList.contains(key)) {
                if(isCyclicUtil(graph, key, visitedList, null)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        DetectCycleInUndirectedGraph detectCycleInUndirectedGraph = new DetectCycleInUndirectedGraph();
        Map<Object, TreeSet<Object>> graph = new HashMap<>();

        detectCycleInUndirectedGraph.addEdge(graph, 0, 1);
        detectCycleInUndirectedGraph.addEdge(graph, 1, 2);
        detectCycleInUndirectedGraph.addEdge(graph, 3, 4);
        detectCycleInUndirectedGraph.addEdge(graph, 4, 5);
        detectCycleInUndirectedGraph.addEdge(graph, 5, 2);

        boolean isCyclic = detectCycleInUndirectedGraph.isCyclic(graph);

        System.out.println("Has Cycle?: " + isCyclic);
    }
}
