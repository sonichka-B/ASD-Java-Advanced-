package topic10.practice;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class EventLab {
    public List<Event> pick(List<Event> events, Predicate<Event> condition) {
        List<Event> result = new ArrayList<>();
        for(Event event: events){
            if (condition.test(event)) result.add(event);
        }
        return result;
    }

    public List<String>labels(List<Event> events, Function<Event, String> turnInto){
        List<String> result = new ArrayList<>();
        for(Event event: events){
            result.add(turnInto.apply(event));
        }
        return result;
    }

    public void notifyAll(List<Event> events, Consumer<Event> action){
        for(Event event: events){
            action.accept(event);
        }
    }

    public Event create(Supplier<Event> event){
        return event.get();
    }

    Predicate<Event> morningMeet = event -> event.getStart().getHour() < 12;
     private LocalTime startWork =  LocalTime.of(9, 0);
     private LocalTime endWork = LocalTime.of(17, 0);
     Predicate<Event>workDay = event -> event.getStart().getHour() >= startWork.getHour() && event.end().getHour() < endWork.getHour();
    Predicate<Event> eveningMeet = morningMeet.negate().and(workDay);

    public void findConflicts(List<Event> events){

    }
}
