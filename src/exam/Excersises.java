package exam;

import week7.*;

/**
 * Created by Tim H on 29/3/2017.
 */
public class Excersises {
    public static void main(String[] args) {
        Integer[] testArrayEven = {12, 15, 19, 24, 53, 56, 71, 100};
        Integer[] testArrayUneven = {12, 15, 19, 24, 53, 56, 71};
        exam.SinglyLinkedList even = new exam.SinglyLinkedList<Integer>();
        exam.SinglyLinkedList uneven = new exam.SinglyLinkedList<Integer>();
        even.addFront(100); even.addFront(71); even.addFront(56); even.addFront(53);
        even.addFront(24); even.addFront(19); even.addFront(15); even.addFront(12);
        System.out.println(even.toString());
        even.removeEven();
        uneven.addFront(71); uneven.addFront(56); uneven.addFront(53); uneven.addFront(24);
        uneven.addFront(19); uneven.addFront(15); uneven.addFront(12);
        System.out.println(uneven.toString());
        uneven.removeEven();
        System.out.println(even.toString());
        System.out.println(uneven.toString());
        System.out.println();

        System.out.println("Ex. 3");
        BinaryNode<Integer> two = new BinaryNode<Integer>(2, null, null);
        BinaryNode<Integer> zero = new BinaryNode<Integer>(0, null, null);
        BinaryNode<Integer> three = new BinaryNode<Integer>(2, null, null);
        BinaryNode<Integer> seven = new BinaryNode<Integer>(7, two, zero);
        BinaryNode<Integer> nine = new BinaryNode<Integer>(9, null, null);
        BinaryNode<Integer> four = new BinaryNode<Integer>(4, three, null);
        BinaryNode<Integer> fifthteen = new BinaryNode<Integer>(15, null, null);
        BinaryNode<Integer> eight = new BinaryNode<Integer>(8, seven, nine);
        BinaryNode<Integer> five = new BinaryNode<Integer>(5, four, fifthteen);
        exam.BinaryTree<Integer> binTree = new exam.BinaryTree<Integer>(6);
        binTree.getRoot().setLeft(eight); binTree.getRoot().setRight(five);
        binTree.printDepth(3);
        System.out.println();

        System.out.println("Ex. 4");
        double[] unsorted = ASimpleSortingAlgorithm.createUnsorted();
        for (int i = 0; i < unsorted.length; i++)
            System.out.print(unsorted[i] + " ");
        System.out.println();
        double[] sorted = ASimpleSortingAlgorithm.sort(unsorted);
        for (int i = 0; i < sorted.length; i++)
            System.out.print(sorted[i] + " ");
        System.out.println();
        double[] newsorted = {15.0};
        for (int i = 0; i < newsorted.length; i++)
            System.out.print(newsorted[i] + " ");
        System.out.println();
        System.out.println();

        System.out.println("Ex. 5");
        String s[] = {"1", "2", "3", "4", "5"};
        int a[][] = {
                {0, 1, 0, 0, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 0, 1},
                {0, 1, 0 ,1 ,0}
        };
        Graph g = new Graph(s, a);
        System.out.println(g.toString());
        System.out.println();
    }
}
