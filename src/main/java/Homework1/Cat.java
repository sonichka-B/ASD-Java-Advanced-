package Homework1;

import java.util.Objects;

public class Cat extends Mammal{
    private String color;

    public Cat(String name, int age, boolean hasFur, String color){
        super(name, age, hasFur);
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(color, cat.color);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(color);
    }
}
