package topic10.homework;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        WorkoutLab workoutLab = new WorkoutLab();
        WorkoutSort workoutSort = new WorkoutSort();
        ZoneId Kyiv = ZoneId.of("Europe/Kyiv");
        WorkoutSession running = new WorkoutSession("run", LocalDateTime.of(2026,3,29,7,0), 20, Kyiv, Intensity.MEDIUM);
        WorkoutSession abs = new WorkoutSession("abs", LocalDateTime.of(2026, 3, 29, 8, 25), 10, Kyiv, Intensity.HIGH);
        WorkoutSession legs = new WorkoutSession("legs", LocalDateTime.of(2026, 3,29,20,50), 15, Kyiv, Intensity.LOW);
        WorkoutSession arms = new WorkoutSession("arms", LocalDateTime.of(2026, 3,29,13,9), 15, Kyiv, Intensity.HIGH);

        List<WorkoutSession> workoutSessions = new ArrayList<>();
        workoutSessions.add(running);
        workoutSessions.add(abs);
        workoutSessions.add(legs);
        workoutSessions.add(arms);

        Predicate<WorkoutSession> byIntensity = workoutSession -> workoutSession.getIntensity() == Intensity.HIGH;
        Predicate<WorkoutSession> isMorning = workoutSession -> workoutSession.getStart().getHour() <=9;
        System.out.println("pick if intensity is high of it's morning: " + workoutLab.pick(workoutSessions, byIntensity.or(isMorning)));

        System.out.println("labels:");
        List<String> labels = workoutLab.labels(workoutSessions, WorkoutSession::label);
        labels.forEach(System.out::println);

        CalorieEstimator estimator = session -> {
            int baseAmount = session.getDurationMinutes()*5;
            if(session.getIntensity() == Intensity.MEDIUM){
                return baseAmount*2;
            }
            else if(session.getIntensity() == Intensity.HIGH){
                return baseAmount*3;
            }
            return baseAmount;
        };
        int calories = workoutLab.estimate(running, estimator);
        System.out.println(running.getTitle()+ ", burned: "+calories + " calories");

        System.out.println(workoutSessions);
        workoutSort.sortAnonymous(workoutSessions);
        System.out.println(workoutSessions);
        workoutSort.sortLambda(workoutSessions);
        System.out.println(workoutSessions);
        workoutSort.sortMethodRef(workoutSessions);
        System.out.println(workoutSessions);



    }
}
