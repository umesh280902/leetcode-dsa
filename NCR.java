public class NCR {
    static int factorial(int n){
        int ans=1;
        for(int i=1;i<=n;i++){
            ans=ans*i;
        }
        return ans;
    }

    static int Ncr(int n,int r){
        int num=factorial(n);
        int denom=factorial(r)*factorial(n-r);
        return num/denom;
    }

    public static void main(String[] args) {
        basic.output.print(Ncr(8, 2));
    }
}
