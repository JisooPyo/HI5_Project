package Hotel_Project;

import java.util.HashMap;
import java.util.Map;

public class Booking {
    String date;
    Guest guest;
    Room room;
    Integer idNumber = 1;

    Hotel hotel = new Hotel();
    Map< Integer, Booking > mapGuest = new HashMap<>();
    // Integer에는 idNumber가 들어갈 것.

    public Booking() {
    }

    public Booking( String date, Guest guest, Room room, Integer idNumber ) {
        this.date = date;
        this.guest = guest;
        this.room = room;
        this.idNumber = idNumber;
    }

    public Booking makeBooking( Guest guest ) {
        // 매개변수로 들어온 Guest와
        // Scanner로 date, 손님이 고른 Room을 받아서
        // Booking 객체를 만들어 return하는 메서드
        String date = "2023";
        Room room = new Room( "size", 0 );
        Integer idNumber = 0;
        Guest g = guest;
        Booking booking = new Booking( date, g, room, idNumber );
        this.idNumber = idNumber.intValue() + 1;
//        hotel.singleQueue().poll();
//        객실에서 하나 빼주기
//        빼면 빠지는지 확인
        return booking;

    }

    public void showBookingToManager() {

    }

    public void showBookingToGuest() {

    }
}
