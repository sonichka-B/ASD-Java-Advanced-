package topic9.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TicketComparators {
    List<Ticket> tickets = new ArrayList<>();
    public static final Comparator<Ticket> BY_PRIORITY = new CompareByPriority();
    public static final Comparator<Ticket> BY_CREATED_AT = new CompareByCreatedAt();

    public static class CompareByPriority implements Comparator<Ticket>{
        @Override
        public int compare(Ticket o1, Ticket o2) {
            return Integer.compare(o1.getPriority(), o2.getPriority());
        }
    }

    public static class CompareByCreatedAt implements Comparator<Ticket>{
        @Override
        public int compare(Ticket o1, Ticket o2) {
            return o1.getCreatedAt().compareTo(o2.getCreatedAt());
        }
    }

    public List<Ticket> sorting(List<Ticket> tickets){
        tickets.sort(new Comparator<Ticket>() {
            @Override
            public int compare(Ticket o1, Ticket o2) {
                int byPriority = o1.getPriority() - o2.getPriority();
                if(byPriority !=0) return byPriority;

                return o1.getCreatedAt().compareTo(o2.getCreatedAt());
            }
        });
        return tickets;
    }

    public List<Ticket> sortLam(List<Ticket>tickets){
        tickets.sort(Comparator.comparing(Ticket::getCreatedAt));
        return tickets;
    }
}
