package week7;

/**
 * Created by Tim H on 23/3/2017.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("\nEx. 1");
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        sll.addFront(8);
        sll.addFront(0);
        sll.addFront(4);
        sll.addFront(3);
        sll.addFront(3);
        sll.addFront(1);
        sll.addFront(5);
        sll.addFront(3);
        sll.addFront(0);
        System.out.println(sll.toString());
        sll.addDuplicate(3);
        System.out.println(sll.toString());

        System.out.println("\nEx. 3");
        BinaryTree<Integer> bt = new BinaryTree<Integer>(1);
        BinaryNode<Integer> b7 = new BinaryNode<Integer>(7 , null, null);
        BinaryNode<Integer> b8 = new BinaryNode<Integer>(8 , null, null);
        BinaryNode<Integer> b4 = new BinaryNode<Integer>(4 , null, null);
        BinaryNode<Integer> b5 = new BinaryNode<Integer>(5 , b7, b8);
        BinaryNode<Integer> b6 = new BinaryNode<Integer>(6 , null, null);
        BinaryNode<Integer> b2 = new BinaryNode<Integer>(2 , b4, b5);
        BinaryNode<Integer> b3 = new BinaryNode<Integer>(3 , b6, null);
        bt.getRoot().setLeft(b2);
        bt.getRoot().setRight(b3);
        bt.printInOrder(); System.out.println();

        System.out.println("\nEx. 4");
        int[] test = {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        for (Integer i : test) {
            System.out.print(i + ", ");
        }
        System.out.println();
        System.out.println("swaps: " + GnomeSort.kabouter(test));
        for (Integer i : test) {
            System.out.print(i + ", ");
        }
        System.out.println();

        System.out.println("\nEx. 5");
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
        //g.unweighted("v1");
        //g.unweightedNSquared("v1");
        g.dijkstra("v1");
        //System.out.print(g.toString());
        g.printShortestPaths();

    }
}
