package topic10.practice;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class Main {
    public static void main(String[] args) {
        System.out.println("---Task1---");
        ZoneId Kyiv = ZoneId.of("Europe/Kyiv");
        ZoneId Lviv = ZoneId.of("Europe/Lviv");
        ZoneId Berlin =  ZoneId.of("Europe/Berlin");
        Event event = new Event("meet", LocalDateTime.of(2026, 3,24,10,0),
                120, Kyiv, "ASD");
        Event event1 = new Event("conference", LocalDateTime.of(2026,4,5, 13, 30),
                60, Lviv, "money");
        Event event2 = new Event("dinner", LocalDateTime.of(2026, 7, 12, 17,0),
                90, Berlin, "eat");

        System.out.println("---Task2---");

        System.out.println("---Task3---");

        System.out.println("---Task4---");

    }
}
