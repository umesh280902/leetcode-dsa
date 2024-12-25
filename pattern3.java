import basic.output;
public class pattern3 {
   public static void main(String args[]){
    for(int i=1;i<=4;i++){
        int space=i-1;
        int j=space;
        while(space>0){
            output.print(" ");
            space--;
        }

        while(j<4){
            output.print("*");
            j++;
        }
        output.print("\n");
    }
   } 
}
