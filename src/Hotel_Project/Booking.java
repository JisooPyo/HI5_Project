package Hotel_Project;

import java.text.SimpleDateFormat;
import java.util.*;

public class Booking {
    private Guest guest;
    private Room room;
    private String idNumber;
    private String date;
    private Hotel hotel = new Hotel();
    Scanner sc = new Scanner( System.in );
    private Map< Integer, Queue< Room > > mapRoom = hotel.makeMapRoom();
    // Integer에는 1,2,3,4가 들어갑니다.
    private Map< String, Booking > mapBooking = new HashMap<>();
    // Integer에는 idNumber가 들어갑니다.
    private List< Booking > bookingList = new ArrayList<>();

    public Booking() {
    }

    public Booking( Guest guest, Room room, String idNumber ) {
        this.guest = guest;
        this.room = room;
        this.idNumber = idNumber;
    }


    /////////////////////////// 행복님 구현부 /////////////////////////////////////////////

    // Booking 객체를 만들어 return하는 메서드
    // 매개변수로 들어온 Guest와 손님이 고른 Room을 받아서
    public Booking makeBooking( Guest guest ) {
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss+hh:mm" );
        Date now = new Date();

        // 방 목록 출력
        // while문으로 반복문 작성 --> for문이 더 가독성이 있어보여서 for문으로 바꿨습니다.
        for ( int i = 1; i <= mapRoom.size(); i++ ) {
            if ( mapRoom.get( i ).size() != 0 ) {
                System.out.println( i + ". " + mapRoom.get( i ).peek().size + " | W " + mapRoom.get( i ).peek().price + " | 남은 객실의 수 : " + mapRoom.get( i ).size() );
            } else if ( mapRoom.get( i ).size() == 0 ) {
                System.out.println( i + "번 객실은 예약이 만료되었습니다. 다른 방을 이용해 주세요." );
            }
        }

        int choiceNumber = listRoom();
        if ( canBook( guest, choiceNumber ) ) {
            Queue< Room > pickRoom = mapRoom.get( choiceNumber );
            Room room = pickRoom.peek();

            Booking booking = new Booking( guest, room, idNumber );
            booking.idNumber = UUID.randomUUID().toString();
            booking.date = sdf.format( now );

            System.out.println( "예약이 완료되었습니다.\n" );
            System.out.println( "다음 예약 ID로 예약을 조회할 수 있습니다." );
            System.out.println( "예약 ID : " + booking.idNumber );
            System.out.println( "예약 날짜 : " + booking.date + "\n" );

            bookingList.add( booking );
            mapBooking.put( booking.idNumber, booking );

            pickRoom.poll();

            return booking;
        } else {
            return makeBooking( guest );
        }
    }

    // 고객이 방을 고른 번호 출력하는 메서드
    private int listRoom() {
        System.out.print( "사용하시려는 객실의 사이즈를 선택해 주세요. : " );

        int chooseRoom = sc.nextInt();
        // switch 문으로 하여 조건에 따른 결과 다르게
        switch ( chooseRoom ) {
            case 1: case 2: case 3: case 4:
                if ( mapRoom.get( chooseRoom ).size() != 0 ) {
                    int emptyRoom = mapRoom.get( chooseRoom ).size();   // 잔여 룸 수
                    int roomPrice = mapRoom.get( chooseRoom ).peek().price;     // 룸 가격
                    String roomSize = mapRoom.get( chooseRoom ).peek().size;    // 룸 크기
                    return chooseRoom;
                } else {
                    System.out.println( "잔여룸 수가 없습니다." );
                    System.out.println( "다시 선택해 주세요" );
                    return listRoom();
                }
            default:
                System.out.println( "잘못된 값을 입력하셨습니다. 다시 입력해 주세요." );
                System.out.println( "다시 입력해 주세요" );
                return listRoom();
        }
    }

