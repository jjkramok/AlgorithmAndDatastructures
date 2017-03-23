package week7;

/**
 * Created by Tim H on 23/3/2017.
 */
public class BinaryTree<E> {
    private BinaryNode<E> root;

    public BinaryTree(E rootItem) {
        this.root = new BinaryNode(rootItem, null, null);
    }

    public BinaryNode<E> getRoot() {return this.root;}

    public void printInOrder() {
        this.root.printInOrder();
    }
}
