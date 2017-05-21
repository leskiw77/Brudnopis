import java.time.LocalDateTime;

/**
 * Created by jarema on 5/21/17.
 */
public class Version {
    public final String text;
    public final LocalDateTime date;

    public Version(String text,LocalDateTime date) {
        this.text = text;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Version version = (Version) o;

        if (text != null ? !text.equals(version.text) : version.text != null) return false;
        return date != null ? date.equals(version.date) : version.date == null;
    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString(){
        return "date: " +this.date + "\ntext: " + this.text;
    }
}
