import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Map<Integer, String> map= new HashMap<Integer, String>();
    static Scanner sc = new Scanner(System.in);

    public static void main( String[] args ) {

        MemoProgram memoProgram = new MemoProgram();
        memoProgram.onMemo();

    }
}