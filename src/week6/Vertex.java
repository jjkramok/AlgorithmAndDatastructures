package week6;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Tim H on 22-3-2017.
 */
public class Vertex {
    public String label;
    public Set<Edge> adj;
    public Vertex prev;
    public double dist;
    public boolean known;

    public Vertex(String label) {
        this.label = label;
        adj = new HashSet<Edge>();
        prev = null;
    }

    public String toString() {
        String prevLabel = (prev == null) ? "none" : prev.label;
        String result = "Vertex: " + label + " prev: " + prevLabel + " dist: " +
                dist + " known: " + known + " {";
        for(Edge e : adj)
            result += e;
        return result + "}";
    }
}
