package week3;

/**
 * Created by Tim H on 1-3-2017.
 */
public class Expression {
    private Expression left;
    private Expression right;
    private char operator;
    private double operand;
    private boolean isOperatorNode = false;

    public Expression(char operator) {
        this.operator = operator;
        this.isOperatorNode = true;
    }

    public Expression(double operand) {
        this.operand = operand;
    }

    public static Expression testExpression() {
        //Second tree of ex 5
        Expression e1 = new Expression(7.0);
        Expression e2 = new Expression(5.0);
        Expression e3 = new Expression(4.0);
        Expression e4 = new Expression(6.0);
        Expression e5 = new Expression('-');
        Expression e6 = new Expression('+');
        Expression root = new Expression('/');
        root.setLeft(e5); root.setRight(e6);
        e6.setLeft(e3); e6.setRight(e4);
        e5.setLeft(e1); e5.setRight(e2);
        return root;
    }

    public static void printPreFix(Expression e) {
        if (e.isOperatorNode)
            System.out.print(e.getOperator() + " ");
        else
            System.out.print(e.getOperand() + " ");
        if (e.getLeft() != null)
            printPreFix(e.getLeft());
        if (e.getRight() != null)
            printPreFix(e.getRight());
    }

    public static void printPostFix(Expression e) {
        if (e.getLeft() != null)
            printPostFix(e.getLeft());
        if (e.getRight() != null)
            printPostFix(e.getRight());
        if (e.isOperatorNode)
            System.out.print(e.getOperator() + " ");
        else
            System.out.print(e.getOperand() + " ");
    }

    public Expression getLeft() {
        return left;
    }

    public void setLeft(Expression left) {
        this.left = left;
    }

    public Expression getRight() {
        return right;
    }

    public void setRight(Expression right) {
        this.right = right;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public double getOperand() {
        return operand;
    }

    public void setOperand(double operand) {
        this.operand = operand;
    }

    public boolean isOperatorNode() {
        return isOperatorNode;
    }

    public void setOperatorNode(boolean operatorNode) {
        isOperatorNode = operatorNode;
    }
}
