public class SelectionSort {
    private static void implementation(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            int minIndex=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;
        }
    }
    public static void main(String args[]){
        int arr[]={2,3,43,35,54,4,34,4,36,6,436,364,2,3,325,46,7686,658856};
        implementation(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}

//Time complexity is O(n^2) and space is constant O(1)