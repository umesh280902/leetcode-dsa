public class MaximumAndMinimum{
    private static void Minimum(int arr[]){
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min=arr[i];
            }
        }
        basic.output.print(min+"\n");
    }

    private static void Maximum(int arr[]){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        basic.output.print(max+"\n");
    }

    public static void main(String args[]){
        int arr[]={12,34,51,2,6,2,35,12,4,45,3};
        Maximum(arr);
        Minimum(arr);
    }
}
