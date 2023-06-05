import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Map<Integer, String> map= new HashMap<Integer, String>();
    static Scanner sc = new Scanner(System.in);

    public static void main( String[] args ) {
//        System.out.println(map.keySet()); // 키 값 확인
        System.out.print("수정할 글 번호를 입력하세요 :" );
        int number = sc.nextInt();


         Amend amend = new Amend(number);

    }
}