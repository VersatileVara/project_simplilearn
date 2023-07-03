package project1;

import java.io.File;
import java.util.Arrays;

public class DisplayAscOrder {
       String directoryPath = "C:\\Main"; // Specify the path of the directory  
       File directory = new File(directoryPath);
           
    public void exploreDirectory() {
        File[] files = directory.listFiles();
        
        if (files != null) {
            // Sort files in ascending order
            Arrays.sort(files);
            
            for (File file : files) {
                    System.out.println(file.getAbsolutePath());
                }
            }
    }
}
