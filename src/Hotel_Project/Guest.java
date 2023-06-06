package Hotel_Project;

import java.util.Scanner;

public class Guest {
    String name;
    String date;
    String phoneNumber;
    int money;

    public Guest() {
    }

    public Guest( String name, String date, String phoneNumber, int money ) {
        this.name = name;
        this.date = date;
        this.phoneNumber = phoneNumber;
        this.money = money;
    }

    /////////////////////////// 호진님 구현부 /////////////////////////
    public Guest inputGuest() {
        // name, phoneNumber, money, date를 스캐너로 입력 받아 그 특성을 가지는 Guest를 return.
        Scanner sc = new Scanner( System.in );
        String name = sc.nextLine();
        String phoneNumber = sc.nextLine();
        String date = sc.nextLine();
        int money = sc.nextInt();
        Guest guest = new Guest( name, date, phoneNumber, money );
        return guest;
    }

}
