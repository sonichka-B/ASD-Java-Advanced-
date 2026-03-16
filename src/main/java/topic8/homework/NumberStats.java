package topic8.homework;

import java.util.List;

public class NumberStats {
    double sum(List<? extends Number> numbers){
        double result = 0.0;
        for(Number number:numbers){
            result+=number.doubleValue();
        }
        return result;
    }

    double average(List<? extends Number> numbers){
        return sum(numbers)/numbers.size();
    }

    void addDefaultGrades(List<? super Integer> grades){
        grades.add(60);
        grades.add(75);
        grades.add(90);
    }
}
