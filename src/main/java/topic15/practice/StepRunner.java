package topic15.practice;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;


public class StepRunner {
    public void run(Object target){
        Class<?> clazz = target.getClass();
        List<Method> methods = Arrays.stream(clazz.getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(Step.class))
                .peek(this::checkValidation)
                .sorted(Comparator.comparingInt(method -> method.getAnnotation(Step.class).order()))
                .toList();

        for(Method method: methods){
            method.setAccessible(true);
            try{
                method.invoke(target);
            }catch (IllegalAccessException e){
                throw new StepException(e.getMessage());
            } catch (InvocationTargetException e) {
                Throwable cause = e.getCause();
                throw new StepException("problem:"+cause.toString(), cause);
            }
        }
        System.out.println(methods);
    }

   private void  checkValidation (Method method) {
        if (method.getReturnType() != void.class) {
            throw new StepException("method " + method.getName() + " return type must be void");
        }
        if (method.getParameterCount() > 0) {
            throw new StepException("method " + method.getName() + " parameter count must be 0");
        }}
}
