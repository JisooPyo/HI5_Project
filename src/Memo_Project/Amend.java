package Memo_Project;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class Amend {
    Scanner sc = new Scanner(System.in);
    static Integer mNumber; // 수정할 메모의 번호
    String editMemo;
    String password;

//    SimpleDateFormat date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 날짜 시간 형식 포맷

    //현재 날짜 구하기
    LocalDate now = LocalDate.now();
    //현재 시간 구하기
    LocalDateTime nowTime = LocalDateTime.now();

   DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

   DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:SS");

   // 포맷 적용
   String date = now.format(dateFormatter);
   String time = nowTime.format(timeFormatter);

//    Date now = new Date();  // 현재 시간을 구할 수 있다.

//    String date = date1.format(now); //현재 시간을 구해서 날짜 시간 패턴에 맞추기

    public void amend(){

        if( Memo.mapMemo.size() == 0){ //mapMemo 의 사이즈가 0일경우 데이터가 없으니 수정 할 내용이 없음
            System.out.println("수정할 메모가 존재하지 않는다.");
        }else{  // 데이터가 있을경우 데이터 조회 후 수정 할 메모 선택
//            System.out.println("수정할 메모 존재");
            listMemo();
//            for(Integer key : Memo.mapMemo.keySet()){  // 메모 조회
//                String value = Memo.mapMemo.get(key);
//                System.out.println(key + ". " + value );
//            }
            System.out.print("수정할 메모 선택 : ");
            mNumber = sc.nextInt();
            chkPassword(mNumber);  //비밀번호만 입력 했는데 비밀 번호 확인 문구과 자동으로 패스워드 공백이 들어감 이유는???

        }
    }

    public void chkPassword(int mNumber){
        System.out.print("비밀번호를 입력하세요 : ");
//        password = sc.nextLine();  //
        password = sc.next();
//        System.out.println(password);
//        System.out.println(Memo.mapPassword.get(mNumber));

        if(password.equals(Memo.mapPassword.get(mNumber))) {
            System.out.print("수정 할 내용을 입력하세요 : ");
            sc.nextLine(); // 개행 문자 제거
            editMemo = sc.nextLine();


            // 메모 자체를 불러와서 memo.set으로 note set하고 나서 put value에는 Memo타입의 객체를 넣어야 합니다..!\
            String name = Memo.mapMemo.get(mNumber).name;
            String note = "";
            Memo memo = new Memo(mNumber,name,password,note, date);
            memo.setNote(editMemo);
            memo.MapMemo(mNumber,memo);

//            Memo.mapMemo.put(mNumber,editMemo);
            listMemo();
        }else{
            System.out.println("비밀먼호가 일치하지 않습니다.");
            amend();
        }
    }

    public void listMemo(){    // 메모 조회
//        for(Integer key : Memo.mapMemo.keySet()){  // 메모 조회
//            Memo memo = Memo.mapMemo.get(key);
//            System.out.println(key + ". " + memo.note + ", 수정 시간 : "+ memo.date + time);
//        }
        Integer maxkey = Collections.max(Memo.mapMemo.keySet());  // key값의 맥스를 구하기 위해
        for(int i = 1; i <= maxkey; i++){
            System.out.println(i + ". " + Memo.mapMemo.get(i).note + ", 수정 시간 : " + Memo.mapMemo.get(i).date + " " + time);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("오늘 날짜 : " + date + " 지금 시간 : " + time);


    }



}
