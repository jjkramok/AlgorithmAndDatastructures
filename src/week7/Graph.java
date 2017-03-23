package week7;

import week6.Queue;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Tim H on 22-3-2017.
 * Double.NaN is used for infinity
 */
public class Graph {
    private Set<Vertex> vertices;

    public Graph() {
        vertices = new HashSet<Vertex>();
    }

    public void addVertex(String label) {
        vertices.add(new Vertex(label));
    }
    public void addVertex(Vertex v) {
        vertices.add(v);
    }

    public void addEdge(String src, String dest, double cost) {
        Vertex s = getVertex(src);
        Vertex d = getVertex(dest);
        if (s == null) {
            System.err.println("src vertex does not exist");
            return;
        } else if (d == null) {
            System.err.println("dest vertex does not exist");
            return;
        }
        s.adj.add(new Edge(d, cost));
    }

    protected Vertex getVertex(String label) {
        for (Vertex v : vertices) {
            if (v.label.equals(label))
                return v;
        }
        return null;
    }

    public String toString() {
        String res = "";
        for (Vertex v : vertices)
            res += v.toString() + "\n";
        return res;
    }

    //Initializes a graph with complexity O(V,E) = V + E
    public void unweighted(String label) {
        Vertex s = getVertex(label);
        if (s == null) {
            System.err.println("Vertex (" + label + ") does not exist");
            return;
        }
        Queue<Vertex> q = new Queue<Vertex>();
        for (Vertex v : vertices) {
            v.dist = Double.MAX_VALUE;
            v.known = false;
        }
        s.dist = 0;
        q.enqueue(s);

        while (!q.isEmpty()) {
            Vertex v = q.dequeue();

            for (Edge e : v.adj) {
                Vertex w = e.dest;
                if (w.dist == Double.MAX_VALUE) {
                    w.dist = v.dist + 1;
                    w.prev = v;
                    q.enqueue(w);
                }
            }
        }
    }

    //Initializes a graph with complexity O(N) = N^2
    public void unweightedNSquared(String label) {
        Vertex s = getVertex(label);
        if (s == null) {
            System.err.println("Vertex ("+ label +") does not exist");
            return;
        }
        for (Vertex v : vertices) {
            v.dist = Double.MAX_VALUE;
            v.known = false;
        }
        s.dist = 0;

        for (int currDist = 0; currDist < vertices.size(); currDist++) {
            for (Vertex v : vertices) {
                if (!v.known && v.dist == currDist) {
                    v.known = true;
                    for (Edge e : v.adj) {
                        Vertex w = e.dest;
                        if (w.dist != Double.MAX_VALUE) {
                            w.dist = currDist + 1;
                            w.prev = v;
                        }
                    }
                }
            }
        }
    }

    //Initializes a graph
    public void dijkstra(String label) {
        Vertex v = findSmallestUnknownDistance();
        if (v == null) {
            System.err.println("Vertex ("+ label +") does not exist");
            return;
        }
        for (Vertex vv : vertices) {
            vv.dist = Double.MAX_VALUE;
            vv.known = false;
        }
        getVertex(label).dist = 0;
        getVertex(label).prev = null;

        while (v != null) {
            v.known = true;

            for (Edge e : v.adj) {
                Vertex w = e.dest;
                if (!w.known) {
                    if (v.dist + e.cost < w.dist) {
                        w.dist = v.dist + e.cost;
                        w.prev = v;
                    }
                }
            }
            v = findSmallestUnknownDistance();
        }
    }

    private Vertex findSmallestUnknownDistance() {
        double smallestDist = Double.MAX_VALUE;
        Vertex res = null;

        for (Vertex v : vertices) {
            if (!v.known && v.dist < smallestDist) {
                smallestDist = v.dist;
                res = v;
            }
        }
        return res;
    }

    public void printShortestPaths() {
        String res = "";
        Vertex v = null;
        for (Vertex vv : vertices) {
            if (vv.dist == 0)
                v = vv;
        }
        if (v ==  null)
            System.err.println("Vertex doesnt exist");

        for (Vertex vv : vertices) {
            res += vv.label;
            Vertex backtrack = vv.prev;
            while (backtrack != null) {
                res += " " + backtrack.label;
                backtrack = backtrack.prev;
            }
            res += "\n";
        }
        System.out.println(res);
    }

    public void printShortestPathsRecursive() {
        for (Vertex v : vertices) {
            printShortestPath(v);
            System.out.println();
        }
    }

    private void printShortestPath(Vertex v) {
        if (v != null) {
            printShortestPath(v.prev);
            System.out.print(v.label + " ");
        }
    }
}
