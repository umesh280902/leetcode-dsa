public class InsertionSort {
    private static void implementation(int arr[]){
        for(int x=1;x<arr.length;x++){
            int key=arr[x];
            int y=x-1;
            while(y>=0&&arr[y]>key){
                arr[y+1]=arr[y];
                y--;
            }
            arr[y+1]=key;
        }
    }
    public static void main(String[] args) {
        int arr[]={877,0,97,0,709,79,7,3,2,79,73,53,6,3,59,20,60,35,2,6,0,6,3,25,0,6,0,935};
        implementation(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}

