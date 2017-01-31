package week1;

/**
 * Created by Tim H on 31/1/2017.
 */
public class Opdract0 {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.addFront(3);
        list.addFront(2);
        list.addFront(1);
        list.append(4);
        System.out.println(list.toString());
    }
}
