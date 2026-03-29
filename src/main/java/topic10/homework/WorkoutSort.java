package topic10.homework;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WorkoutSort {
    public void sortAnonymous(List<WorkoutSession> sessions){
        sessions.sort(new Comparator<WorkoutSession>(){
            @Override
            public int compare(WorkoutSession o1, WorkoutSession o2) {
                int byStart = o1.getStart().compareTo(o2.getStart());
                if(byStart!=0){
                    return byStart;
                }
                return Integer.compare(o1.getDurationMinutes(), o2.getDurationMinutes());
            }
        });
    }
    public void sortLambda(List<WorkoutSession> sessions){
        sessions.sort((o1, o2) -> o1.getStart().compareTo(o2.getStart()));
        sessions.sort((o1, o2) -> Integer.compare(o1.getDurationMinutes(), o2.getDurationMinutes()));
    }
    public void sortMethodRef(List<WorkoutSession> sessions){
        sessions.sort(Comparator.comparing(WorkoutSession::getStart)
                .thenComparing(WorkoutSession::getDurationMinutes));
    }
}
