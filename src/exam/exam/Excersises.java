package exam.exam;

import exam.BinaryNode;

/**
 * Created by Tim H on 29/3/2017.
 */
public class Excersises {
    public static void main(String[] args) {
        System.out.println("Ex. 1");
        Integer[] testArrayEven = {12, 15, 19, 24, 53, 56, 71, 100};
        Integer[] testArrayUneven = {12, 15, 19, 24, 53, 56, 71};
        SinglyLinkedList even = new SinglyLinkedList<Integer>();
        SinglyLinkedList uneven = new SinglyLinkedList<Integer>();
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
    }
}
