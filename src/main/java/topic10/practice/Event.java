package topic10.practice;

import lombok.Value;

import java.time.LocalDateTime;
import java.time.ZoneId;
@Value
public class Event {
    String title;
    LocalDateTime start;
    long durationMinutes;
    ZoneId zone;
    String track;

    public LocalDateTime end(){
        return start.plusMinutes(durationMinutes);
    }

    public String label(){
        return "title:"+title+ ", track:"+track;
    }
}
