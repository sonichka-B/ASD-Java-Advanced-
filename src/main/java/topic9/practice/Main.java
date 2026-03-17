package topic9.practice;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("volvo");
        Car car1 = new Car("BMW");
        Car.Engine engine = car.spec(23.3);
        Car.Engine engine1 = car1.spec(23.56);
        System.out.println("eng:"+engine);
        System.out.println("eng1:"+engine1);

        Library library = new Library("Baba");
        Library.Book book =  library.new Book("kyky", "kykyshka");
        System.out.println(book.bookLabel());

        Tickets tickets = new Tickets("23");
        System.out.println( tickets.buildTicketId(tickets.getBase()));
        tickets.runOnce().run();
    }
}
