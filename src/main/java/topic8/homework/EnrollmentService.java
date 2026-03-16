package topic8.homework;

import java.util.*;

public class EnrollmentService {
    Map<String, Set<String>> map = new HashMap<>();
    Set<String> students = new HashSet<>();

    boolean enroll(String studentId, String courseCode){
        students.add(studentId);
        map.putIfAbsent(courseCode, students);
        return  true;
    }

    Set<String> studentsOf(String courseCode){
        return map.get(courseCode);
    }
}
