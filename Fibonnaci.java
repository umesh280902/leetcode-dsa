public class Fibonnaci {
    public static void main(String[] args) {
        int n=12;
        int a=0;
        int b=1;
        basic.output.print(a+" "+b+" ");
        for(int i=0;i<n;i++){
            int num=a+b;
            a=b;
            b=num;
            basic.output.print(num+" ");
        }
    }
}
