package week3;

/**
 * Created by Tim H on 17/2/2017.
 * Excersise 1: see MyFile
 * Excersise 2: see FileTreeHeightCalculator
 * Excersise 3: see java.io.File.getTotalSpace, 'uitdaging' not done
 * Excersise 4: see FCNS
 * Excersise 5: no excersise / empty?
 * Excersise 6:
 */
public class Excersises {

    public static void main(String args[]) {
        //Ex 3
        DirectorySizeCalculator d = new DirectorySizeCalculator();
        System.out.println(d.calculateSize("c:\\program files\\Git") + " bytes");

        //Ex 4
        FCNS<Integer> seventh = new FCNS<Integer>(7, null, null );
        FCNS<Integer> sixth = new FCNS<Integer>(6, seventh, null);
        FCNS<Integer> fifth = new FCNS<Integer>(5, null, null);
        FCNS<Integer> fourth = new FCNS<Integer>(4, fifth, sixth);
        FCNS<Integer> third = new FCNS<Integer>(3, fourth, null);
        FCNS<Integer> second = new FCNS<Integer>(2, null, third);
        FCNS<Integer> first = new FCNS<Integer>(1, second, null);
        first.printPreOrder();

        //Ex 6
        Expression testTreeRoot = Expression.testExpression();
        System.out.println("\n" + "prefix:");
        Expression.printPreFix(testTreeRoot);
        System.out.println("\n" + "postfix:");
        Expression.printPostFix(testTreeRoot);
        System.out.println();
    }
}
