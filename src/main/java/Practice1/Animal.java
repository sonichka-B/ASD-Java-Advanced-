package Practice1;

import java.util.Objects;

public class Animal {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name);
    }

    public void eat(){
        System.out.println("eating");
    }

    public void feed (Animal animal){
        System.out.println(animal +"is fed");
        if(animal instanceof Dog dog){
            dog = (Dog) animal;
            dog.bark();
        }
    }
}
