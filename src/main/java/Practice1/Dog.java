package Practice1;

public class Dog extends Animal{
    String breed;

    public Dog (String name){
        super(name);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void eat() {
        System.out.println("dog is eating");
    }

    public void bark(){
        System.out.println("dog is barking");
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
