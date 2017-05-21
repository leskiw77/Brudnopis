import java.util.Scanner;

/**
 * Created by jarema on 5/21/17.
 */
public class TextEditor {
    Scanner scanner;
    public TextEditor() {
        scanner = new Scanner(System.in);
    }

    public String changeText(String currentText){
        System.out.println("Current text is: "+currentText);
        System.out.print("Enter new version name: ");
        return scanner.next();
    }
}
