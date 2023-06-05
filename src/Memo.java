import java.util.HashMap;
import java.util.Map;

public class Memo {
    int number;
    String name;
    String password;
    String note;
    String date;
    static Map< Integer, String > mapPassword = new HashMap<>();
    static Map< Integer, Memo > mapMemo = new HashMap<>();

    public Memo( int number, String name, String password, String note, String date ) {
        this.number = number;
        this.name = name;
        this.password = password;
        this.note = note;
        this.date = date;
    }

    public void MapPassword( int number, String password ) {
        mapPassword.put( number, password );
    }

    public void MapMemo( int number, Memo memo ) {
        mapMemo.put( number, memo );
    }

    public void setName( String name ) {
        this.name = name;
    }

    public void setNote( String note ) {
        this.note = note;
    }
}
