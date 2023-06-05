package Memo_Project;

import java.time.ZonedDateTime;
import java.util.Scanner;

public class Input {
    private int number = 1;
    Scanner sc = new Scanner( System.in );

    public Memo input() {
        System.out.println( "이름, 비밀번호, 메모를 입력해 주세요." );
        String name = sc.nextLine();
        String password = sc.nextLine();
        String note = sc.nextLine();
        checkInput( name, password, note );
        String date = ZonedDateTime.now().toString();
        Memo memo = new Memo( number, name, password, note, date );
        number++;
        return memo;
    }

    public void checkInput( String name, String password, String note ) {
        System.out.println( "이름 : " + name );
        System.out.println( "비밀번호 : " + password );
        System.out.println( "메모 : " + note );
        System.out.println( "입력값이 올바르면 1번, 다시 입력하시려면 2번을 입력해 주세요." );
        int n = sc.nextInt();
        String enter = sc.nextLine();
        if ( n == 1 ) {

        } else if ( n == 2 ) {
            input();
        } else {
            System.out.println( "잘못된 값을 입력하셨습니다. 다시 입력해 주세요." );
            checkInput( name, password, note );
        }
    }

}
