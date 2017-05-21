/**
 * Created by jarema on 5/21/17.
 */
public class Logger {

    private MyFileWritter fileWritter;

    public Logger() {
        this.fileWritter = new MyFileWritter("Log.txt");
    }

    public void log(Version newVersion, Version oldVersion){
        fileWritter.appendMessage("\nOld version was: "+oldVersion.text+" New version is:"+newVersion.text );
    }
}
