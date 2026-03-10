package topic8.practice;

import java.util.List;

public class Task2 {
    public <T>T firstOrNull(List<T> list){
        if (list.size() > 0){
            return list.get(0);
        } else {
            return null;
        }
    }
    public double sum(List<? extends Number> numbers){
        double result =0.0;
        for (Number n : numbers){
            result+=n.doubleValue();
        }
        return result;
    }

    public void addDefaultIds(List<? super Integer> ids) {
        ids.add(1);
        ids.add(2);
        ids.add(3);
    }
}
