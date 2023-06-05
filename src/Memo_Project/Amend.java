import java.util.Scanner;

package Memo_Project;

public class Amend {
    public Amend(int number){
        if(number.isEmpty()){
            System.out.println("수정할 글이 존재하지 않습니다.");
        } else{
            System.out.println("수정 글 존재");
        }

public class Amend {
    Scanner sc = new Scanner(System.in);

    static Integer mNumber; // 수정할 메모의 번호

    String editMemo;

    String password;
    public Amend(){
        if(Memo.mapMemo.size() == 0){ //mapMemo 의 사이즈가 0일경우 데이터가 없으니 수정 할 내용이 없음
            System.out.println("수정할 메모가 존재하지 않는다.");
        }else{  // 데이터가 있을경우 데이터 조회 후 수정 할 메모 선택
            System.out.println("수정할 메모 존재");
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
            Memo.mapMemo.put(mNumber,editMemo);
            listMemo();
        }else{
            System.out.println("비밀먼호가 일치하지 않습니다.");
        }
    }

    public void listMemo(){    // 메모 조회
        for(Integer key : Memo.mapMemo.keySet()){  // 메모 조회
            String value = Memo.mapMemo.get(key);
            System.out.println(key + ". " + value );
        }
    }



}
