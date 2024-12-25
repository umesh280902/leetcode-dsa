public class Power {
    static void PowerCalculate(int a,int b){
        int ans=1;
        for(int i=1;i<=b;i++){
            ans=ans*a;
        }
        basic.output.print(ans);
    }
    public static void main(String[] args) {
        int an=12;
        int bn=2;
        PowerCalculate(an, bn);
    }
}
