package Hotel_Project;

import java.util.Map;

public class Reservation {
    String date;
    Guest guest;
    Room room;
    String idNumber;

    public Reservation(){

    }

    public Reservation( String date, Guest guest, Room room, String idNumber ) {
        this.date = date;
        this.guest = guest;
        this.room = room;
        this.idNumber = idNumber;
    }

    //    Map<String, Reservation> mapGuest
    public Reservation reservation( Guest guest ) {
        String date = "2023";
        Room room = new Room( "size", 0 );
        String idNumber = "";
        Guest g = guest;
        Reservation reservation = new Reservation( date, g, room, idNumber );
        return reservation;
    }

    public void confirmReservation(Guest guest){

    }

    public void completeReservation(){

    }

    public void showReservationToManager(){

    }

    public void showReservationToGuest(){

    }
}
