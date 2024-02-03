import java.util.*;
class Movie
{
    private String Title;
    private String Category;
    private double TicketPrice;
    public Movie(String Title,String Category,double TicketPrice)
    {
        this.Title=Title;
        this.Category=Category;
        this.TicketPrice=TicketPrice;
    }
    public String gettitle()
    {
         return Title;
    }
    public String getcategory()
    {
      return Category;
    }
    public double getticketprice()
    {
        return TicketPrice;
    }
}
class Ticket{
    private Movie movie;
    private int seatnumber;
    public Ticket(Movie movie,int seatnumber)
    {
        this.movie=movie;
        this.seatnumber=seatnumber;

    }
    public Movie getMovie()
    {
        return movie;
    }
    public int getseatnumber()
    {
        return seatnumber;
    }
    public double calculateTotalPrice()
    {
        return movie.getticketprice();
    }
}
class CinemaTicketSystem
 {
    public static void main(String[] args)
     {
    
        Movie movie1 = new Movie("SALAAR", "Action-Drama", 1000);
        Movie movie2 = new Movie("HI-NANNA", "Romantic-Drama", 500);
        Movie movie3 = new Movie("ANIMAL", "Action-Adventure", 550);
        Movie movie4 = new Movie("KEEDA-COLA", "COMEDY-CRIME", 600);
        Movie movie5 = new Movie("HANUMAN", "ACTION-SUPERHERO", 700);
        Movie movie6 = new Movie("GUNTUR KARAM", "ACTION-DRAMA", 800);
        Movie movie7 = new Movie("TIGER NAGESWAR RAO", "ACTION-DRAMA", 900);

        Ticket ticket;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Movies currently playing:");
        System.out.println("1. " + movie1.gettitle() + " - " + movie1.getcategory() + " -$ " + movie1.getticketprice());
        System.out.println("2. " + movie2.gettitle() + " - " + movie2.getcategory() + " - $" + movie2.getticketprice());
        System.out.println("2. " + movie3.gettitle() + " - " + movie3.getcategory() + " - $" + movie3.getticketprice());
        System.out.println("2. " + movie4.gettitle() + " - " + movie4.getcategory() + " - $" + movie4.getticketprice());
        System.out.println("2. " + movie5.gettitle() + " - " + movie5.getcategory() + " - $" + movie5.getticketprice());
        System.out.println("2. " + movie6.gettitle() + " - " + movie6.getcategory() + " - $" + movie6.getticketprice());
        System.out.println("2. " + movie7.gettitle() + " - " + movie7.getcategory() + " - $" + movie7.getticketprice());

    
        System.out.print("Select a movie : ");
        int selectedMovie = scanner.nextInt();

        System.out.print("Enter seat number: ");
        int seatNumber = scanner.nextInt();

        if (selectedMovie == 1)
        {
            ticket = new Ticket(movie1, seatNumber);
        }
         else if (selectedMovie == 2) 
        {
            ticket = new Ticket(movie2, seatNumber);
        } 
        else if (selectedMovie == 3) 
        {
            ticket = new Ticket(movie3, seatNumber);
        } 
        else if (selectedMovie == 4) 
        {
            ticket = new Ticket(movie4, seatNumber);
        } 
        else if (selectedMovie == 5) 
        {
            ticket = new Ticket(movie5, seatNumber);
        } 
        else if (selectedMovie == 6) 
        {
            ticket = new Ticket(movie6, seatNumber);
        } 
        else if (selectedMovie == 7) 
        {
            ticket = new Ticket(movie7, seatNumber);
        } 
        else
         {
            System.out.println("Invalid movie selection.");
            return;
        }

        System.out.println("Ticket Information:");
        System.out.println("Movie: " + ticket.getMovie().gettitle());
        System.out.println("Category: " + ticket.getMovie().getcategory());
        System.out.println("Seat Number: " + ticket.getseatnumber());
        System.out.println("Total Price: $" + ticket.calculateTotalPrice());

        scanner.close();
    }
}
