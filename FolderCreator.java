package project1;

import java.io.File;

public class FolderCreator {
	
	   	File folder;

		public void createFolder(String folderPath) {
	        File folder = new File(folderPath);
	        
	        if (!folder.exists()) { // Check if the folder already exists
	            if (folder.mkdirs()) {
	                System.out.println("Main Folder created successfully.");
	            } else {
	                System.out.println("Failed to create the folder.");
	            }
	        } else {
	            System.out.println("Working folder already exists.");
	        }
	    }
		
		
}
