package project;

import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class welcome {
    
    public static void main(String[] args) {
       //Scanner input = new Scanner(System.in);
        ArrayList<String> fileNames = new ArrayList<String>();

        fileNames.add("file3.txt");
        fileNames.add("file1.txt");
        fileNames.add("file2.txt");
        
        // Welcome Screen
        System.out.println("\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("***************************************\n");
        System.out.println("\tWelcome to LockedMe.com");
        System.out.println("\n***************************************");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");

        optionsSelection(fileNames);
    }

    public static void optionsSelection(ArrayList<String> fileNames) {
        // The details of the user interface options.
    	//input = null;
    	Scanner input = new Scanner(System.in);
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
        try {
            int input1 = input.nextInt();
            System.out.println("Thank you!!! You have selected option number " + input1);
            switch (input1) {
                // Display all the files
                case 1:
                    Collections.sort(fileNames);
                    for (String fileName : fileNames) {
                        System.out.println(fileName);
                    }
                    optionsSelection(fileNames);
                    break;
                case 2:
                    fileOperations(fileNames);
                    break;
                case 3:
                    input.close();
                    System.exit(0);
                default:
                    break;
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
            optionsSelection(fileNames);
        }
    }

    public static void fileOperations(ArrayList<String> fileNames) {
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
        Scanner input = new Scanner(System.in);
        try {
            int input1 = input.nextInt();

            switch (input1) {       		
                case 1:
                    addFileOperation(input, fileNames);
                    fileOperations(fileNames);
                    break;
                case 2:
                    delFileOperation(input, fileNames);
                    fileOperations(fileNames);
                    break;
                case 3:
                    searchFileOperation(input, fileNames);
                    fileOperations(fileNames);
                    break;
                case 4:
                    optionsSelection(fileNames);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
            fileOperations(fileNames);
        }
    }

    // Add a file
    private static void addFileOperation(Scanner input, ArrayList<String> fileNames) {
        System.out.println("Please enter the file name: ");
        try {
            String addFileName = input.next();

            if (!fileNames.contains(addFileName)) {
                fileNames.add(addFileName);
                System.out.println("The file " + addFileName + " has been added successfully");
            } else {
                System.out.println("The file " + addFileName + " is already found in the directory");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
            addFileOperation(input, fileNames);
        }
    }

    // Delete a file
    private static void delFileOperation(Scanner input, ArrayList<String> fileNames) {
        System.out.println("Please enter the file name: ");
        try {
            String delFileName = input.next();
            if (fileNames.contains(delFileName)) {
                fileNames.remove(delFileName);
                System.out.println("The file " + delFileName + " has been deleted successfully");
            } else {
                System.out.println("The file " + delFileName + " is not found in the directory");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
            delFileOperation(input, fileNames);
        }
    }

    // Search a file
    private static void searchFileOperation(Scanner input, ArrayList<String> fileNames) {
        System.out.println("Please enter the file name: ");
        try {
            String searchFileName = input.next();
            if (fileNames.contains(searchFileName)) {
                System.out.println("The file " + searchFileName + " is found");
            } else {
                System.out.println("The file " + searchFileName + " is not found");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
            searchFileOperation(input, fileNames);
        }
    }
}

