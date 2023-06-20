
package project;

import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Collection;

public class welcome {
	
	public static void main(String[] args) {
		final Scanner input = new Scanner(System.in);
		ArrayList<String> fileNames =new ArrayList<String>();
		
        fileNames.add("file3.txt");
        fileNames.add("file1.txt");
        fileNames.add("file2.txt");	
		//Welcome Screen
		System.out.println("\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*"); 
		System.out.println("***************************************\n");
		System.out.println("\tWelcome to LockedMe.com");
		System.out.println("\n***************************************");
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n"); 
		
		optionsSelection(input,fileNames);
        
	}
	
	 public static void optionsSelection(Scanner input,ArrayList<String> fileNames) {
		 // The details of the user interface options.
	        String[] arr = {" 1. Display all the files",
	        		" 2. File operations",
	        		" 3. Back to previous menu"
	        };
	        System.out.println("These are the following features available: ");
	        for(int i=0;i<arr.length;i++) {
	        System.out.println(arr[i]);
	        }
	        //The user input to select one of the options listed.
	        System.out.println("\n Please select the option:");
			int input1 = input.nextInt();
			System.out.println ("Thank you!!! You have selected the option number "+ input1);
			  switch (input1){
				//Display all the files
		        	case 1:
		        		Collections.sort(fileNames);  
		        			for (String fileName : fileNames) {
		        				System.out.println(fileName);
		        				}
		        			optionsSelection(input,fileNames);
		        	case 2:
		        		fileOperations(input,fileNames);
		        		break;
		        	case 3:
		        		input.close();
		        		System.exit(0);
		        	default:
		        		break;         	
		        }
		     }
	
	 public static void fileOperations(Scanner input, ArrayList<String> fileNames) {
		 String[] arr = {" 1. Add a file",
	        		" 2. Delete a file",
	        		" 3. Search a file",
	        		" 4. Back to previous menu"
	        };
		 	System.out.println("\n"+"Please select the file operation");
	        for(int i=0;i<arr.length;i++) {
	        System.out.println(arr[i]);
	        }
	 		int input1 = input.nextInt();

				switch(input1) {
					case 1: 
						addFileOperation(input,fileNames);
						fileOperations(input,fileNames);
						
					case 2:
						delFileOperation(input,fileNames);
						fileOperations(input,fileNames);
					case 3:
						searchFileOperation(input,fileNames);
						fileOperations(input,fileNames);
					case 4:
					optionsSelection(input,fileNames);
					default:
						break;
				}
				}
						
				 //Add a file
				private static void addFileOperation(Scanner input,ArrayList<String> filename)	{
							
				System.out.println("Please enter the file name: ");
				String addfilename = input.next();
				
				if(!filename.contains(addfilename)) {
					filename.add(addfilename);
					System.out.println( "The file "+addfilename+" has been added successfully" );
								}			
				else {
					System.out.println( "The file "+addfilename+" is already found in the directory " );	
				}		
					}
				
				//Delete a file
				private static void delFileOperation(Scanner input,ArrayList<String> filename)	{
					
					System.out.println("Please enter the file name: ");
					String delfilename = input.next();
					if(filename.contains(delfilename)) {
						System.out.println( "The file "+delfilename+" has been deleted successfully" );
									}			
					else {
						System.out.println( "The file "+delfilename+" is not found in the directory " );	
					}		
						}
			
				//Search a file
				private static void searchFileOperation(Scanner input,ArrayList<String> filename)	{
					
					System.out.println("Please enter the file name: ");
					String searchfilename = input.next();
					if(filename.contains(searchfilename)) {
					System.out.println( "The file "+searchfilename+" is found" );
					}
					else {
					System.out.println( "The file "+searchfilename+" is not found" );	
					
					}
}
				}