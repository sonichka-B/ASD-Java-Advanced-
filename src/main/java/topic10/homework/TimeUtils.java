package topic10.homework;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeUtils {
    public Instant toInstant(WorkoutSession session){
        return session.getStart().atZone(session.getZone()).toInstant();
    }

    public long minutesBetween(WorkoutSession a, WorkoutSession b){
        return Duration.between(a.getStart(), b.getStart()).toMinutes();
    }

    public ZonedDateTime startInZone(WorkoutSession session, String zoneId){
        ZoneId zone = ZoneId.of(zoneId);
        return session.getStart().atZone(zone);
    }
}
