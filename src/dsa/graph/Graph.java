package algo.graph;

import java.util.*;
import java.util.function.Consumer;

public class Graph {

    Map<Vertex,List<Edge>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }


    public void connectDirect(Vertex v1, Vertex v2, int weight) {
        if(!adjacencyList.containsKey(v1)) {
            adjacencyList.put(v1,new LinkedList<>());
        }

        if(!adjacencyList.containsKey(v2)) {
            adjacencyList.put(v2,new LinkedList<>());
        }

        adjacencyList.get(v1).add(new Edge(v2,weight));
    }


    public void dfs(Consumer<Vertex> consumer) {
        Map<Vertex,Vertex> parentMap = new HashMap<>();
        for(Vertex v: adjacencyList.keySet()) {
            if(!parentMap.containsKey(v)) {
                parentMap.put(v,null);
                dfsVisit(v,consumer,parentMap);
            }
        }

    }

    private void dfsVisit(Vertex s, Consumer<Vertex> consumer, Map<Vertex,Vertex> parentMap) {
        if(s != null) {
            consumer.accept(s);
            for(Edge edge: adj(s)) {
                if(!parentMap.containsKey(edge.vertex)) {
                    parentMap.put(edge.vertex,s);
                    dfsVisit(edge.vertex,consumer,parentMap);
                }
            }
        }
    }

    private List<Edge> adj(Vertex v) {
        return adjacencyList.get(v);
    }



    public void bfs(Vertex source, Consumer<Vertex> consumer) {
        if(!hasVertex(source)) {
            throw new IllegalArgumentException("Vertex " + source + " not found in graph");
        }
        Map<Vertex,Integer> levelMap = new HashMap<>();
        Map<Vertex,Vertex> parentMap = new HashMap<>();
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(source);
        levelMap.put(source, 0);
        parentMap.put(source,null);
        while(!queue.isEmpty()) {
            Vertex v = queue.poll();
            consumer.accept(v);
            for(Edge edge : adj(v)) {
                if(!levelMap.containsKey(edge.vertex)) {
                    levelMap.put(edge.vertex, levelMap.get(v) + 1);
                    parentMap.put(edge.vertex,v);
                    queue.add(edge.vertex);
                }
            }
        }
    }

    public Path path(Vertex source, Vertex destination) {
        validate(source,destination);

        Map<Vertex,Integer> levelMap = new HashMap<>();
        Map<Vertex,Vertex> parentMap = new HashMap<>();
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(source);
        levelMap.put(source, 0);
        parentMap.put(source,null);
        while(!queue.isEmpty()) {
            Vertex v = queue.poll();
            for(Edge edge : adj(v)) {
                if(!levelMap.containsKey(edge.vertex)) {
                    levelMap.put(edge.vertex, levelMap.get(v) + 1);
                    parentMap.put(edge.vertex,v);
                    if(edge.vertex.equals(destination)) {
                        break;
                    }
                    queue.add(edge.vertex);
                }
            }
        }
        return createPath(parentMap, destination);

    }


    public void validate(Vertex source, Vertex destination) {
        if(!hasVertex(source)) {
            throw new IllegalArgumentException("Vertex " + source + " not found in graph");
        }

        if(!hasVertex(destination)) {
            throw new IllegalArgumentException("Vertex " + destination + " not found in graph");
        }
    }

    public Path shortestPathDijkstra(Vertex source, Vertex destination) {
        validate(source,destination);
        Map<Vertex,Vertex> parentMap = new HashMap<>();
        Set<Vertex> processed = new HashSet<>();
        algo.ds.PriorityQueue<VertexCost,Integer> queue = new algo.ds.PriorityQueue<>();
        parentMap.put(source,null);
        VertexCost sourceCost = new VertexCost(source,0);
        queue.add(sourceCost);
        Map<Vertex,VertexCost> costMap = new HashMap<>();
        costMap.put(source, sourceCost);
        for(Vertex vertex: adjacencyList.keySet()) {
            if(!vertex.equals(source)) {
                VertexCost cost = new VertexCost(vertex);
                queue.add(cost);
                costMap.put(vertex, cost);
            }
        }

        while(!queue.isEmpty()) {
            VertexCost v = queue.poll();
            if(v.equals(destination)) {
                break;
            }
            processed.add(v.vertex);
            for(Edge edge : adj(v.vertex)) {
                if(!processed.contains(edge.vertex)) {
                    VertexCost d = costMap.get(edge.vertex);
                    if(d.cost > v.cost + edge.cost) {
                        int cost = v.cost + edge.cost;
                        parentMap.put(edge.vertex,v.vertex);
                        queue.decreaseKey(d,cost);
                    }
                }
            }
        }
        System.out.println(costMap);
        return createPath(parentMap, destination);
    }


    public Path createPath(Map<Vertex,Vertex> parentMap, Vertex destination) {
        Path path = new Path();
        Vertex v = destination;
        while(true) {
            Vertex parent = parentMap.get(v);
            if(null == parent) {
                path.addFirst(v);
                break;
            } else {
                path.addFirst(v);
                v = parent;
            }

        }
        return path;
    }


    public boolean hasVertex(Vertex v) {
        return adjacencyList.containsKey(v);
    }



}

class Path {

    LinkedList<Vertex> vertexList;

    public Path() {
        vertexList = new LinkedList();
    }

    public void addLast(Vertex v) {
        this.vertexList.add(v);
    }

    public void addFirst(Vertex v) {
        this.vertexList.addFirst(v);
    }

    @Override
    public String toString() {
        return "Path{" +
                "vertexList=" + vertexList +
                '}';
    }
}


class Vertex {

    private final String label;

    public Vertex(String label) {
        Objects.requireNonNull(label);
        this.label = label;
    }

    public int hashCode() {
        return label.hashCode();
    }

    public boolean equals(Object other) {
        if(null == other) {
            return false;
        }
        if(!this.getClass().equals(other.getClass())) {
            return false;
        }
        Vertex o = (Vertex)other;
        return this.label.equals(o.label);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label='" + label + '\'' +
                '}';
    }
}

class Edge {

    Vertex vertex;
    int cost;

    public Edge(Vertex v, int w) {
        this.vertex = v;
        this.cost = w;
    }

}

class VertexCost implements algo.ds.PriorityQueue.PriorityQueueNode<Integer> {

    Vertex vertex;
    int cost = Integer.MAX_VALUE;

    public VertexCost(Vertex vertex) {
        this.vertex = vertex;
    }


    public VertexCost(Vertex vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    public int compareTo(algo.ds.PriorityQueue.PriorityQueueNode<Integer> other) {
        if(this.cost < other.getCost()) {
            return -1;
        }
        return this.cost == other.getCost() ? 0 : 1;
    }


    @Override
    public Integer getCost() {
        return cost;
    }

    @Override
    public void update(Integer cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VertexCost that = (VertexCost) o;
        return Objects.equals(vertex, that.vertex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertex);
    }

    @Override
    public String toString() {
        return "VertexCost{" +
                "vertex=" + vertex +
                ", cost=" + cost +
                '}';
    }
}

