package topic10.practice;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DataTimeLab {
    public Instant ToInstant(Event e){
        return e.getStart().atZone(e.getZone()).toInstant();
    }

    public long minutesBetween(Event a, Event b){
        Duration betweenMeets =  Duration.between(ToInstant(a), ToInstant(b));
        return betweenMeets.toMinutes();
    }

    public ZonedDateTime startInZone(Event e, String zone){
        return ToInstant(e).atZone(ZoneId.of(zone));
    }
}
