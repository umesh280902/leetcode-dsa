public class BinaryToDecimal {
    public static void main(String[] args) {
        int n=110;
        int ans=0;
        int i=0;
        while(n!=0){
            int digit=n%10;
            if(digit==1){
                ans=ans+digit*(int)Math.pow(2,i);
            }
            n=n/10;
            i++;
            
        }
        basic.output.print(ans);
    }
}
