package topic8.homework;

public class Main {
    public static void main(String[] args) {
        Registry<String, Student> studentRegistry = new Registry<>();
        Registry<String, Course> courseRegistry = new Registry<>();
        EnrollmentService enrollmentService = new EnrollmentService();

        Student student1 = new Student("Anna", "1", "a@email", "CS101");
        Student student2 = new Student("Bob", "2", "b@email", "CS102");
        Student student3 = new Student("Charlie", "3", "c@email", "CS101");

        Course course1 = new Course("CS101", "Intro to Computer Science", 3);
        Course course2 = new Course("CS102", "Data Structures", 4);

        System.out.println(studentRegistry.add(student1.getId(), student1));
        System.out.println(studentRegistry.add(student2.getId(), student2));
        System.out.println(studentRegistry.add(student3.getId(), student3));
        System.out.println(studentRegistry.values());
        System.out.println(studentRegistry.get(student3.getId()));
        System.out.println(studentRegistry.remove(student2.getId()));
        System.out.println(studentRegistry.values());
        System.out.println(studentRegistry.containsKey("1"));

        System.out.println(courseRegistry.add(course1.getCode(), course1));
        System.out.println(courseRegistry.add(course2.getCode(), course2));
        System.out.println(courseRegistry.get("CS101"));
        System.out.println(courseRegistry.values());

        enrollmentService.enroll("3", "CS102");
        System.out.println(enrollmentService.studentsOf("CS102"));

    }
}
