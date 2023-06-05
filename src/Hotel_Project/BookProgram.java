package Hotel_Project;

public class BookProgram {
    Guest guest = new Guest();
    Booking booking = new Booking();

    public void onProgram(){
        System.out.println("[ HI5 호텔 예약 프로그램 ]");
        guestScreen();
    }

    public void guestScreen(){
        Guest g = guest.inputGuest();
        Booking r = bookingScreen( g );
    }

    public Booking bookingScreen(Guest g){
        booking.makeBooking( g );

        return new Booking();
    }

    public void checkBookingManager(){

    }

    public void checkBookingGuest(){

    }

    public void offProgram(){

    }
}
