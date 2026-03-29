package topic10.homework;

import lombok.Value;

import java.time.LocalDateTime;
import java.time.ZoneId;
@Value
public class WorkoutSession {
    String title;
    LocalDateTime start;
    int durationMinutes;
    ZoneId zone;
    Intensity intensity;

    public LocalDateTime end() {
        System.out.println("end at: ");
        return start.plusMinutes(durationMinutes);
    }

    public String label(){
        return "title: " +title + ", intensity: " + intensity;
    }
}