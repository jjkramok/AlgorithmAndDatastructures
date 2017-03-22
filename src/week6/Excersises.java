package week6;

/**
 * Created by Tim H on 22-3-2017.
 */
public class Excersises {
    public static void main(String[] args) {
        Graph g = new Graph();
        Vertex v1 = new Vertex("v1"); g.addVertex(v1);
        Vertex v2 = new Vertex("v2"); g.addVertex(v2);
        Vertex v3 = new Vertex("v3"); g.addVertex(v3);
        Vertex v4 = new Vertex("v4"); g.addVertex(v4);
        Vertex v5 = new Vertex("v5"); g.addVertex(v5);
        Vertex v6 = new Vertex("v6"); g.addVertex(v6);
        Vertex v7 = new Vertex("v7"); g.addVertex(v7);
        v1.adj.add(new Edge(v2, 2));
        v1.adj.add(new Edge(v4, 1));
        v2.adj.add(new Edge(v4, 3));
        v2.adj.add(new Edge(v5, 10));
        v3.adj.add(new Edge(v1, 4));
        v3.adj.add(new Edge(v6, 5));
        v4.adj.add(new Edge(v3, 2));
        v4.adj.add(new Edge(v5, 2));
        v4.adj.add(new Edge(v6, 8));
        v4.adj.add(new Edge(v7, 4));
        v5.adj.add(new Edge(v7, 6));
        v7.adj.add(new Edge(v6, 1));
        g.unweighted("v1");
        //g.unweightedNSquared("v1");
        //g.dijkstra("v1");

        System.out.println("Q FIFO test");
        Queue<Integer> q = new Queue<Integer>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        while (!q.isEmpty()) {
            System.out.println(q.dequeue());
        }
        System.out.println();

        System.out.print(g.toString());
    }
}
