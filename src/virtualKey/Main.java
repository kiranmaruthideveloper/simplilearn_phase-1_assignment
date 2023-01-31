package virtualKey;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("========Welcome to========");
		System.out.println("========Virtual Key for Your Repositories========");
		System.out.println("Developed by : Kiran Maruthi Kuna, Andhra Pradesh India.");
		boolean terminator = true;
		while(terminator) {
			System.out.println("Select one from the below options..");
			System.out.println("1. Display all files in root directory in ascending order");
			System.out.println("2. Modify the files in the root directory");
			System.out.println("3. Exit");
			
			int t1 = sc.nextInt();

			switch(t1) {
				case 1:
					System.out.println("==========");
					displayFileNames();
					System.out.println("==========");
					break;
				case 2:
					System.out.println("==========");
					modifyFiles();
					System.out.println("==========");
					break;
				case 3:
					terminator = false;
					System.out.println("Thank You!, Please Visite Again");
					break;
				default:System.out.println("Invalid Option, Please try again");
			}
			
		}
		sc.close();

	}
	
	static void displayFileNames() {
		File path = new File("../phase1_assignment_java");
		
		if(path.isDirectory()) {
			System.out.println("----Directory Found, Displaying files from "+path.getAbsolutePath()+"----");
			File[] files = path.listFiles();
			Arrays.sort(files);
			for(File x:files) {
				System.out.println(x.getName());
			}
 		}else {
			System.out.println("Enter a valid directory");
		}
	}
	
	static void modifyFiles() {
		boolean terminator = true;
		
		while(terminator) {
			System.out.println("Please select the options given below..");
			System.out.println("1. Create new file");
			System.out.println("2. Delete a file");
			System.out.println("3. Search a file");
			System.out.println("4. Back to Main Menu");
			
			
			int t1 = sc.nextInt();
			
			switch(t1){
				case 1:
					System.out.println("==========");
					System.out.println("Create new files");
					createFile();
					System.out.println("==========");
					break;
				case 2:
					System.out.println("==========");
					System.out.println("Delete unwanted files");
					deleteFile();
					System.out.println("==========");
					break;
				case 3:
					System.out.println("==========");
					System.out.println("Search a required file");
					searchFile();
					System.out.println("==========");
					break;
				case 4:
					terminator = false;
					break;
				default: System.out.println("Invalid Option, Please try again");
			}
			
			
		}
		
	}
	
	static void createFile() {
		
		while(true) {
			System.out.println("Enter a new file name with file extenstion (q to exit): ");
			String fname = sc.next();
			if(fname.equals("q")) {
				break;
			}else {
				File newFile = new File(fname);
				
				try {
					if(newFile.createNewFile()) {
						System.out.println("File '"+newFile.getName()+"' Created Successfully ");
						break;
					}else {
						System.out.println("File already Exist : "+newFile.getName());
						System.out.println();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	
		}
	}
	
	static void deleteFile() {
			
			while(true) {
				System.out.println("Enter a file name with file extenstion (q to exit): ");
				String fname = sc.next();
				if(fname.equals("q")) {
					break;
				}else {
					File oldFile = new File(fname);
					
					if(oldFile.delete()) {
						System.out.println("File '"+oldFile.getName()+"' deleted Successfully ");
						break;
					}else {
						System.out.println("File not found/ failed to delete: "+oldFile.getName());
						System.out.println();
					}
				}
		
			}
		}
	
	static void searchFile() {
		
		while(true) {
			System.out.println("Enter a file name with file extenstion (q to exit): ");
			String fname = sc.next();
			if(fname.equals("q")) {
				break;
			}else {
				File path = new File("../phase1_assignment_java");
				MyFilenameFilter filter = new MyFilenameFilter(fname);
				String[] flist = path.list(filter);
				if (flist == null) {
		            System.out.println("Empty directory or directory does not exists.");
		        }
		        else {
		  
		            for (int i = 0; i < flist.length; i++) {
		                System.out.println(flist[i]+" found");
		            }
		            break;
		        }
			}
	
		}
	}

}

class MyFilenameFilter implements FilenameFilter {
    
    String initials;
    
    public MyFilenameFilter(String initials)
    {
        this.initials = initials;
    }
    
    public boolean accept(File dir, String name)
    {
        return name.startsWith(initials);
    }
}
