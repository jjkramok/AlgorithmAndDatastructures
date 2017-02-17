package week3;

import java.io.File;

/**
 * Created by Tim H on 17/2/2017.
 */
public class DirectorySizeCalculator {
    private String filepath;
    private File root;

    public DirectorySizeCalculator(String filepath) {
        this.root = new File(filepath);
        this.filepath = filepath;
    }

    public double calculateSize(String filepath) {
        File root = new File(filepath);
        return 0; //stub
    }

    public double calculateSize() {
        return 0; //stub
    }


}
