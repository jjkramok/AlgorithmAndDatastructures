package week3;

import java.io.File;

/**
 * Created by Tim H on 1-3-2017.
 */
public class FileTreeHeightCalculator extends File {
    public FileTreeHeightCalculator(String name) { super(name); }

    public int listAll() {return listAll(0);}

    //Returns heigest found depth
    public int listAll(int depth) {
        int maxDepth = -1;
        int tempDepth;

        //for(int i=0; i<depth; i++) System.out.print("\t");
        //System.out.println(getName());

        if(isDirectory()) {
            for (String entry : this.list()) {
                FileTreeHeightCalculator nextFile =
                        new FileTreeHeightCalculator(getPath() + separatorChar + entry);
                if ((tempDepth = nextFile.listAll(depth + 1)) > maxDepth) {
                    maxDepth = tempDepth;
                    System.out.println(maxDepth + "abc");
                }
            }
        } else {
            return depth; //returns depth of a file so that the parent node can make the max depth check for all its children
        }
        return maxDepth;
    }

    public static void main(String[] args) {
        FileTreeHeightCalculator d =
                new FileTreeHeightCalculator("c:\\program files\\Git");
        System.out.println(d.listAll());
    }
}
