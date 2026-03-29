package topic10.homework;
@FunctionalInterface
public interface CalorieEstimator {
    int estimate(WorkoutSession session);
}
