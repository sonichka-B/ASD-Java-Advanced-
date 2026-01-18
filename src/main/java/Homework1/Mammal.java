package Homework1;

public class Mammal extends Animal{
    private boolean hasFur;

    public boolean isHasFur() {
        return hasFur;
    }

    public Mammal(String name, int age, boolean hasFur){
        super(name, age);
        this.hasFur = hasFur;
    }

    @Override
    public String toString() {
        return super.toString() + ", hasFur = "+hasFur;
    }
}
