import javax.naming.Name;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Command Options: ");
        System.out.println("a: Fun files");
        System.out.println("b: Name list");
        System.out.println("c: Search text");
        System.out.println("d: Mail scanner");
        System.out.println("?: Display");
        System.out.println("q: Quit");

        String choise = null;
        Scanner scan = new Scanner(System.in);
        do{
            choise = scan.nextLine();
            switch (choise){
                case "a":
                    new FunFiles();
                    break;
                case "b":
                    new NameList();
                    break;
                case "c":
                    new textSearch();
                    break;
                case "d":
                    new mailScanner();
                    break;
                case "?":
                    System.out.println("Command Options: ");
                    System.out.println("a: Fun Files");
                    System.out.println("b: Name List");
                    System.out.println("c: Search text");
                    System.out.println("d: Mail scanner");
                    System.out.println("?: Display");
                    System.out.println("q: Quit");
                    break;
            }
        } while (!choise.equals("q"));

    }


}