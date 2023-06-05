import java.util.Map;
import java.util.Scanner;

public class Delete {

    Scanner sc = new Scanner( System.in );
    public void delete() {
        int number = sc.nextInt();
        String enter = sc.nextLine();
        if ( !Memo.mapPassword.keySet().contains( number ) ) {
            notContain();
        } else {
            checkPassword(number);

        }
    }

    public void notContain(){
        System.out.println( "삭제할 글이 존재하지 않습니다." );
        System.out.println( "메인 화면으로 돌아가시려면 1번, 다시 번호를 입력하시려면 2번을 입력해 주세요." );
        int n = sc.nextInt();
        if(n==1){
        } else if(n==2){
            delete();
        } else {
            System.out.println("잘못 선택하셨습니다. 다시 선택해 주세요.\n");
            notContain();
        }
    }
    public void checkPassword(int number){
        String pw = sc.nextLine();
        System.out.println("비밀번호가 일치하지 않습니다.");
    }
}
