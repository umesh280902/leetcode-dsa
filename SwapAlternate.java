public class SwapAlternate {
    public static void swapArray(int arr[]){
        for(int i=0;i<arr.length;i+=2){
            if(i+1<arr.length){
                int temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
        }

        for(int i=0;i<arr.length;i++){
            basic.output.print(arr[i]+"\n");
        }
    }
    
    public static void main(String[] args){
        int even[]={1,2,3,4,5,6,7,8};
        int odd[]={1,2,3,4,5,6,7};
        swapArray(odd);
        swapArray(even);
    }   
}
