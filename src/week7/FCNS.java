package week7;

/**
 * Created by Tim H on 1-3-2017.
 */
public class FCNS<E> {
    E data;
    FCNS firstChild;
    FCNS nextSibling;

    public FCNS() {}

    public FCNS(E data) {
        this.data = data;
    }

    public FCNS(E data, FCNS child, FCNS sibling) {
        this.data = data;
        this.firstChild = child;
        this.nextSibling = sibling;
    }

    public void printPreOrder() {
        if (data != null) {
            System.out.print(data);
            System.out.print("\t");
        } else {
            System.out.print("(...)\t");
        }
        if (firstChild != null)
            firstChild.printPreOrder();
        if (nextSibling != null) {
            System.out.println("\n");
            nextSibling.printPreOrder();
        }
    }

    //Inorder: Left, Self, Right
    public void printInOrder() {
        if (firstChild != null) {
            firstChild.printInOrder();
        }
        if (data != null) {
            System.out.print(data);
            System.out.print("\t");
        } else {
            System.out.print("(...)\t");
        }
        if (nextSibling != null) {
            nextSibling.printInOrder();
        }
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public FCNS getFirstChild() {
        return firstChild;
    }

    public void setFirstChild(FCNS firstChild) {
        this.firstChild = firstChild;
    }

    public FCNS getNextSibling() {
        return nextSibling;
    }

    public void setNextSibling(FCNS nextSibling) {
        this.nextSibling = nextSibling;
    }
}
