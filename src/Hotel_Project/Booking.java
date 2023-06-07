package Hotel_Project;

import java.util.*;

public class Booking {
    Guest guest;
    Room room;
    Integer idNumber = 1000;
    Hotel hotel = new Hotel();
    Scanner sc = new Scanner( System.in );
    Map< Integer, Queue< Room > > mapRoom = hotel.makeMapRoom();
    // Integer에는 1,2,3,4가 들어갑니다.
    Map< Integer, Booking > mapBooking = new HashMap<>();
    // Integer에는 idNumber가 들어갑니다.
    List< Booking > bookingList = new ArrayList<>();

    public Booking () {
    }

    public Booking ( Guest guest, Room room, Integer idNumber ) {
        this.guest = guest;
        this.room = room;
        this.idNumber = idNumber;
    }


    /////////////////////////// 행복님 구현부 /////////////////////////////////////////////
    public Booking makeBooking ( Guest guest ) {
        // 매개변수로 들어온 Guest와 손님이 고른 Room을 받아서
        // Booking 객체를 만들어 return하는 메서드

        // 남은 객실의 수는 mapRoom에서 Queue<Room> 의 size 를 이용하면 될 것 같습니다.
        int choiceNumber = listRoom( guest );

        Queue< Room > pickRoom = mapRoom.get( choiceNumber ); // 2 대신 고른 room이 들어가야 함
        pickRoom.poll();


        Room room = pickRoom.peek();
        Guest g = guest;
        Booking booking = new Booking( g, room, idNumber );

//        pickRoom.poll();
//        mapRoom.put(2,pickRoom);

        // 이런식으로 객실에서 하나 빼주기
        // 예약 객체 리턴.
        return booking;

    }

    public int listRoom ( Guest guest ) {
        // 방 고르기
        int emptyRoom; // 잔여 룸 수
        int roomPrice; // 룸 가격
        int i = 1;
        String roomSize;



        // for문 으로 반복문 작성
//        for(i = 1; i < mapRoom.size()+1; i++) {
//            if(mapRoom.get(i).size() != 0){
//                System.out.println(i + ". " + mapRoom.get(i).peek().size + " | W " + mapRoom.get(i).peek().price + " | 남은 객실의 수 : " + mapRoom.get(i).size());
//            }else{
//                System.out.println(i + "번 객실은 예약이 만료되었습니다. 다른 방을 이용해 주세요.");
//            }
//        }

        // while문으로 반복문 작성 형태가 똑같아서 뭐가 좋은지
        while(i < mapRoom.size()+1){
            if(mapRoom.get(i).size() != 0){
                System.out.println(i + ". " + mapRoom.get(i).peek().size + " | W " + mapRoom.get(i).peek().price + " | 남은 객실의 수 : " + mapRoom.get(i).size());
                i++;
            }else if(mapRoom.get(i).size() == 0){
                System.out.println(i + "번 객실은 예약이 만료되었습니다. 다른 방을 이용해 주세요.");
                i++;
            }
              // 모든방 예약이 꽉 찼을 경우
//            else if(mapRoom.size() == 0 && mapRoom.get(i).size() == 0 ){
//                System.out.println("모든 방 예약이 끝났습니다.");
//                i++;
//            }
        }

        System.out.print("사용하시려는 객실의 사이즈를 선택해 주세요. : ");

        int chooseRoom = sc.nextInt();
        // switch 문으로 하여 조건에 따른 결과 다르게
        switch (chooseRoom) {
            case 1: case 2: case 3: case 4:
                if(mapRoom.get(chooseRoom).size() != 0){
                    emptyRoom = mapRoom.get(chooseRoom).size();
                    roomPrice = mapRoom.get(chooseRoom).peek().price;
                    roomSize = mapRoom.get(chooseRoom).peek().size;
                    return canBook(chooseRoom, emptyRoom, roomPrice, roomSize, guest);
                }else{
                    System.out.println("잘못된 선택입니다.");
                    System.out.println("다시 입력해 주세요");
                    return listRoom(guest);
                }
            default:
                System.out.println("잘못된 선택입니다.");
                System.out.println("다시 입력해 주세요");
                return listRoom(guest);
        }


        // if문으로 하여 조건에 따라 결과 다르게
//        if( 1 <= chooseRoom && chooseRoom <=4){
//            if(mapRoom.get(chooseRoom).size() != 0){
//                emptyRoom = mapRoom.get(chooseRoom).size();
//                roomPrice = mapRoom.get(chooseRoom).peek().price;
//                roomSize = mapRoom.get(chooseRoom).peek().size;
//                return canBook(chooseRoom, emptyRoom, roomPrice, roomSize, guest);
//            }else{
//                System.out.println("잘못된 선택입니다.");
//                System.out.println("다시 입력해 주세요");
//                System.out.println(listRoom(guest));
//                return listRoom(guest);
//            }
//        }else {
//            System.out.println("잘못된 선택입니다.");
//            System.out.println("다시 입력해 주세요");
//            System.out.println(listRoom(guest));
//            return listRoom(guest);
//        }
    }