    private boolean canBook( Guest guest, int chooseRoom ) {
        // 방 예약가능한지 boolean으로 return
        int emptyRoom = mapRoom.get( chooseRoom ).size();
        int roomPrice = mapRoom.get( chooseRoom ).peek().price;
        String roomSize = mapRoom.get( chooseRoom ).peek().size;

        if ( emptyRoom > 0 && roomPrice <= guest.money ) {
            System.out.println( "\n" + guest.name + " 님의 예약을 확인해 주세요." );
            System.out.println( "고객명 : " + guest.name );
            System.out.println( "연락처 : " + guest.phoneNumber );
            System.out.println( "객실 크기 : " + roomSize + "\n" );
            System.out.print( "예약사항이 맞으면 1번 틀리면 2번을 입력하세요 : " );

            int confirm = sc.nextInt();
            if ( confirm == 1 ) {
                return true;
            } else {
                System.out.println( "다시 예약을 진행합니다." );
                return false;
            }
        } else {
            return cantBook( emptyRoom, roomPrice, guest );
        }
    }

    private boolean cantBook( int emptyRoom, int roomPrice, Guest guest ) {
        // 게스트의 소지금, 혹은 호텔 방 부족 문제로 예약 불가 상황
        if ( emptyRoom == 0 ) {  // 선택 한 룸에 방이 없을 경우
            System.out.println( "해당 객실은 현재 이용할 수 없습니다." );
            System.out.println( "다른 객실을 선택해 주세요." );

        } else if ( guest.money < roomPrice ) {  // 선택한 방의 금액이 소지 금액보다 높을경우
            System.out.println( "소지금보다 높은 객실을 선택할 수 없습니다." );
            System.out.println( "다시 선택해 주세요" );

        }
        System.out.println( "다시 예약을 진행합니다.\n" );
        return false;
    }

    ///////////////////////// 지수 구현부... ////////////////////////////////////////////////

    public void showBookingToManager() {
        // 예약목록(bookingList)이 비어있으면 메인화면으로 돌아간다.
        if ( bookingList.size() == 0 ) {
            System.out.println( "예약목록이 없습니다." );
            System.out.println( "메인화면으로 이동합니다.\n" );
            return;
        }

        // 비밀번호를 입력해야 전체 예약 목록을 확인할 수 있다.
        System.out.println( "예약현황을 보시려면 비밀번호가 필요합니다." );
        System.out.println( "비밀번호를 입력해 주세요." );

        // 비밀번호가 일치하지 않을 시, 메인 화면으로 되돌아간다.
        String password = sc.next();
        if ( !password.equals( "HI5HOTEL" ) ) {
            System.out.println( "비밀번호가 일치하지 않습니다." );
            System.out.println( "메인화면으로 이동합니다.\n" );
            return;
        }

        // 비밀번호가 일치할 시 for문으로 전체 예약 목록을 조회할 수 있다.
        System.out.println( "[ HI5 호텔 전체 예약 목록 조회 ]\n" );
        for ( int i = 0; i < bookingList.size(); i++ ) {
            System.out.println( "--------   idNumber : " + bookingList.get( i ).idNumber + "   --------" );
            System.out.println( "날짜 : " + bookingList.get( i ).date );
            System.out.println( "이름 : " + bookingList.get( i ).guest.name );
            System.out.println( "연락처 : " + bookingList.get( i ).guest.phoneNumber );
            System.out.println( "객실 사이즈 : " + bookingList.get( i ).room.size + "\n" );
        }

        // 전체 예약 목록을 모두 조회하고 나면 메인화면으로 되돌아간다.
        System.out.println( "메인화면으로 돌아갑니다." );
    }


    ////////////////////////// 지수 구현부/////////////////////////////////////////////////

    public void showBookingToGuest() {
        // 예약목록(bookingList)이 비어있으면 메인화면으로 돌아간다.
        if ( bookingList.size() == 0 ) {
            System.out.println( "예약현황이 없습니다." );
            System.out.println( "메인화면으로 돌아갑니다.\n" );
            return;
        }

        // 예약목록 조회를 위해 idNumber을 받는다.
        System.out.println( "[ 예약조회 ] ( 고객용 )\n" );
        System.out.println( "예약조회를 위해 idNumber가 필요합니다." );
        System.out.println( "idNumber을 입력해주세요." );

        // 입력받은 idNumber에 따른 선택지.
        // idNumber에 맞는 예약 현황이 있는 경우 예약 현황을 보여주는 bookingCheck() 메서드로 넘어가고,
        // 맞지 않을 경우 메인 화면으로 돌아갑니다.
        String inputIdNum = sc.next();
        if ( !mapBooking.keySet().contains( inputIdNum ) ) {
            System.out.println( "ID에 맞는 예약 현황이 없습니다." );
            System.out.println( "메인 화면으로 돌아갑니다.\n" );
            return;
        }
        bookingCheck( inputIdNum );

    }

