package topic10.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class WorkoutLab {
    public List<WorkoutSession> pick(List<WorkoutSession> sessions, Predicate<WorkoutSession> condition){
        List<WorkoutSession> picked = new ArrayList<>();
        for (WorkoutSession session : sessions){
            if(condition.test(session)){
                picked.add(session);
            }
        }
        return picked;
    }
    public List<String> labels(List<WorkoutSession> sessions, Function<WorkoutSession, String> turn){
        List<String> result = new ArrayList<>();
        for(WorkoutSession session : sessions){
            result.add(turn.apply(session));
        }
        return result;
    }
    public void notifyEach(List<WorkoutSession> sessions, Consumer<WorkoutSession> action){
        for(WorkoutSession session : sessions){
            action.accept(session);
        }
    }
    public WorkoutSession create(Supplier<WorkoutSession> getting){
        return getting.get();
    }
    public int estimate(WorkoutSession session, CalorieEstimator estimator){
        return estimator.estimate(session);
    }
}
