import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Set;


public class mailScanner {

    public mailScanner(){
       mailExtractor();
    }

    public void mailExtractor(){
        try{

        System.out.println("Scanning webpage to find e-mail addresses");
        URL website = new URL("https://www.ekeroik.se/start/?ID=342505");

        Scanner scan = new Scanner(website.openStream());
        StringBuffer content = new StringBuffer();

        while(scan.hasNext()) {
            content.append(scan.next());
        }
        String result = content.toString();

            Pattern pattern = Pattern.compile("([a-z0-9_.-]+)@([a-z0-9_.-]+[a-z])");
            Matcher matcher = pattern.matcher(result);

            FileWriter emailWriter = new FileWriter("email.txt", false);
            Set set = new HashSet();
            while(matcher.find()){
                //System.out.println(matcher.group());
                if(set.add(matcher.group())){
                    emailWriter.write(matcher.group() + "\n");
                }
            }
            System.out.println("=====================================");
            System.out.println("All emails has been written to file email.txt");


            emailWriter.close();

        } catch (IOException e) {
        System.out.println("No Ken do");
        e.printStackTrace();
    }
    }
}
