package project1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Welcome {

	//public static final String folderPath = null;

	public static String folderPath;

	public static void main(String[] args) {
		
		 //Welcome message
		 System.out.println("\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
	     System.out.println("***************************************\n");
	     System.out.println("\tWelcome to LockedMe.com");
	     System.out.println("\n***************************************");
	     System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
	     
	     //Create a folder or check the folder exists
	     FolderCreator directory = new FolderCreator();
	     // Specify the path for the folder you want to create 
	     String folderPath = "C:\\Main"; 
	     directory.createFolder(folderPath);
	     
	     optionsSelection();
	}
	     
	  @SuppressWarnings("static-access")
	public static void optionsSelection() {
		  {
	    	    	String[] arr = {
	    	    			" 1. Display all the files",
	    	    			" 2. File operations",
	    	    			" 3. Exit"
	    	    	};
	    	    	
	 		System.out.println("These are the following features available: ");
	 		for (int i = 0; i < arr.length; i++) {
	 		    System.out.println(arr[i]);
	 		}
	 		// The user input to select one of the options listed.
	 		System.out.println("\nPlease select the option:");
	 		 try {// The details of the user interface options.
	 					Scanner input = new Scanner(System.in);
	 				    int input1 = input.nextInt();
	 					switch (input1) {
	 				case 1:
	 					    DisplayAscOrder display = new DisplayAscOrder ();
	 						//System.out.println("Thank you!!! You have selected option number " + input1);
	 						display.exploreDirectory();
	 						optionsSelection();
	 						break;
	 				case 2: 
	 						FileOperations();
	 						//optionsSelection();
	 						break;
	 				case 3:
	 						System.exit(0);
	 				default:
	 						System.out.println("Invalid Input");
	 						break;
	         				}
	 		 			}catch (Exception e) {
							System.out.println("Invalid input. Please try again.");
							}
	    	    }
	  		}
	   
	   public static void FileOperations(){
			String[] arr = {
		            " 1. Add a file",
		            " 2. Delete a file",
		            " 3. Search a file",
		            " 4. Back to the previous menu"
		        };
			
				System.out.println("\nPlease select the file operation");
					for (int i = 0; i < arr.length; i++) {
						System.out.println(arr[i]);
						}
					File directorypath = new File("C:\\Main");
					try {
						Scanner input = new Scanner(System.in); 
						int input1 = input.nextInt();
							switch (input1) {       		
								case 1:
									addFileOperation(directorypath);			
									break;
								case 2:
									delFileOperation(directorypath);										
									break;
								case 3:
									searchFileOperation(directorypath);
									break;
								case 4:
									optionsSelection();
									break;
								default:
									System.out.println("Invalid Input");
									break;
					      }} catch (Exception e) {
						System.out.println("Invalid input. Please try again.");
						}
					}
						public static void addFileOperation(File directorypath) {
							       try (Scanner filename = new Scanner(System.in)) {
									System.out.println("Please enter the file name: ");
									   String name = filename.nextLine();							   
									   if(directorypath.createNewFile())
									   {
										   System.out.println("File name already exists");
										   FileOperations();	
										   
									   }
									   else 
									   {
										   File newFile = new File(directorypath,name);
									       newFile.createNewFile();
									       System.out.println("File '" + name + "' added.");
									       FileOperations();										   
									   }
								} catch (IOException e) {
									e.printStackTrace();
								}
				       
						}			       
							
						public static void delFileOperation(File directorypath) {
						       try (Scanner filename = new Scanner(System.in)) {
								System.out.println("Please enter the deleting file name: ");
								   String name = filename.nextLine();	
								   File delfile = new File(directorypath,name);
								   System.out.println(delfile.getAbsolutePath() +  name);
								   if(delfile.exists())
								   {
									   delfile.delete();
									   System.out.println("File '" + name + "' deleted.");
									   FileOperations();										   
								   }
								   else 
								   {
								       System.out.println("File Not Found");
								       FileOperations();								   
								   }
						       }           	
							}
						
						public static void searchFileOperation(File directorypath) {
						       try (Scanner filename = new Scanner(System.in)) {
								System.out.println("Please enter the file name: ");
								   String name = filename.nextLine();	
								   File searchfile = new File(directorypath,name);
								   if(searchfile.exists())
								   {
									   System.out.println("File " + name + " is found in the following directory "+ directorypath.getAbsolutePath());
									   FileOperations();										   
								   }
								   else 
								   {
								       System.out.println("File Not Found in "+ directorypath.getAbsolutePath() +" directory");
								       FileOperations();								   
								   }
						       }           	
							}
}
	 
	  

	
