package topic10.practice;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        System.out.println("---Task1---");
        ZoneId Kyiv = ZoneId.of("Europe/Kyiv");
        ZoneId Berlin =  ZoneId.of("Europe/Berlin");
        Event event = new Event("meet", LocalDateTime.of(2026, 3,24,10,0),
                120, Kyiv, "ASD");
        Event event1 = new Event("conference", LocalDateTime.of(2026,3,24, 10, 30),
                60, Kyiv, "money");
        Event event2 = new Event("dinner", LocalDateTime.of(2026, 7, 12, 17,0),
                90, Berlin, "eat");

        System.out.println(event.end());
        System.out.println(event2.label());
        System.out.println(event);
        System.out.println(event1);
        System.out.println(event2);

        List<Event> events = new ArrayList<>(List.of(event2,event1,event));

        System.out.println("---Task2---");
        EventLab eventLab = new EventLab();
        System.out.println(eventLab.pick(events, eventLab.morningMeet));
        eventLab.findConflicts(events);

        System.out.println("---Task3---");
        LambdaRefactorLab lambdaRefactorLab = new LambdaRefactorLab();
        System.out.println(events);
        lambdaRefactorLab.sortAnonymous(events);
        System.out.println(events);
        lambdaRefactorLab.sortLambda(events);
        System.out.println(events);
        lambdaRefactorLab.sortMethodRef(events);
        System.out.println(events);

        System.out.println("---Task4---");
        DataTimeLab dataTimeLab = new DataTimeLab();
        System.out.println(dataTimeLab.ToInstant(event));
        System.out.println(dataTimeLab.startInZone(event, "Europe/Kyiv"));
        System.out.println(dataTimeLab.minutesBetween(event, event1));
    }
}
