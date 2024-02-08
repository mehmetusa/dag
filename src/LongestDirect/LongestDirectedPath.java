package LongestDirect;
import java.util.*;

public class LongestDirectedPath {

    public static int longestPathFromVertex(Vertex vertex, List<Edge> edges) {
        Map<Vertex, Integer> longestPath = new HashMap<>();

        for (Edge edge : edges) {
            longestPath.putIfAbsent(edge.from, 0); // Initialize longest path for each vertex to 0
            longestPath.putIfAbsent(edge.to, 0);
            longestPath.put(edge.to, Math.max(longestPath.get(edge.to), longestPath.get(edge.from) + 1)); // Update longest path for 'to' vertex
        }

        int maxPathLength = 0;
        for (int length : longestPath.values()) {
            maxPathLength = Math.max(maxPathLength, length); // Find the maximum path length
        }
        return maxPathLength;
    }

    public static void main(String[] args) {
        Vertex vertexA = new Vertex(1);
        Vertex vertexB = new Vertex(2);
        Vertex vertexC = new Vertex(3);
        Vertex vertexD = new Vertex(4);
        Vertex vertexE = new Vertex(5);
        

        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(vertexA, vertexB));
        edges.add(new Edge(vertexA, vertexC));
        edges.add(new Edge(vertexB, vertexD));
        edges.add(new Edge(vertexC, vertexD));
        edges.add(new Edge(vertexD, vertexE));

        int longestPathLength = longestPathFromVertex(vertexA, edges);
        System.out.println("Longest path length from vertex A: " + longestPathLength);  // Output: 3
    }
}