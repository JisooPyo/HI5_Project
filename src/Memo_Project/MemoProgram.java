package Memo_Project;

import java.util.Scanner;

public class MemoProgram {
    Delete delete = new Delete();
    Amend amend = new Amend();

    Scanner sc = new Scanner( System.in );

    public void onMemo() {
        System.out.println("원하시는 옵션을 선택해 주세요.\n");
        System.out.println("1. 입력");
        System.out.println("2. 메모 목록 조회");
        System.out.println("3. 수정");
        System.out.println("4. 삭제");
        System.out.println("5. 종료");
        int n = sc.nextInt();
        switch ( n ){
            case 1:{

            }
            case 2:{

            }
            case 3:{
                amend.amend();
            }
            case 4:{
                delete();
            }
            case 5:{
                offMemo();
            }
            default:{
                System.out.println("잘못된 선택입니다. 다시 선택해 주세요.\n");
                onMemo();
            }

        }
    }



    public void delete() {
        delete.delete();
        onMemo();
    }

    public void offMemo(){
        System.out.println("메모장을 종료합니다.");
    }

}
