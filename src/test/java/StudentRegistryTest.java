import org.junit.jupiter.api.Test;
import topic8.practice.Student;
import topic8.practice.StudentRegistry;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentRegistryTest {
    @Test
    public void testRemoveById() {
        StudentRegistry registry = new StudentRegistry();
        Student student1 = new Student("Alice", "1", "hgf");
        Student student2 = new Student("Bob", "2", "hgf1");
        registry.addStudent(student1);
        registry.addStudent(student2);

        registry.removeById("1");
    }

    @Test
    public void testFindById() {
        StudentRegistry registry = new StudentRegistry();
        Student student1 = new Student("Alice", "1", "hgf");
        registry.addStudent(student1);

        Student foundStudent = registry.findById("1");
        Student notFoundStudent = registry.findById("2");
        assertEquals(student1.getId(), foundStudent.getId());
        assertEquals(null, notFoundStudent);
    }

        @Test
    public void testContainsEmail() {
            StudentRegistry registry = new StudentRegistry();
            Student student1 = new Student("Alice", "1", "hgf");
            registry.addStudent(student1);

            boolean containsEmail = registry.containsEmail("hgf");
            boolean notContainsEmail = registry.containsEmail("hgf1");
            assertEquals(true, containsEmail);
            assertEquals(false, notContainsEmail);
    }
}
