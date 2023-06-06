package Memo_Project;

import java.util.Map;
import java.util.Scanner;

public class MemoList {

    public void save( Memo memo ) {
        Memo.mapMemo.put( memo.number, memo );
        Memo.mapPassword.put( memo.number, memo.password );
    }

    public void getMemoList() {
        if ( Memo.mapMemo.size() == 0 ) {
            System.out.println( "출력할 메모가 없습니다." );
        } else {
            int maxNum = maxNum(Memo.mapMemo);
            for ( int i = 1 ; i <= maxNum ; i++ ) {
                if ( Memo.mapMemo.keySet().contains( i ) ) {
                    int number = Memo.mapMemo.get( i ).number;
                    String name = Memo.mapMemo.get( i ).name;
                    String date = Memo.mapMemo.get( i ).date;
                    String note = Memo.mapMemo.get( i ).note;
                    System.out.println( number + " : " + name );
                    System.out.println( "date : " + date );
                    System.out.println( "note :" );
                    System.out.println( note );
                }
            }
        }
    }

    public int maxNum ( Map<Integer,Memo> mapMemo ) {
        int maxNum=0;
        for(Integer integer : mapMemo.keySet()) {
            maxNum=Math.max(integer.intValue(), maxNum);
        }
        return maxNum;
    }
}
