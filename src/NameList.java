import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.util.Arrays;

public class NameList {
    public NameList(){
        createNameFile();
        nameWriter();
        nameSorter();
    }
    public void createNameFile() {
        File myFile = new File("Namelist.txt");
        try {
            if (myFile.createNewFile()) {
                System.out.println("File has been created");
                System.out.println("=====================================");
            } else {
                System.out.println("File already exist");
                System.out.println("=====================================");
            }
        } catch (IOException e) {
            System.out.println("No Ken do");
            e.printStackTrace();
        }
    }
    public void nameWriter(){
        try{
            String content;
            FileWriter myWriter = new FileWriter("Namelist.txt", false);
            Scanner text = new Scanner(System.in);
            System.out.println("Enter a names you like to be written. Write QUIT to exit.");
            do {
                content = text.nextLine();
                if(!content.equals("QUIT")) {
                    myWriter.write(content + "\n");
                }
            } while(!content.equals("QUIT"));

            myWriter.close();
            System.out.println("Data has been written!");
        } catch (IOException e) {
            System.out.println("You can't write in this file !");
            e.printStackTrace();
        }
    }

    public void nameSorter(){
        File myFile = new File("Namelist.txt");
        try{
            System.out.println("=====================================");
            System.out.println("Names from file written in alphabetical order");
            Scanner myReader = new Scanner(myFile);
            //Looping through the file to count the number of rows
            int rows = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                rows = rows + 1;
            }
            myReader.close();

            //reading the names into an array
            Scanner myReader2 = new Scanner(myFile);
            String[] namesArr = new String[rows];
            for(int i=0; i < rows; i++ ){
                namesArr[i]=myReader2.nextLine();
            }
            myReader2.close();

            Arrays.sort(namesArr);
            for(int i=0; i < rows; i++ ){
                System.out.println(namesArr[i]);
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }
}
