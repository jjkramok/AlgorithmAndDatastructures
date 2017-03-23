package week7;

/**
 * Created by Tim H on 22-3-2017.
 */
public class Edge {
    public Vertex dest;
    public double cost;

    public Edge(Vertex dest, double cost) {
        this.dest = dest;
        this.cost = cost;
    }

    public String toString() {
        return "{c = " + cost + ", d = " + dest.label + "} ";
    }
}
