package Memo_Project;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class List {
    //arrayList.addAll(Memo);
    Scanner sc = new Scanner(System.in);

    public void memoList(){
        ArrayList memoList = new ArrayList<String>();
        System.out.println(Memo.mapMemo);
    }


    public void memoSelect(){
        System.out.println("원하시는 메모의 번호를 입력해주세요.");
        int number = sc.nextInt();
    }

}
