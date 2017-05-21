import java.util.LinkedList;
import java.util.List;


public class StackHandler {
    LinkedList<Version> versionHistory;
    private LinkedList<Version> redoCache;
    private Logger logger;

    public StackHandler(Version initVersion) {
        versionHistory = new LinkedList<>();
        versionHistory.add(initVersion);
        redoCache = new LinkedList<>();
        logger = new Logger();
    }

    public void addVersion(Version current, Version newVersion){
        int pos = versionHistory.indexOf(current);
        for (Version v : versionHistory)
        if(pos == -1){
            throw new IllegalArgumentException("No such current version in version history");
        }
        versionHistory.add(pos+1,newVersion);
        logger.log(newVersion,current);
        for(int i = pos+2; i < versionHistory.size(); i++){
            versionHistory.remove(i);
        }
    }

    public Version getNext(Version current){
        int pos = versionHistory.indexOf(current);
        if(pos == -1){
            throw new IllegalArgumentException("No such current version in version history");
        }
        return versionHistory.get(pos+1);
    }

    public Version getLast(Version current){
        int pos = versionHistory.indexOf(current);
        if(pos == -1){
            throw new IllegalArgumentException("No such current version in version history");
        }
        return versionHistory.get(pos-1);
    }

}
