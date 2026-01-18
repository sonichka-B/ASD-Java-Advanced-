package Homework1;

public class Main {
   public static void main (String[] args){
       Dog d1 = new Dog("Archi", 23, true,"wolf");
       Dog d2 = new Dog("Siso", 13, false,"wolf");
//       Dog d3 = new Dog("Siso", 13, false,"wolf");

       System.out.println(d1==d2);
       System.out.println(d1.equals(d2));
   }



}
