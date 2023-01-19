import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

public class textSearch {
    public textSearch(){
        stringLength();
        characterCount();
    }


    public void stringLength(){
        File myFile = new File("words.txt");
        try{
            System.out.println("Longest string in file " + myFile);
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
            String[] wordsArr = new String[rows];
            for(int i=0; i < rows; i++ ){
                wordsArr[i]=myReader2.nextLine();
            }
            myReader2.close();

            List<String> wordsList = Arrays.asList(wordsArr);

            String longestWord = wordsList
                    .stream()
                    .max(Comparator.comparingInt(String::length))
                    .get();
            System.out.println("\nLongest word is: " + longestWord);
            System.out.println("=====================================");

        } catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }



    public void characterCount() {


        File myFile = new File("words.txt");
        try{
            System.out.println("Finding most frequent character in file " + myFile);
            Scanner myReader = new Scanner(myFile);
            String str = new String();

            str = "";

            while (myReader.hasNextLine()) {
                str = str + myReader.nextLine();
            }
            myReader.close();

            int charCount[] = new int[256];   // ASCII SIZE
            int len = str.length();
            for(int i=0; i<len; i++)
                charCount[str.charAt(i)]++;

            int max = -1;
            char result = ' ';

            for(int i=0; i<len; i++){
                if (max < charCount[str.charAt(i)]){
                    max = charCount[str.charAt(i)];
                    result = str.charAt(i);
                }
            }
            System.out.println("Max occurring character is: " + result);

        } catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }

}
