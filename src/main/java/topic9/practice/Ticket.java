package topic9.practice;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter@Setter
public class Ticket {
    private int priority;
    private LocalDate createdAt;

    public Ticket(int priority, LocalDate createdAt){
        this.priority = priority;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "priority=" + priority +
                ", createdAt=" + createdAt +
                '}';
    }
}
