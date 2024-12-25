public class PrimeNumbers {

    static boolean isPrime(int num){
        if(num<=1){
            return false;
        }
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    } 
    public static void main(String args[]){
        int n=100;
        for(int i=2;i<n;i++){
            if(isPrime(i)){
                basic.output.print(i+"\n");
            }
        }
    }
}
