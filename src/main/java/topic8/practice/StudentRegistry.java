package topic8.practice;

import java.util.*;

public class StudentRegistry {
    private final List<Student> students = new ArrayList<>();
    private final Set<String> studentEmails = new HashSet<>();
    private final Map<String, Student> byId = new HashMap<>();

    public boolean addStudent(Student student){
        if(student == null || student.getEmail() == null || student.getId() == null){
            return false;
        }
        if(studentEmails.contains(student.getEmail()) || byId.containsKey(student.getId())){
            return false;
        }
        students.add(student);
        studentEmails.add(student.getEmail());
        byId.put(student.getId(), student);
        return true;
    }

    public Student findById (String id){
        if(byId.containsKey(id)){
            return byId.get(id);
        }
        return null;
    }

    public boolean containsEmail(String email){
        if(studentEmails.contains(email)){
            return true;
        }
        return false;
    }

    public void removeById(String id){
        if(byId.containsKey(id)){
            Student student = byId.get(id);
            students.remove(student);
            studentEmails.remove(student.getEmail());
            byId.remove(id);
        }
    }

    public int countStudents(){
        System.out.println(students.size());
    }
}
