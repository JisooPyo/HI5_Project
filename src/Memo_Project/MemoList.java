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


//    public void printNote() {
//        System.out.println( "" );
//        Scanner scanner = new Scanner( System.in );
//        System.out.println( "메모의 번호를 입력해주세요." );
//        int selectedNumber = scanner.nextInt();
//        GetMemoList getMemoList = getMemoLists[selectedNumber];
//        if ( null == getMemoList ) {
//            System.out.println( "작성된 메모가 없습니다." );
//            System.out.println( "" );
//            return;
//        }
//    }
//
//    public void printAllNotes() {
//        System.out.println( "" );
//        if ( 0 == this.noteLength ) {
//            System.out.println( "메모가 존재하지 않습니다." );
//            System.out.println( "" );
//            return;
//        }
//        for ( int i = 0 ; i < this.noteLength ; i++ ) {
//            GetMemoList getMemoList = getMemoLists[i];
//
//            String headLine = String.format( "번호:%d 제목:%s 작성날짜:%s", i, getMemoList.getTitle(), getMemoList.getLastUpdatedDateTime() );
//            System.out.println( headLine );
//        }
//        System.out.println( "" );
//    }

}
