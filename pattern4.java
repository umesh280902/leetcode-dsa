import basic.output;
public class pattern4 {
    public static void main(String args[]){
        int row=1;
        while(row<=4){
            int space=4-row;
            while(space>0){
                output.print(" ");
                space--;
            }
            int col=1;
            while(col<=row){
                output.print("*");
                col++;
            }
            output.print("\n");
            row++;
        }
    }   
}
