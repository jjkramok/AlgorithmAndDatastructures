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

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.print();

        String postfixInput = "5 1 2 + 4 * + 3 -";
        Calculator tor = new Calculator(postfixInput);
        System.out.print("Calculating postfix: ");
        System.out.println(tor.calculatePostfix());
    }
}
