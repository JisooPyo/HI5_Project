package Hotel_Project;

import java.util.Scanner;

public class Guest {
    String name;
    String phoneNumber;
    int money;

    public Guest( String name, String phoneNumber, int money ) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.money = money;
    }

    public Guest inputGuest() {
        Scanner sc = new Scanner( System.in );
        String name = sc.nextLine();
        String phoneNumber = sc.nextLine();
        int money = sc.nextInt();
        Guest guest = new Guest( name, phoneNumber, money );
        return guest;
    }

    public void confirmGuest(){

    }
}
