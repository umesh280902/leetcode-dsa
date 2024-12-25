package basic;

public class output {
    public static <T> void  print(T element){
        System.out.print(element);
    }

    public static <T> void print(T[] array){
        for( T element:array){
            System.out.print(element);
        }
    }
}
