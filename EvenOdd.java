public class EvenOdd {
    static boolean isEven(int a){
        return (a&1)==0;
    }
    public static void main(String[] args) {
        int num=22;
        basic.output.print(isEven(num));
        
    }

}
