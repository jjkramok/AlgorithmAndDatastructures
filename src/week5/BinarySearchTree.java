package week5;

/**
 * Created by Tim H on 9/3/2017.
 */
public class BinarySearchTree<E extends Comparable<? super E>> {
    private BinaryNode<E> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(BinaryNode<E> node) {
        if (this.root == null)
            this.root = node;
        BinaryNode currNode = root;
        while(true) {
            if (this.root.getElement().compareTo(node.getElement()) < 0) {
                //Lower than
                if (currNode.getLeft() != null) {
                    currNode = currNode.getLeft();
                } else {
                    currNode.setLeft(node);
                    break;
                }
            } else {
                //Greater or equal
                if (currNode.getRight() != null) {
                    currNode = currNode.getRight();
                } else {
                    currNode.setRight(node);
                    break;
                }
            }
        }
    }



    public void printInOrder() {
        if (this.root != null)
            printInOrder(this.root);
    }

    private void printInOrder(BinaryNode node) {
        if (node != null) {
            printInOrder(node.getLeft());
            System.out.println(node.getElement().toString());
            printInOrder(node.getRight());
        }
    }

    private class BinaryNode<E> {
        private E item;
        private BinaryNode left;
        private BinaryNode right;

        private BinaryNode(E item) {
            this.item = item;
        }

        public E getElement() {
            return item;
        }

        public void setElement(E item) {
            this.item = item;
        }

        public BinaryNode getLeft() {
            return left;
        }

        public void setLeft(BinaryNode left) {
            this.left = left;
        }

        public BinaryNode getRight() {
            return right;
        }

        public void setRight(BinaryNode right) {
            this.right = right;
        }
    }
}
