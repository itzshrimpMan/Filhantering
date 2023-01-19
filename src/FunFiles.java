import java.io.*;
import java.util.Objects;
import java.util.Scanner;
import java.util.Arrays;
import java.util.logging.Filter;

public class FunFiles {
    //Attributes
    public FunFiles() {
        testFiles();
        findFiles();
        createFile();
        writeToFile();
        fileReader();

    }
    public void testFiles() {
        File myPath = new File("test.txt");
        boolean reading = myPath.canRead();
        System.out.println("=====================================");
        System.out.println("Checking file "+myPath+" for read and write");
        System.out.println("The file can be read: " + reading);

        boolean writing = myPath.canWrite();
        System.out.println("The file can be written: " + writing + "\n");
    }

    public class FilterFile implements FilenameFilter{
        @Override
        public boolean accept(File directory, String fileName){
            if(fileName.endsWith(".txt")){
                return true;
            }
            return false;
        }
    }
    public void findFiles() {
        File myPath = new File("C:\\Programmering 2\\Filer");

        //Listar alla filer i ett bibliotek
        System.out.println("=====================================");
        System.out.println("Listing all the files in directory " + myPath);
        String[] allFiles = myPath.list();
        for (String fileNames : allFiles) {
            System.out.println(fileNames);
        }


        //Listar alla filer som har .txt
        System.out.println("=====================================");
        System.out.println("Listing all the files ending in .txt in directory " + myPath);
        FilenameFilter filter = new FilterFile();
        File[] files = myPath.listFiles(filter);
        for(File f : files)
            System.out.println(f.getName());
    }

    // Create a new file if the files doesn't exist
    public void createFile() {
        File myFile = new File("test.txt");
        try {
            if (myFile.createNewFile()) {
                System.out.println("File has been created");
            } else {
                System.out.println("File already exist");
            }
        } catch (IOException e) {
            System.out.println("No Ken do");
            e.printStackTrace();
        }
    }

    //Method to write data to file
    public void writeToFile() {
        try {
            boolean overWrite;
            Scanner skriva = new Scanner(System.in);
            System.out.println("=====================================");
            System.out.println("Writing text to test.txt");
            System.out.println("Do you want to overwrite (Y/N)? ");
            String selection = skriva.next();
            if (selection.equals("y")){
                overWrite = false;
            } else if( selection.equals("n")){
                overWrite = true;
            }else {
                System.out.println("Not valid selection. The file will be appended.");
                overWrite = true;
            }
            FileWriter myWriter = new FileWriter("test.txt", overWrite);
            Scanner text = new Scanner(System.in);
            System.out.println("Enter a text you like to be written");
            String content = text.nextLine();
            myWriter.write(content + "\n");

            myWriter.close();
            System.out.println("Data has been written!");

        } catch (IOException e) {
            System.out.println("You can't write in this file !");
            e.printStackTrace();
        }
    }

    //Read data from a file
    public void fileReader() {
        File myFile = new File("test.txt");
        try {
            System.out.println("=====================================");
            System.out.println("This file " +myFile + " contains this information: ");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }



}
