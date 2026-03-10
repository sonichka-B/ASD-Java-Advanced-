package topic8.practice;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        System.out.println("-- Task 1 --");
//
//        Task1 list1 = new Task1();
//        list1.addF("Water");
//        list1.addF(123);
//
//        for (Object o : list1.listFalse) {
//            String s = (String) o;
//            System.out.println(s);
//        }
//        Task1 list2 = new Task1();
//        list2.addT("Hello");
//        list2.addT("World");
////        list2.addT(123);
//        for (String s : list2.listTrue) {
//            System.out.println(s);
//        }

//        System.out.println("-- Task 2 --");
//
//        Task2 task2 = new Task2();
//        String s = task2.firstOrNull(List.of("A", "B", "C"));
//        System.out.println(s);
//        List<Integer> emptyList = List.of();
//        Integer i = task2.firstOrNull(emptyList);
//        System.out.println(i);
//
//        List<Integer> forSum = List.of(1, 2, 3);
//        System.out.println(task2.sum(forSum));
//
//        List<Integer> results = new ArrayList<>(List.of(7, 5, 9));
//        task2.addDefaultIds(results);
//        System.out.println(results);

        System.out.println("-- Task 3 --");

        StudentRegistry registry = new StudentRegistry();
        Student student1 = new Student("Anna", "1", "anna@email.com");
        Student student2 = new Student("Bob", "2", "bob@email.com");
        Student student3 = new Student("Charlie", "3", "bob@email.com");

        System.out.println(registry.addStudent(student1));
        System.out.println(registry.addStudent(student2));
        System.out.println(registry.addStudent(student3));
        System.out.println(registry.countStudents());

        registry.findById("1");
        registry.findById("4");
        System.out.println(registry.containsEmail("anna@email.com"));
        System.out.println(registry.containsEmail("gffg"));
        registry.removeById("3");
        System.out.println(registry.countStudents());



    }
}