    public int canBook ( int chooseRoom, int emptyRoom, int roomPrice, String roomSize, Guest guest ) {
        // 방 예약

        if(emptyRoom > 0 && roomPrice <= guest.money){
            System.out.println(guest.name + " 님의 예약을 확인해 주세요.");
            System.out.println("고객명 : " + guest.name);
            System.out.println("연락처 : " + guest.phoneNumber);
            System.out.println("예약날짜 : " + guest.date);
            System.out.println("객실 크기 : "  + roomSize);
            System.out.println();
            System.out.print( "예약사항이 맞으면 1번 틀리면 2번을 입력하세요 : " );
            int confirm = sc.nextInt();
            if ( confirm == 1 ) {
                System.out.println( "예약이 완료되었습니다." );
                System.out.println( "다음 예약 ID로 예약을 조회할 수 있습니다." );
                System.out.println( "예약 ID : " + idNumber );
                return chooseRoom;
            } else {
                System.out.println("너냐 범인이??");
                return listRoom( guest );
            }
        } else {
            return cantBook( emptyRoom, roomPrice, guest );
        }
    }

    public int cantBook ( int emptyRoom, int roomPrice, Guest guest ) {
        // 게스트의 소지금, 혹은 호텔 방 부족 문제로 예약 불가 상황
        if ( emptyRoom == 0 ) {  // 선택 한 룸에 방이 없을 경우
            System.out.println( "해당 객실은 현재 이용할 수 없습니다." );
            System.out.println( "다른 객실을 선택해 주세요." );

        } else if ( guest.money < roomPrice ) {  // 선택한 방의 금액이 소지 금액보다 높을경우
            System.out.println( "소지금보다 높은 객실을 선택할 수 없습니다." );
            System.out.println( "다시 선택해 주세요" );


        }
        return listRoom( guest );
    }

    ///////////////////////// 채원님 구현부 ////////////////////////////////////////////////




    public void showBookingToManager () {
        //bookingList 이용해서 for문 만들어서 출력하기. - 채원님
    }






    ////////////////////////// 지수 구현부/////////////////////////////////////////////////

    public void showBookingToGuest () {
        // mapBooking을 이용하여 idNumber에 맞는 Value값(Booking)을 찾아옵니다.
        // idNumber가 일치하면 [예약 현황]을 보여주고 1. 메인메뉴 2. 예약취소를 출력합니다.
        // 2번을 선택하면 예약을 취소할지 물어보고 1. 취소 2. 취소 안함
        // 1번을 선택하면 예약 취소 -> mapRoom 추가, mapBooking 빼기, bookingList 빼기

        // bookingList가 비어있을 경우 예약현황이 없음을 알려주고 메인화면으로 돌아갑니다.
        if ( bookingList.size() == 0 ) {
            System.out.println( "예약현황이 없습니다." );
            System.out.println( "메인화면으로 돌아갑니다.\n" );
            return;
        }
        System.out.println( "[ 예약조회 ] ( 고객용 )\n" );
        System.out.println( "예약조회를 위해 idNumber가 필요합니다." );
        System.out.println( "idNumber을 입력해주세요." );

        // 입력받은 idNumber에 따른 선택지입니다.
        // idNumber에 맞는 예약 현황이 있는 경우 예약 현황을 보여주는 bookingCheck() 메서드로 넘어가고,
        // 맞지 않을 경우 메인 화면으로 돌아갑니다.
        Integer inputIdNum = Integer.valueOf( sc.next() );
        if ( !mapBooking.keySet().contains( inputIdNum ) ) {
            System.out.println( "ID에 맞는 예약 현황이 없습니다." );
            System.out.println( "메인 화면으로 돌아갑니다.\n" );
            return;
        }
        bookingCheck( inputIdNum );

    }

