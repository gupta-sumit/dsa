package algo.graph;

public class GraphTest {

    public static void main(String[] args) {
        Graph graph = new Graph();
        Vertex bangalore = new Vertex("bangalore");
        Vertex pune = new Vertex("pune");
        Vertex nagpur = new Vertex("nagpur");
        Vertex delhi = new Vertex("delhi");
        Vertex mumbai = new Vertex("mumbai");
        Vertex hyderabad = new Vertex("hyderabad");


        graph.connectDirect(bangalore,nagpur,10);
        graph.connectDirect(bangalore,hyderabad,7);
        graph.connectDirect(bangalore,pune,15);
        graph.connectDirect(bangalore,mumbai,20);

        graph.connectDirect(nagpur,hyderabad,6);
        graph.connectDirect(nagpur,bangalore,15);
        graph.connectDirect(nagpur,delhi,20);


        graph.connectDirect(hyderabad,nagpur,9);
        graph.connectDirect(delhi,nagpur,10);
        graph.connectDirect(hyderabad,pune,6);
        graph.connectDirect(hyderabad,mumbai,5);
        graph.connectDirect(hyderabad,delhi,10);
        graph.connectDirect(hyderabad,bangalore,7);

        graph.connectDirect(pune,mumbai,2);

        graph.connectDirect(mumbai,delhi,9);
        graph.connectDirect(delhi,nagpur,10);

        Path path = graph.shortestPathDijkstra(pune, bangalore);

        Path normalPath = graph.path(bangalore, mumbai);

        System.out.println(path);

        System.out.println(normalPath);
    }
}
