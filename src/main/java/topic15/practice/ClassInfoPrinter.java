package topic15.practice;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ClassInfoPrinter {
    public void print (Class<?> clazz){
        System.out.println("Class: " + clazz.getName());
        System.out.println("SuperClass: " + clazz.getSuperclass());
        System.out.println("Interface: "+Arrays.toString(clazz.getInterfaces()));
        System.out.println("DeclaredFields");
        for (Field f : clazz.getDeclaredFields()) {
            System.out.println(f.getName() + " : " + f.getType().getSimpleName());
        }
        System.out.println("DeclaredMethods");
        for (Method m : clazz.getDeclaredMethods()) {
            System.out.println(m.getName() + " : " + m.getReturnType().getSimpleName());
        }
    }
}
