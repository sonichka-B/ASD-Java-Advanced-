package topic10.practice;

import java.util.Comparator;
import java.util.List;

public class LambdaRefactorLab {

    public void sortAnonymous(List<Event> events){
            events.sort(new Comparator<Event>() {
                @Override
                public int compare(Event o1, Event o2) {
                    return o1.getStart().compareTo(o2.getStart());
                }
            });
    }

    public void sortLambda(List<Event> events){
        events.sort((Event e1, Event e2) -> e1.getStart().compareTo(e2.getStart()));
    }

    public void sortMethodRef(List<Event> events){
        events.sort(Comparator.comparing(Event::getStart));
    }
}