    public void bookingCheck ( Integer inputIdnum ) {
        // mapBooking.get( inputIdnum ) 을 통해 Booking 객체를 얻어와 그에 대한 정보를 출력.
        System.out.println( "[ 예약현황 ]\n" );
        System.out.println( "예약번호 : " + inputIdnum );
        System.out.println( "이름 : " + mapBooking.get( inputIdnum ).guest.name );
        System.out.println( "연락처 : " + mapBooking.get( inputIdnum ).guest.phoneNumber );
        System.out.println( "예약날짜 : " + mapBooking.get( inputIdnum ).guest.date );
        System.out.println( "객실크기 : " + mapBooking.get( inputIdnum ).room.size +"\n");
        System.out.println( "1. 메인메뉴 / 2. 예약 취소" );

        // 1을 누르면 메인메뉴로 돌아가고
        // 2를 누르면 예약 취소가 가능한 cancelBookingCheck() 메서드로 넘어갑니다.
        int cancelBooking = sc.nextInt();
        String enter = sc.nextLine();

        switch ( cancelBooking ) {
            case 1: {
                return;
            }
            case 2: {
                cancelBookingCheck( inputIdnum );
                break;
            }
            default: {
                System.out.println( "잘못된 값을 입력하셨습니다. 다시 입력해 주세요." );
                bookingCheck( inputIdnum );
                break;
            }
        }
    }

    public void cancelBookingCheck ( Integer inputIdNum ) {
        System.out.println( "예약을 취소하시겠습니까?" );
        System.out.println( "1. 예 / 2. 아니오" );
        int cancelPick = sc.nextInt();
        String enter = sc.nextLine();
        switch ( cancelPick ) {
            case 1: {
                // 예약이 취소되었으므로
                // 예약한 방을 다시 mapRoom에 추가해줍니다.
                // bookingList에서 Booking 객체를 제거합니다.
                // mapBooking에서 Key값이 idNumber인 Booking을 제거합니다.
                String roomSize = mapBooking.get( inputIdNum ).room.size;
                int roomPrice = mapBooking.get( inputIdNum ).room.price;
                mapRoom.get( getRoomNumber( roomSize ) ).add( new Room( roomSize, roomPrice ) );
                //////////////////////////////////////////////
                // bookingList 잘 지워지는지 체크해봐야 함. //
                //////////////////////////////////////////////
                bookingList.remove( mapBooking.get( inputIdNum ) );
                mapBooking.remove( inputIdNum );
                System.out.println( "예약이 성공적으로 취소되었습니다.\n" );
                return;
            }
            case 2: {
                System.out.println( "예약현황으로 돌아갑니다.\n" );
                bookingCheck( inputIdNum );
                break;
            }
            default: {
                System.out.println( "잘못된 값을 입력하셨습니다. 다시 입력해 주세요." );
                cancelBookingCheck( inputIdNum );
                break;
            }
        }
    }

    public Integer getRoomNumber ( String size ) {
        // size를 입력받아 size에 맞는 mapRoom의 key값을 알려주는 메서드.
        if ( size.equals( "single" ) ) {
            return 1;
        } else if ( size.equals( "double" ) ) {
            return 2;
        } else if ( size.equals( "twin" ) ) {
            return 3;
        } else {    // size.equals("suite")
            return 4;
        }
    }
}
