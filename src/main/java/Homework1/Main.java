package Homework1;

public class Main {
   public static void main (String[] args) {
       Dog d1 = new Dog("Archi", 23, true, "wolf");
       Dog d2 = new Dog("Siso", 13, false, "wolf");
//       Dog d3 = new Dog("Siso", 13, false,"wolf");

       System.out.println(d1 == d2);
       System.out.println(d1.equals(d2));

       Cat c1 = new Cat("Koko", 2, true, "ginger");
       Cat c2 = new Cat("Gojo", 8, true, "black");

       Animal[] animals = {d1, d2, c1, c2};
       for (Animal animal : animals) System.out.println(animal.toString());

        feed(animals[2]);
        feed(animals[1]);
   }
       public static void feed(Animal animal){
           animal.feed();
        if(animal instanceof Dog){
            Dog dog = (Dog) animal;
            dog.makeSound();
        }
           else if(animal instanceof Cat){
               Cat cat = (Cat) animal;
               cat.makeSound();
           }

       }



}
