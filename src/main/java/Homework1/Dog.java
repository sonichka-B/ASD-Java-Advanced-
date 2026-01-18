package Homework1;

import java.util.Objects;

public class Dog extends Mammal{
    private String breed;

    public Dog(String name, int age, boolean hasFur, String breed){
        super(name, age, hasFur);
        this.breed = breed;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(getName(), dog.getName()) && getAge() == dog.getAge()
                && isHasFur() ==dog.isHasFur()&& Objects.equals(breed, dog.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(),getAge(),isHasFur(),breed);
    }

}
