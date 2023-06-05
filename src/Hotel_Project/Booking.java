package Hotel_Project;

import java.awt.print.Book;
import java.time.ZonedDateTime;
import java.util.*;

public class Booking {
    String date;
    Guest guest;
    Room room;
    Integer idNumber = 1000;
    Hotel hotel = new Hotel();
    Map< Integer, Queue< Room > > mapRoom = hotel.makeMapRoom();
    Map< Integer, Booking > mapGuest = new HashMap<>();
    // Integer에는 idNumber가 들어갈 것.
    List< Booking > bookingList = new ArrayList<>();

    public Booking() {
    }

    public Booking( String date, Guest guest, Room room, Integer idNumber ) {
        this.date = date;
        this.guest = guest;
        this.room = room;
        this.idNumber = idNumber;
    }


    /////////////////////////// 행복님 구현부 //////////////////////////////
    public Booking makeBooking( Guest guest ) {
        // 매개변수로 들어온 Guest와 손님이 고른 Room을 받아서
        // Booking 객체를 만들어 return하는 메서드

        String date = ZonedDateTime.now().toString();
        Queue<Room> pickRoom = mapRoom.get( 2 ); // 2 대신 고른 room이 들어가야 함.
        Room room = pickRoom.peek();
        Guest g = guest;
        Booking booking = new Booking( date, g, room, idNumber );
        this.idNumber = this.idNumber.intValue() + 1;

//        pickRoom.poll();
//        mapRoom.put(2,pickRoom);

        // 이런식으로 객실에서 하나 빼주기
        // 예약 객체 생성
        return booking;

    }




    ///////////////////////// 채원님 구현부 ////////////////////////////

    public void showBookingToManager() {
        //bookingList 이용해서 for문 만들어서 출력하기. - 채원님

    }




    ////////////////////////// 지수 구현부//////////////////////

    public void showBookingToGuest() {
        // mapGuest를 이용하여 idNumber에 맞는 Value값(Booking)을 찾아옵니다.
        // idNumber가 맞지 않으면 "ID에 맞는 예약 현황이 없습니다."를 출력합니다.
        // idNumber가 일치하면 [예약 현황]을 보여주고 1. 메인메뉴 2. 예약취소를 출력합니다.
        // 1번을 선택하면 메서드종료(BookProgram 클래스로 돌아가고 메인메뉴로 돌아갑니다.)
        // 2번을 선택하면 예약을 취소할지 물어보고 1. 취소 2. 취소 안함
        // 1번을 선택하면 예약 취소 -> mapRoom 추가, mapGuest 빼기, bookingList 빼기

    }
}
