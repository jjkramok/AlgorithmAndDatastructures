package week3;

import java.io.File;

/**
 * Created by Tim H on 17/2/2017.
 */
public class MyFile extends File {
    public MyFile(String name) { super(name); }

    public void listAll(int depth) {

        if(this.isDirectory()) {
            System.out.print(this.getName() + "  :  ");
            for(String entry : this.list()) {
                new MyFile(getPath() + separatorChar + entry).listAll(depth+1);
            }
        } else {
            System.out.print(this.getName() + "\n");
            for(int i=0; i<(depth); i++) System.out.print("\t");
        }
    }

    public static void main(String[] args) {
                new MyFile("c:\\program files\\Git").listAll(0);
    }
}