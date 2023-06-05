package Memo_Project;

<<<<<<< HEAD
import java.util.Scanner;
public class Input { //Complexity is 3 Everything is cool!

        int number = 1;

       public Memo input(){
           Scanner sc = new Scanner(System.in);
           System.out.println("이름, 비밀번호, 메모를 입력해 주세요.");
           String name = sc.nextLine();
           String password = sc.nextLine();
           String note = sc.nextLine();
           String date = "20230606";
           Memo memo = new Memo(number,name,password,note,date);
           number++;
           return memo;
    }
=======
import java.time.ZonedDateTime;
import java.util.Scanner;

public class Input {
    private int number = 1;

    Scanner sc = new Scanner( System.in );

    public Memo input() {
        System.out.println( "이름, 비밀번호를 입력해 주세요." );
        String name = sc.nextLine();
        String password = sc.nextLine();
        checkNamePassword( name, password );
        System.out.println( "메모를 입력해 주세요." );
        String note = sc.nextLine();
//        inputnote = checkNote( note );
        String date = ZonedDateTime.now().toString();
        Memo memo = new Memo( number, name, password, note, date );
        number++;
        System.out.println( "메모 입력을 완료하였습니다!" );
        return memo;
    }

    public void checkNamePassword( String name, String password ) {
        System.out.println( "이름 : " + name );
        System.out.println( "비밀번호 : " + password );
        System.out.println( "입력값이 올바르면 1번, 다시 입력하시려면 2번을 입력해 주세요." );
        int n = sc.nextInt();
        String enter = sc.nextLine();
        if ( n == 1 ) {
        } else if ( n == 2 ) {
            input();
        } else {
            System.out.println( "잘못된 값을 입력하셨습니다. 다시 입력해 주세요." );
            checkNamePassword( name, password );
        }
    }

//    public String checkNote( String note ) {
//        System.out.println( "메모를 확인해 주세요." );
//        System.out.println( note );
//        System.out.println( "메모를 저장하시려면 1번, 메모를 다시 쓰려면 2번을 눌러 주세요." );
//        int n = sc.nextInt();
//        String enter = sc.nextLine();
//        if ( n == 1 ) {
//            return note;
//        } else if ( n == 2 ) {
//            return checkNote( note );
//        } else {
//            System.out.println( "잘못된 값을 입력하였습니다. " );
//            return checkNote( note );
//        }
//
//    }

    public void checkNote( String note ) {

    }


>>>>>>> master
}
