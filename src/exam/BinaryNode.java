package exam;

/**
 * Created by Tim H on 23/3/2017.
 */
public class BinaryNode<E> {
    private E element;
    private BinaryNode<E> left;
    private BinaryNode<E> right;

    public BinaryNode(E element, BinaryNode<E> left, BinaryNode<E> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        if (element != null) {
            System.out.print(element);
            System.out.print("\t");
        } else {
            System.out.print("(...)\t");
        }
        if (right != null) {
            right.printInOrder();
        }
    }

    public void printDepth(int depth) {
        printDepth(depth, 0);
        System.out.println();
    }

    public void printDepth(int printDepth, int currDepth) {
        if (currDepth != printDepth) {
            if (left != null)
                left.printDepth(printDepth, ++currDepth);
            if (right != null)
                right.printDepth(printDepth, ++currDepth);
        } else {
            System.out.print(element + " ");
        }
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public BinaryNode<E> getLeft() {
        return left;
    }

    public void setLeft(BinaryNode<E> left) {
        this.left = left;
    }

    public BinaryNode<E> getRight() {
        return right;
    }

    public void setRight(BinaryNode<E> right) {
        this.right = right;
    }
}
