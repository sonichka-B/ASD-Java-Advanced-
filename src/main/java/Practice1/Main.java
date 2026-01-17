package Practice1;
public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Richard");
        System.out.println(dog);

        Dog d1 = new Dog("Calli");
        Dog d2 = new Dog("Calli");
        System.out.println(d1.equals(d2));

        Animal a = new Dog("Rex");
        Dog b = (Dog) a;
        System.out.println(b);
        d1.feed(dog);
        d2.eat();


    }
}