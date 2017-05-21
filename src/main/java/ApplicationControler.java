import java.util.Scanner;

/**
 * Created by jarema on 5/21/17.
 */
public class ApplicationControler {
    private Version currentVersion;

    private StackHandler stackHandler;
    private TextEditor textEditor;


    public ApplicationControler() {
        currentVersion = VersionFactory.get("   ");
        textEditor = new TextEditor();
        stackHandler = new StackHandler(currentVersion);
    }


    public void run(){
        System.out.println("Welcome to basic Notebook application");

        while (true) {
            System.out.println("1 - edit text");
            System.out.println("2 - undo changes");
            System.out.println("3 - redo changes");
            System.out.println("4 - simulate save every second");
            System.out.println("5 - exit");

            Scanner scanner = new Scanner(System.in);
            String choose = scanner.next();

            Version version;
            switch (choose) {
                case "1":
                    System.out.println(currentVersion.text);
                    version = VersionFactory.get(textEditor.changeText(currentVersion.text));
                    stackHandler.addVersion(currentVersion,version);
                    currentVersion = version;
                    break;
                case "2":
                    try {
                        version = stackHandler.getLast(currentVersion);
                        currentVersion = version;
                        System.out.println(version);
                    }catch (IndexOutOfBoundsException e){
                        System.out.println("Unable to get previous version");
                    }

                    break;
                case "3":
                    try {
                        version = stackHandler.getNext(currentVersion);
                        currentVersion = version;
                        System.out.println(version);
                    }catch(IndexOutOfBoundsException e){
                        System.out.println("Unable redo");
                    }
                    break;
                case "4":
                    version = VersionFactory.get(currentVersion.text);
                    stackHandler.addVersion(currentVersion,version);
                    break;
                case "5":
                    return;


                default:
                    System.out.println("Illegal argument passed\n");
            }
        }
    }
}
