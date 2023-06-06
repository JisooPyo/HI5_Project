package Hotel_Project;

import java.util.Scanner;

public class Guest {
    String name;
    String phoneNumber;
    int money;

    public Guest(){}

    public Guest( String name, String phoneNumber, int money ) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.money = money;
    }


    /////////////////////////// 호진님 구현부 /////////////////////////
    public Guest inputGuest() {
        // name, phoneNumber, money를 스캐너로 입력 받아 그 특성을 가지는 Guest를 return하세요.
        Scanner sc = new Scanner( System.in );
        System.out.println("예약하실 분의 성함을 입력해주세요.");
        String name = sc.nextLine();

        System.out.println("전화번호를 입력해주세요.");
        String phoneNumber = sc.nextLine();

        System.out.println("소지하고 계신 금액을 입력해주세요.");
        int money = sc.nextInt();

        System.out.println("예약하시려는 분의 정보를 확인해주세요.");
        System.out.println("이름" + ":" + name);
        System.out.println("전화번호" + ":" + phoneNumber);
        System.out.println("소지금" + ":" + money);
        System.out.println("확인하신 내용이 맞다면 1번, 다시 시도하시려면 2번을 입력해주세요.");
        int confirm = sc.nextInt();
        if (confirm==1){
            System.out.println("예약이 완료되었습니다.");
            Guest guest = new Guest( name, phoneNumber, money );
            return guest;
        } else if (confirm==2) {
            System.out.println("올바른 정보를 다시 입력해주세요.");
            return inputGuest();
        } else {
            System.out.println("잘못 입력하셨습니다. 메인화면으로 돌아갑니다.");
        }
        return null;
    }
}
