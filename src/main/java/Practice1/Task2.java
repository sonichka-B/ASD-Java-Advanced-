package Practice1;

public class Task2 {
    public static void main (String[] args){
        String first = new String("hello");
        String second = new String("hello");

        System.out.println(first == second);
        System.out.println(first.equals(second));

        for (int i = -128; i<=127; i++ ){
            Integer x = i;
            Integer y = i;
            System.out.println(x == y);
            System.out.println(x.equals(y));
        }
    }
}
