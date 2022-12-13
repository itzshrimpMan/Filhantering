import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FunFiles {
    //Attributes
    public FunFiles(){
        //findFiles();
        createFile();
        writeToFile();
        fileReader();
    }

    public void findFiles(){
        File myPath = new File("C:\\Users\\dohlvik.simon\\Documents");
        String[] allFiles = myPath.list();
        for(String fileNames: allFiles){
            System.out.println(fileNames);
        }
    }

    // Create a new file if the files doesn't exist
    public void createFile(){
        File myFile= new File("test.txt");
        try {
            if(myFile.createNewFile()){
                System.out.println("File has been created");
            }else{
                System.out.println("File already exist");
            }
        } catch(IOException e){
            System.out.println("No Ken do");
            e.printStackTrace();
        }
    }

    //Method to write data to file
    public void writeToFile(){
        try {
            FileWriter myWriter = new FileWriter("test.txt",true);
            myWriter.write("This is my file :)");
            myWriter.close();
            System.out.println("Data has been written!");

        }catch(IOException e) {
            System.out.println("You can't write in this file !");
            e.printStackTrace();
        }
        }

        //Read data from a file
    public void fileReader(){
        File myFile = new File("test.txt");
        try{
            Scanner myReader = new Scanner(myFile);
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch(FileNotFoundException e){
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }
    }