    private void bookingCheck( String inputIdnum ) {
        // mapBooking.get( inputIdnum ) 을 통해 Booking 객체를 얻어와 그에 대한 정보를 출력.
        System.out.println( "[ 예약현황 ]\n" );
        System.out.println( "예약번호 : " + inputIdnum );
        System.out.println( "이름 : " + mapBooking.get( inputIdnum ).guest.name );
        System.out.println( "연락처 : " + mapBooking.get( inputIdnum ).guest.phoneNumber );
        System.out.println( "예약날짜 : " + mapBooking.get( inputIdnum ).date );
        System.out.println( "객실크기 : " + mapBooking.get( inputIdnum ).room.size + "\n" );
        System.out.println( "1. 메인메뉴 / 2. 예약 취소" );

        int cancelBooking = sc.nextInt();
        String enter = sc.nextLine();

        switch ( cancelBooking ) {
            case 1: {
                // 1을 누르면 메인메뉴로 돌아간다.
                return;
            }
            case 2: {
                // 2를 누르면 예약 취소가 가능한 cancelBookingCheck() 메서드로 넘어간다.
                cancelBookingCheck( inputIdnum );
                break;
            }
            default: {
                // 1, 2의 값이 아닌 다른 값을 입력하면 현재 메서드로 되돌아온다.
                System.out.println( "잘못된 값을 입력하셨습니다. 다시 입력해 주세요." );
                bookingCheck( inputIdnum );
                break;
            }
        }
    }

    private void cancelBookingCheck( String inputIdNum ) {
        System.out.println( "예약을 취소하시겠습니까?" );
        System.out.println( "1. 예 / 2. 아니오" );
        int cancelPick = sc.nextInt();
        String enter = sc.nextLine();
        switch ( cancelPick ) {
            case 1: {
                // 예약 취소
                String roomSize = mapBooking.get( inputIdNum ).room.size;
                int roomPrice = mapBooking.get( inputIdNum ).room.price;

                // 예약한 방을 다시 mapRoom에 추가.
                // getRoomNumber 메서드는 roomSize에 따라 mapRoom의 key값을 알려주는 메서드이다.
                // ex. "single" -> (Key) 1 -> (Value)SingleQueue
                mapRoom.get( getRoomNumber( roomSize ) ).add( new Room( roomSize, roomPrice ) );

                //bookingList에서 Booking 객체를 제거.
                bookingList.remove( mapBooking.get( inputIdNum ) );

                // mapBooking에서 Key값이 idNumber인 Booking을 제거.
                mapBooking.remove( inputIdNum );
                System.out.println( "예약이 성공적으로 취소되었습니다.\n" );

                // 메인 화면으로 돌아간다.
                return;
            }
            case 2: {
                // 자신의 예약현황을 볼 수 있는 bookingCheck() 메서드로 되돌아간다.
                System.out.println( "예약현황으로 돌아갑니다.\n" );
                bookingCheck( inputIdNum );
                break;
            }
            default: {
                // 1, 2의 값이 아닌 다른 값을 입력하면 현재 메서드로 되돌아온다.
                System.out.println( "잘못된 값을 입력하셨습니다. 다시 입력해 주세요." );
                cancelBookingCheck( inputIdNum );
                break;
            }
        }
    }

    private Integer getRoomNumber( String size ) {
        // size를 입력받아 size에 맞는 mapRoom의 key값을 알려주는 메서드.
        Map< String, Integer > roomNumber = new HashMap<>();
        roomNumber.put( "single", 1 );
        roomNumber.put( "double", 2 );
        roomNumber.put( "twin", 3 );
        roomNumber.put( "suite", 4 );
        return roomNumber.get( size );
    }
}
