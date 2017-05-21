import java.time.LocalDateTime;

/**
 * Created by jarema on 5/21/17.
 */
public class VersionFactory {
    public static Version get(String text){
        return new Version(text,LocalDateTime.now());
    }
}
